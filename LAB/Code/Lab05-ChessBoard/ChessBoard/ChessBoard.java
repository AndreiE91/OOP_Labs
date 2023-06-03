import java.awt.Color; 
import java.awt.Font;
import enigma.console.*; 
import enigma.core.Enigma;
import enigma.console.java2d.Java2DTextWindow;
/**
 * Write a description of class ChessBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChessBoard
{
    public static final int ROW_MIN = 0;
    public static final int ROW_MAX = 7;
    public static final int COL_MIN = 0;
    public static final int COL_MAX = 7;
    TextAttributes attrs;
    private static final Console s_console; //Declare the Console
    static
    {
        s_console = Enigma.getConsole("Chess Game"); //Sets the console to the Enigma console, named "Hellow World!"
        if (s_console.isTextWindowAvailable())
        {
            Java2DTextWindow txtW = (Java2DTextWindow) s_console.getTextWindow();
            txtW.setFont(new Font("Courier new", Font.PLAIN, 24));
        }
    } 
    // instance variables - replace the example below with your own
    private ChessPiece[][] board;

    /**
     * Constructor for objects of class ChessBoard
     */
    public ChessBoard()
    {
        // initialise instance variables
        board = new ChessPiece[ROW_MAX+1][COL_MAX+1];
        setBoard();
        printBoard();
    }
    public void printBoard()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j] != null) 
                    board[i][j].print(attrs, 
                    (((i + j) % 2 == 0)? Color.DARK_GRAY: Color.LIGHT_GRAY) );
                else
                {
                        attrs= new TextAttributes(
                        ((i + j) % 2 == 0)? Color.DARK_GRAY: Color.LIGHT_GRAY,
                        ((i + j) % 2 == 0)? Color.DARK_GRAY: Color.LIGHT_GRAY);
                        s_console.setTextAttributes(attrs); //Sets the colors to the console
                        System.out.print(" "); //Default system println
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        ChessBoard cb = new ChessBoard();
        
        // TODO: get input from the user and process moves
    }
    
    /**
     * setBoard places initially pieces on board
     * 
     */
    private void setBoard()
    {
        // set whites
        board[7][0] = new ChessPiece(s_console, 7, 0, 'R', Color.white); // rook
        board[7][1] = new ChessPiece(s_console, 7, 1, 'N', Color.white); // knight
        board[7][2] = new ChessPiece(s_console, 7, 2, 'B', Color.white); // bishop
        board[7][3] = new ChessPiece(s_console, 7, 3, 'Q', Color.white); // queen
        board[7][4] = new ChessPiece(s_console, 7, 4, 'K', Color.white); // king
        board[7][5] = new ChessPiece(s_console, 7, 5, 'B', Color.white); 
        board[7][6] = new ChessPiece(s_console, 7, 6, 'N', Color.white); 
        board[7][7] = new ChessPiece(s_console, 7, 7, 'R', Color.white);
        for (int j = 0; j < board[6].length; j++)
            board[6][j] = new ChessPiece(s_console, 6, j, 'P', Color.white); //pawn
        // set blacks
        for (int j = 0; j < board[6].length; j++)
            board[1][j] = new ChessPiece(s_console, 6, j, 'P', Color.black);
        board[0][0] = new ChessPiece(s_console, 0, 0, 'R', Color.black); 
        board[0][1] = new ChessPiece(s_console, 0, 0, 'N', Color.black); 
        board[0][2] = new ChessPiece(s_console, 0, 0, 'B', Color.black); 
        board[0][3] = new ChessPiece(s_console, 0, 0, 'Q', Color.black);         
        board[0][4] = new ChessPiece(s_console, 0, 0, 'K', Color.black);
        board[0][5] = new ChessPiece(s_console, 0, 0, 'B', Color.black); 
        board[0][6] = new ChessPiece(s_console, 0, 0, 'N', Color.black); 
        board[0][7] = new ChessPiece(s_console, 0, 0, 'R', Color.black);    
    }
}
