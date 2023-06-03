
/**
 * Create a class with a main( ) that throws an object of class Exception 
 * inside a try block. Give the constructor for Exception a String argument. 
 * Catch the exception inside a catch clause and print the String argument. 
 * Add a finally clause and print a message to prove you were there.
 */
public class Exception5_1
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("I will throw an exception with text \"5.1 exception thrown\".");
            throw new Exception("5.1 exception thrown.");
            // This line is not reachable
        }
        catch (Exception e)
        {
            System.out.println("Caught exception with text: " + e.getMessage());
        }
        finally
        {
            System.out.println("Lily was here. :-)");
        }
    }
}
