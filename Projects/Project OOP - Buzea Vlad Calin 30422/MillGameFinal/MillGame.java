import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * This is the Class where pe play the game.The Game Model!
 * Here we shall place the pieces on the board and respond to inputs.
 * 
 * @author Buzea Vlad-Calin
 * @version 1.0 (05-01-2014)
 */

public class MillGame
{
    /**
     * board is the matrix behind the model
     */
    protected static Piece[][] board;
    private static Piece selected=new Piece();
    
    private static final int NB_PIECES=9;
    private int blacks=NB_PIECES;
    private int whites=NB_PIECES;
    private int iBlacks=NB_PIECES;
    private int iWhites=NB_PIECES;
    
    private boolean firstMove=true;
    private static boolean isTurnWhite=true;
    private  static boolean millCase=false;
    
    
    /**
     * 
     * Variable initialization.
     */
    public MillGame()
    {
        board=new Piece[7][7];
        int i,j;
        for(i=0;i<7;i++)
            for(j=0;j<7;j++)
                board[i][j]=new Piece();
    }
    /**
     * resets game to initial values
     */
    public void reset()
    {
     blacks=NB_PIECES;
     whites=NB_PIECES;
     iBlacks=NB_PIECES;
     iWhites=NB_PIECES;
    
     firstMove=true;
     isTurnWhite=true;
     millCase=false;
     
     int i,j;
     for(i=0;i<=6;i++)
        for(j=0;j<=6;j++)
            board[i][j]=new Piece();
    
    }
    /**
     *toString() returns the board matrix in string form.
     */
    public String toString()
    {
        int i,j;
        String x="";
        for(i=0;i<7;i++)
            {for(j=0;j<7;j++)
                {if(board[i][j]!=null)
                    x+=board[i][j].toString();
                    //else
                    //x+="null";
                 x+=" ";
                }
            x+="\n";
            }
        return x;
    }
    /**
     * returns a String that contains the number of white and black pieces left to put on the board.
     */
    public String leftToPut()
    {
        return " W="+iWhites+"\n B="+iBlacks;
    }
    /**
     * Verifies if a player has any possible moves
     */
    private boolean possibleMoves(String color)
    {
        int i,j;
        Piece ind=new Piece();
        if(color.equals("White"));
        if(iWhites>9)
            return true;
        if(color.equals("Black"));    
        if(iBlacks>9)
            return true;
        for(i=0;i<=6;i++)
            for(j=0;j<=6;j++)
                if(board[i][j].getColor().equals(color))
                    {
                        ind=board[i][j];
                        ind.moveUp();
                        if(isValid(ind.getX(),ind.getY()))
                            if(board[ind.getX()][ind.getY()].getColor().equals("null"))
                                return true;
                        ind=board[i][j];
                        ind.moveDown();
                        if(isValid(ind.getX(),ind.getY()))
                            if(board[ind.getX()][ind.getY()].getColor().equals("null"))
                                return true;
                        ind=board[i][j];
                        ind.moveLeft();
                        if(isValid(ind.getX(),ind.getY()))
                            if(board[ind.getX()][ind.getY()].getColor().equals("null"))
                                return true;
                        ind=board[i][j];
                        ind.moveRight();
                        if(isValid(ind.getX(),ind.getY()))
                            if(board[ind.getX()][ind.getY()].getColor().equals("null"))
                                return true;
                    }
        return false;
    }
    /**
     * isValid is a method used to check if the selected positon is on the board. 
     */
    private boolean isValid(int x,int y)
    {
        
        //check if in board
        if(x<0)
            return false;
        if(x>6)
            return false;
        if(y<0)
            return false;
        if(y>6)
            return false;
        //check for valid board position
        if((x==3)&&(y==3))
            return false;
        if((x==0)||(x==6))
        {
            if((y==1)||(y==2)||(y==4)||(y==5))
                return false;
        }
        if((x==1)||(x==5))
        {
            if((y==0)||(y==2)||(y==4)||(y==6))
                return false;
        }
        if((x==2)||(y==4))
        {
            if((y==0)||(y==1)||(y==5)||(y==6))
            return false;
        }
        
        return true;
    }
    /**
     * After we moved a piece, we check if that piece forms a mill.
     */
    private boolean formedMill(Piece n)
    {
        int count=0,i,j;
        if(n.getColor().equals("null"))
            return false;
        if(n.getX()==3)
           {if(n.getY()<3)
            if((board[3][0].getColor().equals(board[3][1].getColor()))&&(board[3][1].getColor().equals(board[3][2].getColor())))
                return true;
            if(n.getY()>3)
            if((board[3][4].getColor().equals(board[3][5].getColor()))&&(board[3][5].getColor().equals(board[3][6].getColor())))
                return true;
            for(i=0,count=0,j=n.getY();i<7;i++)
                if(board[i][j].getColor().equals(n.getColor()))
                        count++;
            if(count==3)
                    return true;
            }
            else
             if(n.getY()==3)
        
           {if(n.getX()<3)
            if((board[0][3].getColor().equals(board[1][3].getColor()))&&(board[1][3].getColor().equals(board[2][3].getColor())))
                return true;
            if(n.getX()>3)
            if((board[4][3].getColor().equals(board[5][3].getColor()))&&(board[5][3].getColor().equals(board[6][3].getColor())))
                return true;
            
            for(i=n.getX(),count=0,j=0;j<7;j++)
                if(board[i][j].getColor().equals(n.getColor()))
                        count++;
            if(count==3)
                    return true;
            }
            else
            {
                for(i=0,count=0,j=n.getY();i<7;i++)
                    if(board[i][j].getColor().equals(n.getColor()))
                        count++;
                if(count==3)
                    return true;
                for(i=n.getX(),count=0,j=0;j<7;j++)
                    if(board[i][j].getColor().equals(n.getColor()))
                        count++;
                if(count==3)
                    return true;
            }
        return false;
    }
    /**
     * This checks if there are any pieces that don't form a Mill so that they may be eaten.
     * 
     */
    private boolean freePiece(String color)
    {
        int i,j;
        for(i=0;i<=6;i++)
            for(j=0;j<=6;j++)
                if(board[i][j].getColor().equals(color))
                    if(!formedMill(board[i][j]))
                        return true;
        return false;
    }
    /**
     * This method is used to add a piece to the board, using board coordinates X and Y and piece Color.It returns the added piece.
     * 
     */
    public Piece addPiece(int x,int y,String color) throws BadMoveException
    {
        if(isValid(x,y))
           if(board[x][y].getColor()=="null")
             {Piece temp=new Piece(x,y,color);
                board[x][y]=temp;
             return temp;
            }
            else
                throw new BadMoveException("There is a already a piece there!");
           else 
           throw new BadMoveException("Not on board!");
    }
    /**
     * The scope of this method is to eat pieces from the board. It should be used when a mill is formed. The piece to be eaten is chosen using it's x and y coordinates. The piece color is transmited as parameter only for validation.
     */
    private void eatPiece(int x,int y,String color) throws BadMoveException
    {
        if(isValid(x,y))
          if(color.equals(board[x][y].getColor()))
            if(!formedMill(board[x][y]))
                board[x][y]=new Piece();
                else
                throw new BadMoveException("The piece is in a mill and can't bea eaten");
                else
                throw new BadMoveException("Bad piece color!");
          else
             throw new BadMoveException("Not on Board!");
    }
    
