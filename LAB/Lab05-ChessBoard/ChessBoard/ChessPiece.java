import java.awt.Color; 
import enigma.console.*; 
import enigma.core.Enigma;
/**
 * Write a description of class ChessPiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChessPiece
{
    // instance variables - replace the example below with your own
    private int row;
    private int col;
    private char symbol;
    private Color color;
    private Console s_console;
    /**
     * Constructor for objects of class ChessPiece
     */
    public ChessPiece(Console s_console, int row, int col, char symbol, Color color)
    {
        // initialise instance variables
        this.row = row;
        this.col = col;
        this.symbol = symbol;
        this.color = color;
        this.s_console = s_console;
    }

    /**
     * Move to row, col on the board
     * 
     * @param  row destination row
     * @param  col destination col
     * @return true if can move, false otherwise 
     */
    public boolean move(int row, int col)
    {
        if (row >= ChessBoard.ROW_MIN && row <= ChessBoard.ROW_MAX &&
            col >= ChessBoard.COL_MIN && col <= ChessBoard.COL_MAX)
        {
            this.row = row;
            this.col = col;
            return true;
        }
        // put your code here
        return false;
    }
    public void print(TextAttributes attrs, Color back)
    {
        attrs = new TextAttributes(this.color, back);//Changes the color
        s_console.setTextAttributes(attrs);
        System.out.print(symbol);
    }
}
