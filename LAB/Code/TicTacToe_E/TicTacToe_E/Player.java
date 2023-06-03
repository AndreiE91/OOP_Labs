
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private String name;
    private char symbol;
    private TicTacToe board;
    
    /**
     * Constructor for objects of class Player
     * @param name player name
     * @param symbol caracter to use for marking move
     * @param board reference to game board
     */
    public Player(String name, char symbol, TicTacToe board)
    {
        // TODO: validate parameters
        this.name = name;
        this.board = board;
        this.symbol = symbol;
    }
    /**
     * Accepts from System.in the coordinates of the move
     * and attempts to movei
     * @return true if successful, false otherwise
     */
    public boolean move()
    {
        // TODO
        return false;
    }
}
