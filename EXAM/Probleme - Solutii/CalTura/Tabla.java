
/**
 * Write a description of class Tabla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class Tabla extends Pozitie
{
    private boolean gameO=false;
    public  int mutariCal=0;
    public Tabla(){
        super();
        gameO=false;
    }

    public void setPozitii(int []x)
    {
        super.pozitii=x;
    }

    public boolean validMove(int[] x){
        boolean ok=false;
        try{
            ok=true;
            for(int i=0;i<4;i++)
                if((x[i]<0)||(x[i]>7)) ok=false;
        }
        catch(ArrayIndexOutOfBoundsException e){System.out.println("Error array index!");}
       System.out.println(ok);
        return ok;
    }

    public boolean moveHorse(){
        boolean ok=true;
        mutariCal++;
        int[] ret=citesteComanda();
        ok=validMove(ret);
        if(ok){
            System.out.println("Mutam calul de la " +(ret[0])+" "+(ret[1])+" la "+(ret[2])+" "+(ret[3])+"!");
            int cx=ret[2];
            int cy=ret[3];
            int [] aux=citestePozitie();
            if(((cx==aux[2])&&(cy==aux[3]))||((cx==aux[4])&&(cy==aux[5]))){
                System.out.println("Bravo calutule ai castigat dupa "+mutariCal+" mutari!");
                gameO=true;
            }
            aux[0]=cx;
            aux[1]=cy;
            setPozitii(aux);
        }

        return ok;
    }

    public void moveT()
    {
        Random r=new Random();
        int[] aux;
        //prima tura
        do{
            int c=r.nextInt(2);//sa vedem cum mutam tura, pe linie -0 sau coloana -1
            int d=r.nextInt(8);
            aux=new int[]{pozitii[2], pozitii[3],pozitii[2],pozitii[3]};
            aux[2+c]=d;
        }while (!validMove(aux));
        pozitii[2]=aux[2];
        pozitii[3]=aux[3];
        if((pozitii[0]==pozitii[2])&&(pozitii[1]==pozitii[3])){
            System.out.println("Calul a murit dupa "+mutariCal+" pasi!");
            gameO=true;
            pozitii[0]=9;
            pozitii[1]=9;
        }
        //a doua tura
        do{
            int c=r.nextInt(2);//sa vedem cum mutam tura, pe linie -0 sau coloana -1
            int d=r.nextInt(8);
            aux=new int[]{pozitii[4], pozitii[5],pozitii[4],pozitii[5]};
            aux[2+c]=d;
        }while (!validMove(aux));
        pozitii[4]=aux[2];
        pozitii[5]=aux[3];
        if((pozitii[0]==pozitii[4])&&(pozitii[1]==pozitii[5])){
            System.out.println("Calul a murit dupa "+mutariCal+" pasi!");
            gameO=true;
            pozitii[0]=9;
            pozitii[1]=9;
        }
    }

    public void view()
    {
        boolean ok;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++)
            {
                ok=true;
                for(int k=0;k<6;k=k+2)
                    if((i==pozitii[k])&&(j==pozitii[k+1])){
                        if(ok){
                            if(k==0) System.out.print("L");
                            else System.out.print("T");
                        }
                        ok=false;
                }
                if((ok)&&((i+j)%2==0))System.out.print("#");
                else System.out.print(' ');
            }
            System.out.println();
        }

    }


    public boolean gameOver(){
        return gameO;
    }
}
