package PackageB;


/**
 * Write a description of class ClassB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClassB1
{
    // instance variables
    private static int objCounter = 0;
    private String id = "Object of Class B1";
    private int aNumber;
    int anotherNumber;
    /**
     * Constructor for objects of class ClassB
     */
    public ClassB1( int nb )
    {
        // initialise instance variables
        aNumber = nb;
        anotherNumber = -nb;
        objCounter++;
    }
    public String toString()
    {
        return "[Total " + objCounter + "] " + id + "\n\tnumber contained = " + aNumber + "\n\tanotherNumber = " +
            anotherNumber;
    }
    public String getInfoFromOtherClass(ClassB b)
    {
        // return b.id + " " + b.aNumber; will not work; data is private
        return b.getIdAndNumber(); // package visibility
    }
}