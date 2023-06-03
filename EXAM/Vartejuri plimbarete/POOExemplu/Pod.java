
/**
 * Write a description of class Pod here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pod
{
    // instance variables - replace the example below with your own
    private String reprezentare;

    /**
     * Constructor for objects of class Pod
     */
    public Pod(String rep)
    {
        // initialise instance variables
        reprezentare = rep;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  coloana   coloana obiectului care poate lovi podu;
     * @return     true daca coloana obiectului coincide cu un pilon (marcat cu 'B')
     */
    public boolean suntLovit(int coloana)
    {
        // put your code here
        return (reprezentare.charAt(coloana) == 'B');
    }
    @Override
    public String toString()
    {
        return reprezentare;
    }
}
