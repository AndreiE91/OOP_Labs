
/**
 * Write a description of class Bear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
public class Bear extends Animals
{
    public boolean eat=false;
    private int waitSteps=6;
    public int currHole=0;
    public Bear(int x, int y)
    {
      super(x,y);
      waitSteps=6;
    }
   public boolean move(Point[] holes)
   {
     int currSteps=super.getStep();
     Random r=new Random();
     //mutam ursul la alta gaura
     if((!eat)&&(currSteps>=waitSteps)){
        waitSteps=r.nextInt(5)+2;//minim 2 maxim 6
        //move near a next hole
        currHole=r.nextInt(holes.length);
        this.setCoord((int)holes[currHole].getX(),(int)holes[currHole].getY());
        System.out.println("Move bear to hole number "+currHole+" and wait for "+waitSteps+" steps");
        this.setStep(0);
        }
        if(eat){
         if(currSteps==3) eat=false;
        }
    this.increaseStep();
    return true;
    }
   
}
