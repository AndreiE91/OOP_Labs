
/**
 * Write a description of class Seals here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
public class Seals extends Animals
{

    public Seals(int x, int y)
    {
        super(x,y);
    }

    public double distance(Point p, Point q)
    {
        double d=((p.getX()-q.getX()))*((p.getX()-q.getX()))+
            ((q.getY()-p.getY()))*((q.getY()-p.getY()));
        d=Math.sqrt(d);
        return d;

    }

    public boolean move(Point[] holes){
        boolean ok=true;
        Random r=new Random();
        if(this.getStep()==5){
            //move to the closest hole
            Point aus=this.getCoord();
            int hmin=0;
            double dmin=distance(aus,holes[0]);
            for(int i=1;i<holes.length;i++)
                if(distance(aus,holes[i])<dmin)
                {
                    dmin=distance(aus,holes[i]);
                    hmin=i;
            }
            this.setCoord((int)holes[hmin].getX(),(int)holes[hmin].getY());
            this.setStep(0);//seal in hole
        }else 
        {
        if(this.getStep()==0) {//seal in hole
            //move to a random position
            int move= r.nextInt(200);
            this.setCoord(move/20,move%20);
        }
            this.increaseStep();}
        return ok;
    }

}
