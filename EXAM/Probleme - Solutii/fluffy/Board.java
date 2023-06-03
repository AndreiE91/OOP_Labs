
/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.lang.ArrayIndexOutOfBoundsException;
import java.io.Serializable;
public class Board implements Serializable
{
    private char[][] maze=new char[10][40];
    public Cat cat=new Cat(0,0);
    private int catx=0;
    private int caty=0;
    private boolean gameO=false;
    private char occupied=' ';
    public Board()
    {
        gameO=false;
    }

    public void setMaze(char [][] c)
    {
        maze=c;
        for(int i=0;i<10;i++)
            for(int j=0;j<40;j++)
                if(maze[i][j]=='F'){catx=i; caty=j;};
        cat.setCoord(catx,caty);
    }

    public boolean gameOver()
    {
        if(gameO)System.out.println("Mioa I bet I found my hat!");
        return gameO;
    }

    public boolean checkHat(int a, int b){
        boolean ok=false;
        System.out.println("Checking hat!");
        try{
            if((maze[a-1][b-1]=='H')&&(maze[a-1][b+1]=='H')&&(maze[a+1][b-1]=='H')&&(maze[a+1][b+1]=='H'))
            //&&(maze[a][b+1]=='H')&&(maze[a][b-1]=='H'))&&(maze[a+1][b]==' ')&&(maze[a-1][b]==' ')) 
                ok=true;
                System.out.println("In the hat!");
        }catch(ArrayIndexOutOfBoundsException e){System.out.println("ERROR HAT SEARCH"); }
        return ok;    
    }

    public void moveCat(int a, int b){
        int[] aux2=cat.getCoord();
        int ax=aux2[0];
        int ay=aux2[1];
        System.out.println("Moving cat from "+ax+" "+ay+" to "+a+" "+b); 
        maze[ax][ay]=occupied;
        maze[a][b]='F';
        cat.setCoord(a,b);
    }

    public void setMove(int[] aux)
    {
        int[] aux2=cat.getCoord();
        int ax=aux2[0];
        int ay=aux2[1];
        ax+=aux[0];
        ay+=aux[1];
        if((ax>=0)&&(ax<10)&&(ay>=0)&&(ay<40))
        {
            if(maze[ax][ay]!='*')
            {
                if(maze[ax][ay]==' ') {

                    moveCat(ax,ay);
                    occupied=' ';
                }else
                {//maybe is a H

                    gameO=checkHat(ax,ay);
                    if(!gameO) moveCat(ax,ay);
                     occupied='H';
                }
            }
            else System.out.println("I hit a wall!");
        }

    }

    public void view()
    {
        int[] aux2=cat.getCoord();
        int a=aux2[0];
        int b=aux2[1];
        System.out.println("What I see now:");
        try{
        System.out.println((char)maze[a-1][b-1]+""+(char)maze[a-1][b]+""+(char)maze[a-1][b+1]);
        System.out.println((char)maze[a][b-1]+""+(char)maze[a][b]+""+(char)maze[a][b+1]);
        System.out.println((char)maze[a+1][b-1]+""+(char)maze[a+1][b]+""+(char)maze[a+1][b+1]);
        }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Out of range!");
        }
        System.out.println("The entire board:");
        for(int i=0;i<10;i++){
            for(int j=0;j<40;j++)
                System.out.print((char)maze[i][j]);
            System.out.println("");
        }
    }
}
