package PackageA;


/**
 * Write a description of class ClassB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClassA
{
    // instance variables
    private static int objCounter = 0;
    private String id = "Object of Class A";
    private int aNumber;
    /**
     * Constructor for objects of class ClassA
     */
    public ClassA( int nb )
    {
        // initialise instance variables
        aNumber = nb;
        objCounter++;
    }
    public String toString()
    {
        return objCounter + " " + id + "\n\tnumber contained = " + aNumber;
    }
    public String toStringForOtherObject(ClassA a) 
    {
        return a.objCounter + " " + a.id + "\n\tnumber contained = " + a.aNumber;
    }
}
