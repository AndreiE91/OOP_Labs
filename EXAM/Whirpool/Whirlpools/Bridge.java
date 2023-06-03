
/**
 * Write a description of class Bridge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bridge
{
    private String representation;

    /**
     * Constructor for objects of class Bridge
     */
    public Bridge(String rep)
    {
        // initialise instance variables
        representation = rep;
    }

    /**
     * Returns true if the bridge was hit; false otherwise
     * 
     * @param  column   column of the ship which may hit bridge
     * @return true     if column of the ship is the column of a pilon (marked as 'B')
     */
    public boolean iAmHit(int column)
    {
        return (representation.charAt(column) == 'B');
    }
    @Override
    public String toString()
    {
        return representation;
    }
}