    /**
     * Returns a piece selected from the board. The piece is selected through the parameters x , y. You must also specify the color for validation
     */
    private Piece selectPiece(int x,int y,String color) throws BadMoveException
    {
        if(isValid(x,y))
        {Piece temp=board[x][y];
        if(temp.getColor().equals(color))
        {
            return temp;
        }
        else
        throw new BadMoveException("You can't select that!");
        }
        else
        throw new BadMoveException("Not On Board!");
    
    }
    /**
     * Method used to move a piece from one location to a neighboring one on the board.
     */
    private Piece moveTo(int x,int y,Piece selected) throws BadMoveException
    {
        if(isValid(x,y))
            {if(board[x][y].getColor().equals("null"))
                {
                    if(x==selected.getX())
                        {if((x==0)||(x==6))
                            if(Math.abs(y-selected.getY())==3)
                                   {
                                       board[selected.getX()][selected.getY()]=new Piece();
                                       selected.jump(x,y);
                                       board[x][y]=selected;
                                    }
                                    else throw new BadMoveException("Bad Move!");
                         if((x==1)||(x==5))
                            if(Math.abs(y-selected.getY())==2)
                                   {
                                       board[selected.getX()][selected.getY()]=new Piece();
                                       selected.jump(x,y);
                                       board[x][y]=selected;
                                    }
                                    else throw new BadMoveException("Bad Move!");
                        if((x>1)&&(x<5))
                            if(Math.abs(y-selected.getY())==1)
                                   {
                                       board[selected.getX()][selected.getY()]=new Piece();
                                       selected.jump(x,y);
                                       board[x][y]=selected;
                                    }
                                    else throw new BadMoveException("Bad Move!");            
                            
                        }
                        else
                        if(y==selected.getY())
                        {if((y==0)||(y==6))
                            if(Math.abs(x-selected.getX())==3)
                                   {
                                       board[selected.getX()][selected.getY()]=new Piece();
                                       selected.jump(x,y);
                                       board[x][y]=selected;
                                    }
                                    else throw new BadMoveException("Bad Move!");
                         if((y==1)||(y==5))
                            if(Math.abs(x-selected.getX())==2)
                                   {
                                       board[selected.getX()][selected.getY()]=new Piece();
                                       selected.jump(x,y);
                                       board[x][y]=selected;
                                    }
                                    else throw new BadMoveException("Bad Move!");
                        if((y>1)&&(y<5))
                            if(Math.abs(x-selected.getX())==1)
                                   {
                                       board[selected.getX()][selected.getY()]=new Piece();
                                       selected.jump(x,y);
                                       board[x][y]=selected;
                                    }
                                    else throw new BadMoveException("Bad Move!");            
                            }
                            else
                            throw new BadMoveException("Bad Move!");
                }
            else
                throw new BadMoveException("You can't move over another piece!");
            }
        else 
            throw new BadMoveException("Not on board!");
        return board[x][y];
    }
  
