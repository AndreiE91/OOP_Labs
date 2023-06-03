
/**
 * Write a description of class Vanatoare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.Point;
import java.util.Random;
import java.util.*;
public class Vanatoare
{
    ArrayList<Point> animals=new ArrayList<Point>();
    private Point[] locatii= new Point[5];
    private int nroi=4;
    public int getOi(){
        return nroi;
    }

    public Vanatoare(){
        locatii=Pozitie.citestePozitie("Lupoi.txt");
        for(int i=0;i<5;i++)
            animals.add(locatii[i]);   
    }

    /*public void setPoint(Point[] c){
    for(int i=0;i<c.length;i++){
    //locatii[i]=new Point(c.x,c.y);
    }
    }*/

    public Point[]  getPoint(){
        //return locatii;
        locatii=animals.toArray(locatii);
        //return (Point)animals.toArray();
        return locatii;
    }

    public boolean over(){
        boolean ok=false;
        if (nroi==0) ok=true;
        return ok;
    }

    private double distanta(int xa, int ya, int xb, int yb){
        double d=0;
        d=(xa-xb)*(xa-xb)+(ya-yb)*(ya-yb);
        d=Math.sqrt(d);
        return d;

    }

    private void mutaOaie(){
        boolean ok =false;
        double dmin=20;
        int min=0;
        Point oaieApropiata=null;
        int ox=0;
        int oy=0;
        int move=0;
        Random r=new Random();
        Point auxp=null;
        Point auxlup=null;
        double d=0;
        try{
            auxlup=animals.get(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index ERROR!");
        }
        int lupx=(int)auxlup.getX();
        int lupy=(int)auxlup.getY();

        dmin=20;
        min=0;
        for(int i=1;i<animals.size();i++)
        {
            try{
                auxp=animals.get(i);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index ERROR!");
            }
            ox=(int)auxp.getX();
            oy=(int)auxp.getY();
            d=distanta(lupx,lupy,ox,oy);
            if(d<dmin){
                dmin=d;
                min=i;
                oaieApropiata=auxp;
            }
        }
        ok=false;
        int x=0;
        int y=0;
        while(!ok){//cattimp mutarea oii nu e valida
            move=r.nextInt(8);
            x=0; y=0;
            int dist=1;
            switch(move){
                case 1: x=-dist;
                break;
                case 2: x=-dist; y=dist;
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
                default :x=1; y=1;
                break;
            }
            ox=(int)oaieApropiata.getX();
            oy=(int)oaieApropiata.getY();
            ox=ox+x;
            oy=oy+y;
            ok =true;
            if((ox<0)||(ox>9)||(oy<0)||(oy>9)) ok=false;//verificam daca mutarea oii e valida
        }
        Point oaieMutata=new Point(ox,oy);
        int altaOaie=animals.indexOf(oaieMutata);
        if(altaOaie<0)//nu am gasit oaie pe pozitia asta 
        {
            animals.set(min,oaieMutata);
            System.out.println("Am mutat o oaie de la coordonatele "+(ox-x)+" "+(oy-y)+" la coordonatele "+ ox+" "+oy);  
        }
        else{
            if(altaOaie==0){
                System.out.println("Am atacat lupul!");
            }
            else
            {
                nroi++;
                move=r.nextInt(100);
                animals.add(new Point(move/10, move%10));
                System.out.println("Am avut o oaie noua la coordonatele :"+ (move/10)+" "+(move%10));
            }
        }
    }

    public boolean validMove(int[] aux){
        boolean ok=true;
        Point auxp=animals.get(0);
        int lupx=(int)auxp.getX();
        int lupy=(int)auxp.getY();
        lupx=lupx+aux[0];
        lupy=lupy+aux[1];
        if((lupx<0)||(lupx>9)||(lupy<0)||(lupy>9)) ok=false;
        else{
            Point p2=new Point(lupx,lupy);
            int oaieMancata=animals.indexOf(p2);
            if(oaieMancata>0)//am gasit un element care corespunde
            {
                nroi--;
                animals.remove(oaieMancata);
                System.out.println("Am mancat o oaie!");
            }
            animals.set(0,new Point(lupx,lupy));
            if(animals.size()>1)  mutaOaie();
        }
        return ok;
    }
}
