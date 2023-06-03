import java.util.Random;
/**
 * Write a description of class Vartej here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vartej extends ObiectMiscator
{
    // instance variables - replace the example below with your own
    Random rnd = new Random();
    int [] offsetVal = new int []{-1, 0, 1};
    /**
     * Constructor for objects of class Vartej
     */
    public Vartej(int r, int c, char s)
    {
        super(r, c, s);
    }
    
    /**
     * Muta virtejul in pozitia viitoare
     * 
     */
    public void muta()
    {
        ++rind;
        int offset = offsetVal[rnd.nextInt(offsetVal.length)];
        if (offset + coloana >= 0 && offset + coloana <= 85)
            coloana += offset;
        //System.out.println("W(" + rind + "," + coloana + ") ");
    }
}
