
/**
 * Write a description of class IOClass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.lang.*;
import java.io.*;
public class IOClass
{
    public static char[][] readInitialConfig(){
        Scanner inr=new Scanner(System.in);
        System.out.print("Give input file name: file <<fluffy>> exists");
        String S=inr.nextLine();
        if(S.indexOf(".")<0)         S=S+".txt";
        BufferedReader in=null;
        String line=null;
        int i=0;
        char[][] ret=new char[10][40];
        try{
            in=new BufferedReader(new FileReader(S));
            while((line=in.readLine())!=null){
                ret[i]=line.toCharArray();
                i++;
                System.out.println(line);
            }
        }
        catch(IOException e)
        {
            System.out.println("File not open!");
        }
        finally
        {
            try{
                if(in!=null) in.close();
            }catch (IOException e2){}
        }
        return ret;
    }


    public static int[] readCommand(){
        Scanner inr=new Scanner(System.in);
        System.out.println("Enter a command N,NE,E,SE,S,SV,V,NV,SAVE,LOAD,EXIT :");
        System.out.print("> ");
        String line=inr.nextLine();
        System.out.println(line);
        int x=0; int y=0;
        if(line.equals("N")){x=-1; y=0;}
        if(line.equals("NE")){x=-1; y=1;}
        if(line.equals("E")){ y=1;}
        if(line.equals("SE")){x=1; y=1;}
        if(line.equals("S")){ x=1;}
        if(line.equals("SV")){x=1; y=-1;}
        if(line.equals("V")){ y=-1;}
        if(line.equals("NV")){x=-1; y=-1;}
        if(line.equals("SAVE")){x=2;    }
        if(line.equals("LOAD")){x=3;   }
        if(line.equals("EXIT")){x=4;   }
        int [] ret=new int[2];
        ret[0]=x;
        ret[1]=y;
        System.out.println(x+" "+y);
        return ret;
    }


    public static void saveGame(Object oo){
        FileOutputStream outputFile =null;
        try{
            outputFile = new FileOutputStream("fluffyhat.dat");
        }catch (FileNotFoundException e2){}
        ObjectOutputStream outputStream=null;
        try{
            outputStream = new ObjectOutputStream(outputFile);

            outputStream.writeObject(oo);
            outputStream.flush();
            outputStream.close();
        }catch (IOException e){}
    }


    public static Object loadGame(){
        FileInputStream inputFile=null;
        ObjectInputStream inputStream=null; 
        Object oo=null;
        try{
            inputFile = new FileInputStream("fluffyhat.dat");
        }    catch (FileNotFoundException e){}
        try{    
            inputStream = new ObjectInputStream(inputFile);
            try{   
                oo=inputStream.readObject();
            }catch(ClassNotFoundException e3){}
            inputStream.close();
        }catch (IOException e){}
        return oo;
    }
    public static void main(){
        
    readInitialConfig();
    }
}
