public abstract class MovingObject
{
    protected int row;
    protected int column;
    protected char symbol;
    public MovingObject(int row, int column, char symbol)
    {
        this.row = row;
        this.column = column;
        this.symbol = symbol;
    }
    @Override
    public String toString()
    {
        String s = "" + symbol;
        return s;
    }
    public int [] getPosition()
    {
        int pos[] = new int[2];
        pos[0] = row;
        pos[1] = column;
        return pos;
    }
    public abstract void move();
}
