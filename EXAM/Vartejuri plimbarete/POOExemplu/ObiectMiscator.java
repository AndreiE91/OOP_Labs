
public abstract class ObiectMiscator
{
    // instance variables - replace the example below with your own
    protected int rind;
    protected int coloana;
    protected char simbol;
    public ObiectMiscator(int rind, int coloana, char simbol)
    {
        this.rind = rind;
        this.coloana = coloana;
        this.simbol = simbol;
    }
    @Override
    public String toString()
    {
        String s = "" + simbol;
        return s;
    }
    public int [] getPozitie()
    {
        int pos[] = new int[2];
        pos[0] = rind;
        pos[1] = coloana;
        return pos;
    }
    public abstract void muta();
}
