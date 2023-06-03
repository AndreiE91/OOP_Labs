import java.util.Random;
/**
 * Write a description of class Whirlpool here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Whirlpool extends MovingObject
{
    Random rnd = new Random();
    int [] offsetVal = new int []{-1, 0, 1};
    /**
     * Constructor for objects of class Whirlpool
     */
    public Whirlpool(int r, int c, char s)
    {
        super(r, c, s);
    }
    
    /**
     * Move whirlpool in next position
     * 
     */
    public void move()
    {
        ++row;
        int offset = offsetVal[rnd.nextInt(offsetVal.length)];
        if (offset + column >= 0 && offset + column <= 85)
            column += offset;
        //System.out.println("W(" + row + "," + column + ") ");
    }
}
