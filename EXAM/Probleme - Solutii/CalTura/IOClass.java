
/**
 * Write a description of class IOClass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
public class IOClass
{
    public static int[] citireFisier(){
        BufferedReader in=null;
        int[] ret=new int[6];
        String line="Ca1 Ca1 Ca1";
        try{
            in=new BufferedReader(new FileReader("cal_tura.txt"));
           
            line=in.readLine();
        }catch(IOException e){System.out.println("File not open for input!");}
        finally{
            try{
                if(in!=null)in.close();
            }catch(IOException e2){System.out.println("Error closing file!");}
        }
        ret[1]=line.charAt(1)-'a';
        ret[0]=line.charAt(2)-'1';
        ret[3]=line.charAt(5)-'a';
        ret[2]=line.charAt(6)-'1';
        ret[5]=line.charAt(9)-'a';
        ret[4]=line.charAt(10)-'1';
        for(int i=0;i<6;i++)
        System.out.println(ret[i]);
        return ret;
    }
    public static void main()
    {
     citireFisier();
    }
}
