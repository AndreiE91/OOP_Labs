
/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends MovingObject
{
    River river;
     /**
     * Constructor for objects of class Ship
     */
    public Ship(int r, int c, char s, River river)
    {
        super(r, c, s);
        this.river = river;
    }
    
    /**
     * Muve ship to next position
     * 
     */
    public void move()
    {
        row++;
        //System.out.println("S(" + row + "," + column + ") ");
    }
}
