
/**
 * Write a description of class Animals here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
public class Animals
{
    private Point coord;
    private int step=1;
    public Animals(int x, int y)
    {
        coord=new Point(x,y);
    
    }
    public int getStep()
    {
    return step;
    }
    public void setStep(int x)
    {
    step=x;
    }
    public void increaseStep()
    {
    step++;
    }
    public void setCoord(int x, int y)
    {
    coord=new Point(x,y);
    }
    public Point getCoord()
    {
    return coord;
    }
    public boolean move(Point[] holes)
    {
     return false;
    }
}
