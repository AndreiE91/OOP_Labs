/**
 * MyException. My defined exception
 * 
 * derived from NullPointerException
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyException extends NullPointerException
{
    /**
     * Constructor for objects of class ExceptionBase
     * @param s String for e.getMessage()
     */
    public MyException(String s)
    {
        super(s);
    }
}

