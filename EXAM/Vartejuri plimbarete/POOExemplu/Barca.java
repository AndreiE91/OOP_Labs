
/**
 * Write a description of class Barca here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barca extends ObiectMiscator
{
    Rau rau;
     /**
     * Constructor for objects of class Barca
     */
    public Barca(int r, int c, char s, Rau rau)
    {
        super(r, c, s);
        this.rau = rau;
    }
    
    /**
     * Muta obiectul in pozitia viitoare
     * 
     */
    public void muta()
    {
        rind++;
        //System.out.println("S(" + rind + "," + coloana + ") ");
    }
}