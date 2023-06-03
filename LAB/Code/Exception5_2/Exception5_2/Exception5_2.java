
/**
 * Create your own exception class using the extends keyword. 
 * Write a constructor for this class that takes a String argument 
 * and stores it inside the object with a String reference. Write a
 * method that prints out the stored String. 
 * Create a try-catch clause to exercise your new exception
 */
public class Exception5_2
{
    public static void main(String[] args)
    {
        try
        {
            throw new MyException("Dummy String");
        }
        catch(MyException e)
        {
            e.printTheString();
            System.out.println("Alternate idea - using getMaessage(): " +
            e.getMessage());
        }
    }
}