    /**
     * Method used in last Phase, when a player has exactly 3 pieces for jumping a Piece from a position to any other free position on the board
     */
    private Piece jumpTo(int x,int y,Piece selected) throws BadMoveException
    {
        if(isValid(x,y))
            if(board[x][y].getColor().equals("null"))
            {
            board[selected.getX()][selected.getY()]=new Piece();
            selected.jump(x,y);
            board[x][y]=selected;
            }
            else throw new BadMoveException("Bad Move!");
            else throw new BadMoveException("Not on board!");
        return board[x][y];
    }
/**
 * return "GAME OVER" if a player has 2 pieces left and "Game in progres" otherwise
 */
public String setGameOver()   
{
    if(whites==2)
        return "GAME OVER! BLACK WINS!";
    if(blacks==2)
        return "GAME OVER! WHITE WINS!";
   /* if(!possibleMoves("White"))
        return "GAME OVER! BLACK WINS";
    if(!possibleMoves("Black"))
        return "GAME OVER! WHITE WINS";*/
    return "Game in progress";
    
}   
/**dectectAction is the main acting method of the class (detect & action). It detects the game phase and Acts accordingly. The input parameters x and y are board(game matrix) coordinates, recieved from the control.
 * It ties all the precedent methods together to form a whole program.
 */
    
public void detectAction(int x,int y)
{   
    if(millCase)
    {   
        
        try{eatPiece(x,y,selected.getOpositeColor());
            millCase=false;
            if(selected.getOpositeColor().equals("White"))
                whites--;
                else
                blacks--;
            selected=new Piece();
        }catch(BadMoveException e)
        {
            e.printMesage();
        }
    }
    else
    {if((iBlacks>0)||(iWhites>0))
    {
        if(iWhites<iBlacks)
            try{selected=addPiece(x,y,"Black");iBlacks--;}catch(BadMoveException e)
        {
            e.printMesage();
        }
            else
            try{selected=addPiece(x,y,"White");iWhites--;isTurnWhite=true;}catch(BadMoveException e)
        {
            e.printMesage();
        }
        if(formedMill(selected))
            if(freePiece(selected.getOpositeColor()))
                {millCase=true;
                 System.out.println("Select piece to be eaten!");}
    }
    else
    {
        if(firstMove)
        {
            selected=new Piece();
            firstMove=false;
        }
        if(selected.getColor().equals("null"))
   {     if(isTurnWhite)
               try{selected=selectPiece(x,y,"White");
                  // isTurnWhite=false;
                }catch(BadMoveException e)
        {
            e.printMesage();
        }
                else
            try{selected=selectPiece(x,y,"Black");
               // isTurnWhite=true;
            }catch(BadMoveException e)
        {
            e.printMesage();
        }
    }
        else
        {
            if(isTurnWhite)
            {
                if(whites>3)
                {try{selected=moveTo(x,y,selected);
                isTurnWhite=false;}catch(BadMoveException e)
        {
            e.printMesage();
        }
                }
                else
                if(whites==3)
                {
                    try{selected=jumpTo(x,y,selected);
                        isTurnWhite=false;}catch(BadMoveException e)
        {
            e.printMesage();
        }
                    
                }
                    else
                {
                    System.out.println("GAME OVER! BLACK WINS!");
                    System.exit(0); 
                }
            }
            else
            {
                if(blacks>3)
                {try{selected=moveTo(x,y,selected);
                isTurnWhite=true;}catch(BadMoveException e)
        {
            e.printMesage();
        }
              }
              else
              if(blacks==3)
              {
                 try{selected=jumpTo(x,y,selected);
                     isTurnWhite=true;}catch(BadMoveException e)
        {
            e.printMesage();
        } 
              }
                else
                {
                    System.out.println("GAME OVER! WHITE WINS");
                    System.exit(0); 
                }
            }
        if(formedMill(selected))
            if(freePiece(selected.getOpositeColor()))
                {millCase=true;
                 System.out.println("Select piece to be eaten!");}
                 else
                    selected=new Piece();
           else
                    selected=new Piece();
        }
    }
}
}    



}
