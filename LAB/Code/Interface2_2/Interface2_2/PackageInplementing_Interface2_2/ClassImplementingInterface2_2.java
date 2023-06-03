package PackageInplementing_Interface2_2;
import Interface2_2Package.Interface2_2;

/**
 * Write a description of class ClassImplementingInterface2_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClassImplementingInterface2_2 implements Interface2_2
{
    int i;
    char c;
    double d;
    
    /**
     * Constructor for ClassImplementingInterface2_2
     * @param i integer to wrap
     * @param c char to wrap
     * @param d double to truncate to long
     */
    public ClassImplementingInterface2_2(int i, char c, double d)
    {
        this.i = i;
        this.c = c;
        this.d = d;
    }
    
    /**
     * methodA
     * Wraps an integer
     * @param  i    integer to wrap
     * @return      wrapped integer 
     */
    public Integer methodA(int i)
    {
        this.i = i;
        return new Integer(i);
    }
    /**
     * methodB
     * Wraps a char
     * @param  c    character to wrap
     * @return      wrapped char 
     */
    public Character methodB(char c)
    {
        this.c = c;
        return new Character(c);
    }
    /**
     * methodC
     * Truncates a double to a long
     * @param  d    double to truncate
     * @return      long possibly equal with the double argument
     */
    public long methodC(double d)
    {
        long l;
        this.d = d;
        l = (long) d;
        if ((double) l != d)
        {
            System.err.println("Truncation failed. long = " + l + " double = " + d);
        }
        return l;
    }
}
