import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.util.ListIterator;

public class Rau
{
    Scanner sc;
    ArrayList<ObiectMiscator> listaMutabile;
    char [][] apa = new char[14][86];
    Pod pod;
    public Rau()
    {
        File f = null;
        FileReader fr = null;
        listaMutabile= new ArrayList<ObiectMiscator>();
        try
        {
            f = new File("config.dat");
        }
        catch (NullPointerException e)
        {
            System.out.println("Nu am config.dat");
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
            citesteConfig();
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Configuratie gresita");
            System.exit(1);
        }
        catch (IllegalStateException e)
        {
            System.out.println("Eraoare intrare");
            System.exit(2);
        }
    }

    public String toString()
    {
        String s = "";
        int [] nrVartejuri = new int [86] ;
        for (int i = 0; i < 86; i++)
            nrVartejuri[i] = 0;
        initApa();
        // cauta toate obiectele de pe riu sau de lansat
        ArrayList <ObiectMiscator> eliminabile = new ArrayList<ObiectMiscator>();
        for (ObiectMiscator o : listaMutabile)
        {
            int pos[] = o.getPozitie();
            if (pos[0] < 15) 
            {
                if (o.getClass().getName() == "Vartej")
                {
                    if (pos[0] == 0) nrVartejuri[pos[1]]++; // vartej in rindul zero
                    else apa[pos[0] - 1][pos[1]] = 'W';
                }
                else if (o.getClass().getName() == "Barca")
                {
                    apa[pos[0] - 1][pos[1]] = 'S';
                }
            }
            else
            {   // in afara riului
                eliminabile.add(o);
            }
        }
        listaMutabile.removeAll(eliminabile);
        eliminabile.clear();
        for (int i = 0; i < 86; i++)
        {
            if (nrVartejuri[i] > 0)
                s += nrVartejuri[i] + "(" + i + ") ";
        }
        s += "\n";
        // adauga apa
        for (int i = 0; i < apa.length; i++)
        {
            s += new String(apa[i]) + "\n";
        }
        s += pod;
        return s;
    }

    private int[] getPosVartejuri()
    {
        int posVartejuri[] = new int[86];
        for (int i = 0; i < 86; i++)
            posVartejuri[i] = 0;

        for (ObiectMiscator o : listaMutabile) 
        {
            int pos[] = o.getPozitie();
            if (o.getClass().getName() == "Vartej")
            {
                posVartejuri[pos[1]]++; // vartej in coloana pos[1]
            }
        }
        return posVartejuri;
    }

    private int[] getVartejuriDeLansat()
    {
        int posVartejuri[] = new int[86];
        for (int i = 0; i < 86; i++)
            posVartejuri[i] = 0;

        for (ObiectMiscator o : listaMutabile) 
        {
            int pos[] = o.getPozitie();
            if (o.getClass().getName() == "Vartej")
            {
                if (pos[0] == 0) posVartejuri[pos[1]]++; // vartej in rindul zero
            }
        }
        return posVartejuri;
    }

    public boolean maiSuntVartejuri()
    {
        int [] vartejuriDeLansat = getVartejuriDeLansat();
        for (int i=0; i < vartejuriDeLansat.length;i++)
            if (vartejuriDeLansat[i] > 0) return true;
        return false;
    }

