
/**
 * Write a description of class Lake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.util.Iterator;
import java.awt.*;
import java.io.*;
public class Lake
{
    ArrayList <Seals> seals=new ArrayList<Seals>();
    Bear bear;
    Point [] holes;
    private int nrseals;
    private int nrholes;
    private int totalSteps;
    public Lake()
    {
        totalSteps=0;
        Scanner s=null;
        BufferedReader in=null;
        String[] line=new String[3];
        nrholes=0;
        nrseals=0;
        int x,y;
        try{
            s=new Scanner(new BufferedReader(new FileReader("bearseals.txt")));
            //s.useDelimiter("//H//B//S");
            s.next();//citim B
            x=s.nextInt();
            y=s.nextInt();
            bear=new Bear(x,y);
            nrholes=s.nextInt()+1;
            holes=new Point[nrholes];
            holes[0]=new Point(x,y);//the bear stays at a hole too
            for(int i=1;i<nrholes;i++)
            {
                s.next();
                x=s.nextInt();
                y=s.nextInt();
                holes[i]=new Point(x,y);
            }
            nrseals=s.nextInt();
            for(int i=0;i<nrseals;i++)
            {
                s.next();
                x=s.nextInt();
                y=s.nextInt();
                seals.add(new Seals(x,y));
                //check if seal at a hole, then set step to 5
                for(int j=0;j<nrholes;j++)
                {
                    if((holes[j]).equals((seals.get(i)).getCoord())) (seals.get(i)).setStep(0);
                }
            }
        }catch(IOException e){System.out.println("File not open for input!");}
        finally{
            try{
                if(in!=null)in.close();
            }catch(IOException e2){System.out.println("Error closing file!");}
        }

    }

    public boolean gameOver()
    {
       boolean ok=false;
       if(totalSteps>300) ok=true;
       if(seals.size()==0) ok=true;// ok=seals.isEmpty();
       return ok;
    }
    public void view()
    {
        Point auxp;
        boolean ok=true;
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<20;j++)
            {
                auxp=new Point(i,j);
                //verificam daca e urs
                if(auxp.equals(bear.getCoord()))System.out.print("B");
                else
                {
                    //verificam daca e gaura  
                    ok=true;
                    Seals aus;
                    Iterator <Seals> it = seals.iterator();
                    while((ok)&&(it.hasNext()))
                    {
                        aus=it.next();
                        if(auxp.equals(aus.getCoord())){
                            ok=false;

                            if(aus.getStep()==0) System.out.print("S");
                            else  System.out.print("s");
                            // System.out.print("s");
                        }
                    }
                    if(ok){
                        //nu e nici gaura, verificam foca
                        for(int k=0;k<nrholes;k++)
                            if((ok)&&(auxp.equals(holes[k]))) {
                            ok=false;
                            System.out.print("H");
                        }
                        
                    }
                    if(ok)System.out.print("_");//not bear, nor hole nor seal
                }

            }
            System.out.println();
        }

    }
    public void animate()
    {
       totalSteps++;
       bear.move(holes);
       Iterator <Seals> it=  seals.iterator();
       boolean ok;
       Seals aus=null;
       System.out.println("Seals remaining "+nrseals);
       while(it.hasNext())
       {
         aus=it.next();
         aus.move(holes);
         //ursul vaneaza foca, daca aceasta e la o gaura
         if(!bear.eat){
         if(aus.getStep()==0){
            ///if((aus.getCoord()).equals(holes[bear.currHole])) {
                if((aus.getCoord()).equals(bear.getCoord())) {
                it.remove();
                nrseals--;
                bear.eat=true;
                System.out.println("Seal eaten!");
                bear.setStep(0);
            }
        }
        }
    }
       
    }
}

