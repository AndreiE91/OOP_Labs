
/**
 * Write a description of class Vanatoare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/*import java.awt.Point;
import java.util.Random;
import java.util.*;
public class VanatoareVeche
{
    ArrayList<Point> animals=new ArrayList<Point>();
    private Point[] locatii= new Point[5];
    private int nroi=4;
    public int getOi(){
        return nroi;
    }

    public VanatoareVeche(){
        locatii=Pozitie.citestePozitie("Lupoi.txt");
        for(int i=0;i<5;i++)
            animals.add(locatii[i]);   
    }

  

    public Point[]  getPoint(){
        //return locatii;
        return (Point[])animals.toArray();
    }

    public boolean over(){
        boolean ok=false;
        if (nroi==0) ok=true;
        return ok;
    }

    private void mutaOaie(){
        boolean ok =false;
        double dmin=20;
        int min=0;
        int ox=0;
        int oy=0;
        int move=0;
        Random r=new Random();
        while(!ok){
            dmin=20;
            min=0;
            for(int i=1;i<nroi+1;i++)
            {
                if(Math.sqrt(locatii[i].getX()*locatii[i].getX()+locatii[i].getY()*locatii[i].getY())<dmin){
                    dmin=Math.sqrt(locatii[i].getX()*locatii[i].getX()+locatii[i].getY()*locatii[i].getY());
                    min=i;
                }
            }

            move=r.nextInt(8);
            int x=0;
            int y=0;
            int dist=1;
            switch(move){
                case 1: x=-dist;
                break;
                case 2: x=-dist;
                y=y+dist;
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
            ox=(int)locatii[min].getX();
            oy=(int)locatii[min].getY();
            ox=ox+x;
            oy=oy+y;
            ok =true;
            if((ox<0)||(ox>9)||(oy<0)||(oy>9)) ok=false;
        }
        Point p2=new Point(ox,oy);
        ok=false;
        for(int k=1;k<nroi+1;k++)
            if(p2.equals(locatii[k])) ok=true;
        if(ok==false) 
        {locatii[min]=new Point(ox,oy);}
        else
        {
            nroi++;

            move=r.nextInt(100);
            locatii[nroi]=new Point(move/10, move%10);
        }
    }

    public boolean validMove(int[] aux){
        boolean ok=true;
        int lupx=(int)locatii[0].getX();
        int lupy=(int)locatii[0].getY();
        lupx=lupx+aux[0];
        lupy=lupy+aux[1];
        if((lupx<0)||(lupx>9)||(lupy<0)||(lupy>9)) ok=false;
        else{
            Point p2=new Point(lupx,lupy);
            for(int k=1;k<nroi+1;k++)
                if(p2.equals(locatii[k])) {
                    nroi--;
                    for(int m=k;m<locatii.length-1;m++)
                        locatii[m]=locatii[m+1];
                    locatii[locatii.length-1]=null;
            }
            locatii[0]=new Point(lupx,lupy);
            mutaOaie();
        }
        return ok;
    }
}
*/