import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Clasa care are functii de citire din fisier si citire din consola mutare
 */
import java.awt.Point;

public class Pozitie
{

    public Pozitie(){

    }

    public static Point[] citestePozitie(String s){
        Point[] p=new Point[5];
        int k=0;
        int c=0;
        int aux, auy;
        System.out.println("DA"+s);
        FileReader inputStream = null;

        try {
            inputStream = new FileReader(s);

            while(k<5){
                c = inputStream.read();
                if((c=='L')||(c=='O')){
                    c = inputStream.read();//citeste (
                    aux = inputStream.read()-'0';
                    c = inputStream.read();//citeste ,
                    auy = inputStream.read()-'0';
                    p[k]=new Point(aux,auy);
                    System.out.println(aux+" "+auy);
                    k++;
                    c = inputStream.read();//citeste )
                    if(k<5) c = inputStream.read();//citeste spatiu
                }
            }
        }
        catch(IOException e)
        {System.out.println("llkjj6897867gjh");}
        finally {
            try{
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch(IOException e){}

            return p;
        }
    }

    public static int[] citesteComanda()
    {
        int[] p=new int[2];
        System.out.println("Dati directia 1-N,2-NE,3-E,4-SE,5-S,6-Sv,7-V,8-NV si apasati Enter");
        Scanner in=new Scanner(System.in);
        int move=0;
        int dist=0;
        try{
            move=in.nextInt();
            //System.out.println(move);
        }catch(InputMismatchException e)
        {
            System.out.println("Not an int");
        }
        System.out.println("Dati deplasarea 1 sau 2 si apasati Enter");
        //in=new Scanner(System.in);
        try{
            dist=in.nextInt();
           // System.out.println(dist);
        }catch(InputMismatchException e)
        {
            System.out.println("Not an int");
        }
        int x=0;
        int y=0;
        switch(move){
            case 1: x=-dist;
            break;
            case 2: x=-dist;
            y=dist;
            break;
            case 3: y=dist;
            break;
            case 4: x=dist; y=dist;
            break;
            case 5: x=dist;
            break;
            case 6: x=dist; y=-dist;
            break;
            case 7: y=-dist;
            break;
            case 8: x=-dist; y=-dist;
            break;
            default :x=0; y=0;
            break;
        }
        p[0]=x;
        p[1]=y;
        return p;
    }

    public static void main(){
        citestePozitie("Lupoi.txt");

        citesteComanda();
    }

}
