package PackageB;


/**
 * Write a description of class AnotherClass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnotherClass
{
    // instance variables - replace the example below with your own
    private ClassB b;
    private ClassB1 b1;

    /**
     * Constructor for objects of class AnotherClass
     */
    public AnotherClass(ClassB b, ClassB1 b1)
    {
        // initialise instance variables
        this.b = b;
        this.b1 = b1;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void changeInObjectOfClassB1(int y)
    {
        // put your code here
        b1.anotherNumber = y;
    }
    public String toString()
    {
        return "Object of class Another class.\nContains references to:\n" +
            b + "\nand\n" + b1;
    }
    public static void main()
    {
        ClassB b = new ClassB(15);
        System.out.println(b);
        ClassB1 b1 = new ClassB1(55);
        System.out.println(b1);        
        AnotherClass a = new AnotherClass(b, b1);
        System.out.println(a);        
        System.out.println(a);
        a.changeInObjectOfClassB1(75);
        System.out.println(b1);        
    }
}