    public void executaPas()
    {
        boolean podLovit = false;
        Scanner sc = new Scanner(System.in);
        ArrayList <Integer> lansate = new ArrayList<Integer>();
        ArrayList <ObiectMiscator> eliminabile = new ArrayList<ObiectMiscator>();
        afara:
        while(maiSuntVartejuri() && !podLovit)
        {
            // tipareste configuratia
            System.out.print(this + "\nApasa Enter");
            sc.nextLine();

            int i = 0;
            // muta vartejurile
            for (ObiectMiscator o : listaMutabile)
            {
                if (o.getClass().getName() == "Vartej")
                {
                    int [] pos = o.getPozitie();
                    if (pos[0] > 0) // muta doar virtejuri din apa
                    {
                        o.muta();
                    }
                    else if (!lansate.contains(pos[1]))
                    {   // daca nu am mai lansat din coloana asta
                        lansate.add(pos[1]);
                        o.muta();
                    }
                }
            }
            lansate.clear();
            // verifica daca a prins barca
            for (ObiectMiscator v : listaMutabile)
            {
                if (v.getClass().getName() == "Vartej")
                {
                    int [] posVartej = v.getPozitie();
                    for (ObiectMiscator b : listaMutabile )
                    {
                        if (b.getClass().getName() == "Barca")
                        {
                            int [] posBarca = b.getPozitie();
                            if (posBarca[0] == posVartej[0] && posBarca[1] == posVartej[1])
                            { // sunt peacceasi pozitie; scufunda barca
                                eliminabile.add(b);
                                eliminabile.add(v);
                                break;
                            }
                        }
                    }
                }
            }
            // elimina barcile scufundate si virtejurile corespunzatoare
            listaMutabile.removeAll(eliminabile);
            eliminabile.clear();
            int [] posVartejuri = getPosVartejuri();
            // muta barcile
            for (ObiectMiscator o : listaMutabile) 
            {
                if (o.getClass().getName() == "Barca")
                {
                    int [] posBarca = o.getPozitie();
                    for (int j = 0; j < posVartejuri.length; j++)
                        if (posVartejuri[j] > 0)
                        {
                            if (posBarca[1] != j)
                            {
                                o.muta();
                                break;
                            }
                    }
                }
            }

            for (ObiectMiscator o : listaMutabile) 
            {
                if (o.getClass().getName() == "Barca")
                {
                    int [] pos = o.getPozitie();
                    if (pos[0] > 14 && pod.suntLovit(pos[1]))
                    {
                        System.out.println("Barca: r=" + pos[0] + " c=" + pos[1]); 
                        podLovit = true;
                        break afara;
                    }
                }
            }

        }
        System.out.println("Terminat." + ((podLovit)? " Pod lovit.": " Gata vartejuri"));
    }

    public static void main (String[] args)
    {
        Rau r = new Rau();
        r.executaPas();
    }

    private void initApa()
    {
        for (int i = 0; i < apa.length; i++)
            for (int j = 0; j < apa[i].length; j++)
                apa[i][j] = '.';
    }

    private void citesteConfig() throws NoSuchElementException, IllegalStateException
    {
        citesteVartejuri(sc);
        for (int i = 1; i <= 14; i++)
        {
            citesteApa(sc, i);
        }
        citestePod(sc);
    }

    private void citesteVartejuri(Scanner sc) throws NoSuchElementException, IllegalStateException
    {
        String linie= sc.nextLine();
        int i=0; 
        while (i < linie.length())
        {
            while (Character.isWhitespace(linie.charAt(i))) i++; // sari spatiile
            if(Character.isDigit(linie.charAt(i))) // inceput descrier coloana vartejuri
            {
                int nrVartejuri = Integer.parseInt(linie.substring(i,i+1));
                i += 2; // sare '('
                int k = i;
                while (linie.charAt(k) != ')') k++; // cauta ')'
                int colVartejuri = Integer.parseInt(linie.substring(i,k));
                while (nrVartejuri-- > 0)
                {
                    listaMutabile.add(new Vartej(0, colVartejuri, 'W'));
                }
                i = k + 2; // sare peste ')'
            }
        }
    }

    private void citesteApa(Scanner sc, int rind)  throws NoSuchElementException, IllegalStateException
    {
        String linie= sc.nextLine();
        for(int i = 0; i < linie.length(); i++)
        {
            if (linie.charAt(i) == 'S')
            {
                listaMutabile.add(new Barca(rind, i, 'S', this));
            }
        }
    }

    private void citestePod(Scanner sc)  throws NoSuchElementException, IllegalStateException
    {
        pod= new Pod(sc.nextLine());
    }
}
