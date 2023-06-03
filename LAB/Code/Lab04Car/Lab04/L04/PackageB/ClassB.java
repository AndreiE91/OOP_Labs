package PackageB;


/**
 * Write a description of class ClassB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClassB
{
    // instance variables
    private static int objCounter = 0;
    private String id = "Object of Class B";
    private int aNumber;
    /**
     * Constructor for objects of class ClassB
     */
    public ClassB( int nb )
    {
        // initialise instance variables
       aNumber = nb;
       objCounter++; 
    }
    public String toString()
    {
        return"[Total " + objCounter + "] " + id + "\n\tnumber contained = " + aNumber;
    }
    String getIdAndNumber() // package visibility
    {
        return  id + "\n\tnumber contained = " + aNumber;
    }
    String getAnotherNumberFromB1(ClassB1 b1)  // package visibility
    {
        return b1.toString() + "\n\tanotherNumber is: " + b1.anotherNumber;
    }
    void changeDataFromB1(ClassB1 b1, int val) // package visibility
    {
        b1.anotherNumber = val;
    }
    
}