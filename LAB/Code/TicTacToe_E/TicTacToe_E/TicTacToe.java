/**
 * Game board for Tic tac toe
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TicTacToe
{
    private char[][] board; // array of caharcters illustratiing current board situation
    private char[] allowedSymbols; // array of usable symbols for moves  

    /** Constructor – creates a 3 by 3 board where each square 
     * contains an underscore character '_', and allows for symbols 'O'(oh) and 'X'
     */
    public TicTacToe()
    {
        this(3, new char[]
        { 'X', 'O' });
    }

    /** Constructor – creates a 3 by 3 board where each square 
     * contains an underscore character '_'.
     * Allowed symbols are supplied by the symbols argument
     * @param size - strictly positive integer, board size
     * @param symbols - two characters to be used to mark moves
     */
    public TicTacToe(int size, char[] symbols)
    {
        if (size < 3)
        {
            System.out.println("Size < 3. Changed to 3");
            size = 3;
        }
        if (symbols.length > 2 || symbols[0] == symbols[1])
        {
            System.out.print("Too many or identical symbols: [" + symbols
                    + "].");
            symbols = new char[]
            { 'X', 'O' };
            System.out.println(" Changed to X and O");
        }
        board = new char[size][size];
        for (int sizerow = 0; sizerow < board.length; sizerow++)
        {
            for (int col = 0; col < board[sizerow].length; col++)
            {
                board[sizerow][col] = '_';
            } // sfâr?it bucla interioar?
        } // sfâr?it bucla exterioar?
    }

    /** Places the given char, c, at position [row][col] on game board
     * if row, col and c are valid, and the selected square is empty
     * (i.e has another avlue than the default, '_').
     * @param row board row
     * @param col board column
     * @param c character used to mark move
     * @return  true if successful, false otherwise
     */
    public boolean set(int row, int col, char c)
    {
        if (row >= board.length || row < 0)
            return false;
        if (col >= board[row].length || col < 0)
            return false;
        if (board[row][col] != '_')
            return false;
        if (!(c == allowedSymbols[0] || c == allowedSymbols[1]))
            return false;
        // assertion: row, col, c are validsunt valide
        board[row][col] = c;
        return true;
    }

    /**
     * @return the char at position [row][col] on the board.
     * @param row row of the board
     * @param col column of the board
     */
    public char get(int row, int col)
    {
        return board[row][col];
    }

    public String toString()
    {
        String s = "";
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[row].length; col++)
            {
                s += board[row][col] + " ";
            } 
            s += "\n";
        } 
        return s;
    }

    /** Prints a board position, e.g.
     *     _ _ _
     *     _ X O
     *     O _ X
     */
    public void print()
    {
        System.out.println(this);
    }

    /**
     * Returns a copy of the allowed symbols array
     * @return allowed symbols array
     */
    public char[] getSymbols()
    {
        char[] s = new char[allowedSymbols.length];
        System.arraycopy(allowedSymbols, 0, s, 0, allowedSymbols.length);
        return s;
    }
    // TODO: add check if game can go on: blocking position of win/loss
    // + more methods
}

