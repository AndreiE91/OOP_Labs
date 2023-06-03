
/**
 * Write a description of class MyException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyException extends Exception
{
    /**
     * Constructor for objects of class MyException
     */
    public MyException()
    {
        super("This an instance of MyException.");
    }
    /**
     * Constructor for objects of class MyException
     * 
     * @param theString Explanatory String for MyException
     */
    public MyException(String theString)
    {
        super(theString);
    }    
    /**
     * printTheString
     * prints the strting stored with a MyException instance
     */
    public void printTheString()
    {
        System.out.println("The String stored by this instance" +
        " of MyException is: " + super.getMessage());
    }
}
