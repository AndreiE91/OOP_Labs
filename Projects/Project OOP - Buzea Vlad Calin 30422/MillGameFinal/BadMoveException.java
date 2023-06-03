
/**
 *This is a custom exception used for bad game moves
 */
public class BadMoveException extends Exception
{
    private String mesage="";
    public BadMoveException(String S)
    {
        mesage=S;
    }
    public void printMesage()
    {
        System.out.println(mesage);
    }
}
