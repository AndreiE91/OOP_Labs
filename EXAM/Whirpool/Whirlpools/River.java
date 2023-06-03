import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.util.ListIterator;

public class River
{
    Scanner sc;
    ArrayList<MovingObject> listOfMovables;
    char [][] water = new char[14][86];
    Bridge bridge;
    public River()
    {
        File f = null;
        FileReader fr = null;
        listOfMovables= new ArrayList<MovingObject>();
        try
        {
            f = new File("config.dat");
        }
        catch (NullPointerException e)
        {
            System.out.println("No config.dat");
            System.exit(1);
        }
        try
        {
            fr = new FileReader(f);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Nu am config.dat");
            System.exit(1);
        }
        //         catch (IOException e)
        //         {
        //             System.out.println("Eroare I/E");
        //             System.exit(1);
        //         }
        sc = new Scanner(fr);
        try
        {
            readConfig();
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Bad configuration");
            System.exit(1);
        }
        catch (IllegalStateException e)
        {
            System.out.println("Input error");
            System.exit(2);
        }
    }

    public String toString()
    {
        String s = "";
        int [] nbWhirlpools = new int [86] ;
        for (int i = 0; i < 86; i++)
            nbWhirlpools[i] = 0;
        initWater();
        // cauta toate obiectele de pe riu sau de lansat
        ArrayList <MovingObject> listOfRemovables = new ArrayList<MovingObject>();
        for (MovingObject o : listOfMovables)
        {
            int pos[] = o.getPosition();
            if (pos[0] < 15) 
            {
                if (o.getClass().getName() == "Whirlpool")
                {
                    if (pos[0] == 0) nbWhirlpools[pos[1]]++; // vartej in rowul zero
                    else water[pos[0] - 1][pos[1]] = 'W';
                }
                else if (o.getClass().getName() == "Ship")
                {
                    water[pos[0] - 1][pos[1]] = 'S';
                }
            }
            else
            {   // in out riului
                listOfRemovables.add(o);
            }
        }
        listOfMovables.removeAll(listOfRemovables);
        listOfRemovables.clear();
        for (int i = 0; i < 86; i++)
        {
            if (nbWhirlpools[i] > 0)
                s += nbWhirlpools[i] + "(" + i + ") ";
        }
        s += "\n";
        // add the water area
        for (int i = 0; i < water.length; i++)
        {
            s += new String(water[i]) + "\n";
        }
        s += bridge;
        return s;
    }

    private int[] getWhirlpoolPositions()
    {
        int posWhirlpools[] = new int[86];
        for (int i = 0; i < 86; i++)
            posWhirlpools[i] = 0;

        for (MovingObject o : listOfMovables) 
        {
            int pos[] = o.getPosition();
            if (o.getClass().getName() == "Whirlpool")
            {
                posWhirlpools[pos[1]]++; // vartej in column pos[1]
            }
        }
        return posWhirlpools;
    }

    private int[] getWhirlpoolsToLaunch()
    {
        int posWhirlpools[] = new int[86];
        for (int i = 0; i < 86; i++)
            posWhirlpools[i] = 0;

        for (MovingObject o : listOfMovables) 
        {
            int pos[] = o.getPosition();
            if (o.getClass().getName() == "Whirlpool")
            {
                if (pos[0] == 0) posWhirlpools[pos[1]]++; // vartej in rowul zero
            }
        }
        return posWhirlpools;
    }

    public boolean moreWhirlpools()
    {
        int [] whirlpoolsToLaunch = getWhirlpoolsToLaunch();
        for (int i=0; i < whirlpoolsToLaunch.length;i++)
            if (whirlpoolsToLaunch[i] > 0) return true;
        return false;
    }

