
/**
 * Create a class with two methods, f( ) and g( ). In g( ), 
 * throw an exception of a new type that you define. 
 * In f( ), call g( ), catch its exception and, 
 * in the catch clause, throw a different
 * exception (of a second type that you define).
 */
public class Exception5_4
{
    /**
     * f  - method catching exception thrown by g()
     */
    public void f()
    {
        try
        {
            g();
        }
        catch(MyException e)
        {
            System.out.println("Caught exception thrown by g(). Message was '" +
            e.getMessage() + "'.\nType of Exception was " + e.getClass().getName() +
            " derived from " + e.getClass().getGenericSuperclass());
        }
    }
    public void g() throws MyException
    {
        throw new MyException("Exception thrown by g()");
    }
    public static void main(String[] args)
    {
        Exception5_4 e5_4 = new Exception5_4();
        e5_4.f();
    }
}
