
/**
 * Write a description of class Cat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public class Cat implements Serializable
{
   private int catx=0;
   private int caty=0;
   public Cat(int a, int b){
    catx=a;
    caty=b;
    }
    public void setCoord(int a,int b)
    {
      catx=a;
      caty=b;
    }
    public int [] getCoord()
    {
    int[] ret=new int[2];
    ret[0]=catx;
    ret[1]=caty;
    return ret;
    
    }
}
