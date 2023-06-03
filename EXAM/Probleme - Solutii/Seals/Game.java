
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Game
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        Lake frozen=new Lake();
        while(!frozen.gameOver()){
            frozen.view();
            frozen.animate();
            System.out.println("Press Enter to continue...");
            sc.nextLine();
        }
        System.out.println("Simulation over!");
        frozen.view();
    }
}
