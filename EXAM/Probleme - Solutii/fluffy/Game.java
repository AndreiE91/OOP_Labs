
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    public static void main()
    {
        Board dd=new Board();
        int [] aux=new int[2];
        System.out.println("Press 4 for new game!");
        aux=IOClass.readCommand();
        if(aux[0]==3) dd=(Board)IOClass.loadGame();
        else dd.setMaze(IOClass.readInitialConfig());
        if(dd==null)dd.setMaze(IOClass.readInitialConfig());
        boolean ok=true;
        while((!dd.gameOver())&&(ok==true)){
            dd.view();
            aux=IOClass.readCommand();
            System.out.println(aux[0]+" "+aux[1]);
            if(aux[0]==2){ IOClass.saveGame(dd); ok=false;};
            if(aux[0]==3) dd=(Board)IOClass.loadGame();
            if(aux[0]==4) System.exit(0);;
            if(aux[0]<2) dd.setMove(aux);     

        }

    }
}
