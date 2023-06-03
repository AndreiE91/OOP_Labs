
/**
 * Write a description of class Joc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.Point;
public class Joc
{
    public static void  afisare(Point[] p,int oi){
        Point p2=null;
        boolean ok=true;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++)
            {
                p2=new Point(i,j);
                if(p2.equals(p[0]))System.out.print("L");
                else
                {
                    ok=true;
                    for(int k=1;k<oi+1;k++)
                        if(p2.equals(p[k])){System.out.print("O");
                            ok=false;}
                    if(ok) System.out.print("+");
                }
            }
            System.out.println("");
        }
    }


    public static void main(){
        Vanatoare hunt=new Vanatoare();
        afisare(hunt.getPoint(),hunt.getOi());
        int[] aux=new int[2];
        while(!hunt.over()){
            do{
                aux=Pozitie.citesteComanda();
            }
            while(!hunt.validMove(aux));
            afisare(hunt.getPoint(),hunt.getOi());

        }
        System.out.println("Lup satul!");
    }
}