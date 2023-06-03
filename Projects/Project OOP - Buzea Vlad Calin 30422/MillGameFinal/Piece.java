
/**
 * This is class is ment to be placed on the board. It will have 9 instances/player
   */
public class Piece 
{
    // instance variables - position an color(player)
    private int x;
    private int y;
    private String color="";//Can be made of Class COLOR
    //public static int NUMBER;

    /**
     * Each piece must have a position on the board(x,y) and a colour
     */
    public Piece(int x,int y,String color)
    {
        this.x=x;
        this.y=y;
        this.color=color;
    }
    /**
     * The parameterless constructor is used only for null pieces
     */
    public Piece()
    {
        this.x=-1;
        this.y=-1;
        this.color="null";
    }
    /**
     * When the player is left with 3 pieces he may jump anywhere on the board if the position is vacant
     * jump recieves as parameters the coordinates of the new position
     */
    public void jump(int x,int y)
    {
        this.x=x;
        this.y=y;
    }

    /**
     * The move methods reposition the piece they are called from 
     */
    /**
     * moveUp moves the piece up with a position
     */
    public void moveUp()
    {
        if((this.y==0)||(this.y==6))
            this.x-=3;
            else
        if((this.y==2)||(this.y==5))
            this.x-=2;
            else
            this.x-=1;
        
    }
    
    /**
     * moveDown moves the piece down with a position
     */
    public void moveDown()
    {
        if((this.y==0)||(this.y==6))
            this.x+=3;
            else
        if((this.y==2)||(this.y==5))
            this.x+=2;
            else
            this.x+=1;
        
    }
    /**
     * moveLeft moves the piece left with a position
     */
    public void moveLeft()
    {
         if((this.x==0)||(this.x==6))
            this.y-=3;
            else
        if((this.x==2)||(this.x==5))
            this.y-=2;
            else
            this.y-=1;
        
    }
    
    /**
     * moveRight moves the piece right with a position
     */
    public void moveRight()
    {
         if((this.x==0)||(this.x==6))
            this.y+=3;
            else
        if((this.x==2)||(this.x==5))
            this.y+=2;
            else
            this.y+=1;
        
    }
    /**
     * getColor returns the color of the piece in String format
     */
    public String getColor()
    {
        return this.color;
    }
    /**
     * returns the oposite color of the calling Piece
     */
    public String getOpositeColor()
    {
        if(this.getColor().equals("White"))
            return "Black";
        return "White";
    }
    /**
     * returns String version of the Piece
     */
    public String toString()
    {
        if(this!=null)
            return this.color;
            else
            return "null";
    }
    /**
     * returns the X coordinate of the Piece
     */
    public int getX()
    {
        return this.x;
    }
    /**
     * returns the Y coordinate of the Piece
     */
    public int getY()
    {
        return this.y;
    }
}