    public void doStep()
    {
        boolean bridgeHit = false;
        Scanner sc = new Scanner(System.in);
        ArrayList <Integer> launchedWhirlpools = new ArrayList<Integer>();
        ArrayList <MovingObject> listOfRemovables = new ArrayList<MovingObject>();
        out:
        while(moreWhirlpools() && !bridgeHit)
        {
            // print configuration
            System.out.print(this + "\nPress Enter");
            sc.nextLine();

            int i = 0;
            // move vartejurile
            for (MovingObject o : listOfMovables)
            {
                if (o.getClass().getName() == "Whirlpool")
                {
                    int [] pos = o.getPosition();
                    if (pos[0] > 0) // move only whirlpools in the water
                    {
                        o.move();
                    }
                    else if (!launchedWhirlpools.contains(pos[1]))
                    {   // if we did not launch from this column before
                        launchedWhirlpools.add(pos[1]);
                        o.move();
                    }
                }
            }
            launchedWhirlpools.clear();
            // check if boat caught
            for (MovingObject v : listOfMovables)
            {
                if (v.getClass().getName() == "Whirlpool")
                {
                    int [] posWhirlpool = v.getPosition();
                    for (MovingObject b : listOfMovables )
                    {
                        if (b.getClass().getName() == "Ship")
                        {
                            int [] posShip = b.getPosition();
                            if (posShip[0] == posWhirlpool[0] && posShip[1] == posWhirlpool[1])
                            { // they are on the same position; sink boat
                                listOfRemovables.add(b);
                                listOfRemovables.add(v);
                                break;
                            }
                        }
                    }
                }
            }
            // remove sunk boats and corresponding whirlpools
            listOfMovables.removeAll(listOfRemovables);
            listOfRemovables.clear();
            int [] posWhirlpools = getWhirlpoolPositions();
            // move barcile
            for (MovingObject o : listOfMovables) 
            {
                if (o.getClass().getName() == "Ship")
                {
                    int [] posShip = o.getPosition();
                    for (int j = 0; j < posWhirlpools.length; j++)
                        if (posWhirlpools[j] > 0)
                        {
                            if (posShip[1] != j)
                            {
                                o.move();
                                break;
                            }
                    }
                }
            }

            for (MovingObject o : listOfMovables) 
            {
                if (o.getClass().getName() == "Ship")
                {
                    int [] pos = o.getPosition();
                    if (pos[0] > 14 && bridge.iAmHit(pos[1]))
                    {
                        System.out.println("Ship: r=" + pos[0] + " c=" + pos[1]); 
                        bridgeHit = true;
                        break out;
                    }
                }
            }

        }
        System.out.println("Done." + ((bridgeHit)? " Bridge was hit.": " Gata vartejuri"));
    }

    public static void main (String[] args)
    {
        River r = new River();
        r.doStep();
    }

    private void initWater()
    {
        for (int i = 0; i < water.length; i++)
            for (int j = 0; j < water[i].length; j++)
                water[i][j] = '.';
    }

    private void readConfig() throws NoSuchElementException, IllegalStateException
    {
        readWhirlpools(sc);
        for (int i = 1; i <= 14; i++)
        {
            readWater(sc, i);
        }
        readBridge(sc);
    }

    private void readWhirlpools(Scanner sc) throws NoSuchElementException, IllegalStateException
    {
        String line= sc.nextLine();
        int i=0; 
        while (i < line.length())
        {
            while (Character.isWhitespace(line.charAt(i))) i++; // skip spaces
            if(Character.isDigit(line.charAt(i))) // beginning of whirlpool column spec
            {
                int nbWhirlpools = Integer.parseInt(line.substring(i,i+1));
                i += 2; // skip '('
                int k = i;
                while (line.charAt(k) != ')') k++; // look for ')'
                int colWhirlpools = Integer.parseInt(line.substring(i,k));
                while (nbWhirlpools-- > 0)
                {
                    listOfMovables.add(new Whirlpool(0, colWhirlpools, 'W'));
                }
                i = k + 2; // skip ')'
            }
        }
    }

    private void readWater(Scanner sc, int row)  throws NoSuchElementException, IllegalStateException
    {
        String line= sc.nextLine();
        for(int i = 0; i < line.length(); i++)
        {
            if (line.charAt(i) == 'S')
            {
                listOfMovables.add(new Ship(row, i, 'S', this));
            }
        }
    }

    private void readBridge(Scanner sc)  throws NoSuchElementException, IllegalStateException
    {
        bridge= new Bridge(sc.nextLine());
    }
}
