import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
public class MillPanel extends JPanel
{
    private static final double LD=40;//distance between lines
    private static final double HEIGHT=650;
    private static final double WIDTH=450;
    private MillGame model;
    
    public boolean clicked=false,doubleClicked=false;
    public int _X,_Y;
    public MillPanel(MillGame _model )
    {
        model=_model;
        setSize((int)WIDTH,(int)HEIGHT);
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2=(Graphics2D)g;
        g2.setColor(Color.yellow);
        g2.fill(new Rectangle2D.Double(0,0,WIDTH,HEIGHT));
        g2.setColor(Color.blue);
        //draw Lines (Rectangles)
        g2.draw(new Rectangle2D.Double(LD,LD,WIDTH-2*LD,HEIGHT-2*LD));
        g2.draw(new Rectangle2D.Double(2*LD,2*LD,WIDTH-4*LD,HEIGHT-4*LD));
        g2.draw(new Rectangle2D.Double(3*LD,3*LD,WIDTH-6*LD,HEIGHT-6*LD));
        g2.draw(new Line2D.Double(LD,HEIGHT/2,3*LD,HEIGHT/2));
        g2.draw(new Line2D.Double(WIDTH-3*LD,HEIGHT/2,WIDTH-LD,HEIGHT/2));
        g2.draw(new Line2D.Double(WIDTH/2,LD,WIDTH/2,3*LD));
        g2.draw(new Line2D.Double(WIDTH/2,HEIGHT-LD,WIDTH/2,HEIGHT-3*LD));
        //draw Piece Points
        g2.fill(new Ellipse2D.Double(LD-5,LD-5,10,10));
        g2.fill(new Ellipse2D.Double(LD-5,HEIGHT/2-5,10,10));
        g2.fill(new Ellipse2D.Double(LD-5,HEIGHT-LD-5,10,10));
        
        g2.fill(new Ellipse2D.Double(WIDTH-LD-5,HEIGHT-LD-5,10,10));
        g2.fill(new Ellipse2D.Double(WIDTH-LD-5,HEIGHT/2-5,10,10));
        g2.fill(new Ellipse2D.Double(WIDTH-LD-5,LD-5,10,10));
     
        g2.fill(new Ellipse2D.Double(2*LD-5,2*LD-5,10,10));
        g2.fill(new Ellipse2D.Double(2*LD-5,HEIGHT/2-5,10,10));
        g2.fill(new Ellipse2D.Double(2*LD-5,HEIGHT-2*LD-5,10,10));
        
        g2.fill(new Ellipse2D.Double(WIDTH-2*LD-5,2*LD-5,10,10));
        g2.fill(new Ellipse2D.Double(WIDTH-2*LD-5,HEIGHT/2-5,10,10));
        g2.fill(new Ellipse2D.Double(WIDTH-2*LD-5,HEIGHT-2*LD-5,10,10));
        
        g2.fill(new Ellipse2D.Double(WIDTH/2-5,LD-5,10,10));
        g2.fill(new Ellipse2D.Double(WIDTH/2-5,2*LD-5,10,10));
        g2.fill(new Ellipse2D.Double(WIDTH/2-5,3*LD-5,10,10));
        
        g2.fill(new Ellipse2D.Double(WIDTH/2-5,HEIGHT-LD-5,10,10));
        g2.fill(new Ellipse2D.Double(WIDTH/2-5,HEIGHT-2*LD-5,10,10));
        g2.fill(new Ellipse2D.Double(WIDTH/2-5,HEIGHT-3*LD-5,10,10));
        
        g2.fill(new Ellipse2D.Double(3*LD-5,3*LD-5,10,10));
        g2.fill(new Ellipse2D.Double(3*LD-5,HEIGHT/2-5,10,10));
        g2.fill(new Ellipse2D.Double(3*LD-5,HEIGHT-3*LD-5,10,10));
        
        g2.fill(new Ellipse2D.Double(WIDTH-3*LD-5,3*LD-5,10,10));
        g2.fill(new Ellipse2D.Double(WIDTH-3*LD-5,HEIGHT/2-5,10,10));
        g2.fill(new Ellipse2D.Double(WIDTH-3*LD-5,HEIGHT-3*LD-5,10,10));
        
        //painting the Pieces on the Board
        //------------------------------------------------------------------
        if(model.board[0][0].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(LD-15,LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(LD-15,LD-15,30,30));
        }
        if(model.board[0][0].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(LD-15,LD-15,30,30));
        }
        //------------------------------------------------------------
        if(model.board[0][3].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(WIDTH/2-15,LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(WIDTH/2-15,LD-15,30,30));
        }
        if(model.board[0][3].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(WIDTH/2-15,LD-15,30,30));
        }
        
        //-----------------------------------------------------
       
        if(model.board[0][6].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(WIDTH-LD-15,LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(WIDTH-LD-15,LD-15,30,30));
        }
        if(model.board[0][6].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(WIDTH-LD-15,LD-15,30,30));
        }
        
        //-----------------------------------------------------
        
        if(model.board[1][1].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(2*LD-15,2*LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(2*LD-15,2*LD-15,30,30));
        }
        if(model.board[1][1].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(2*LD-15,2*LD-15,30,30));
        }
        
        //-----------------------------------------------------
        
        if(model.board[1][3].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(WIDTH/2-15,2*LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(WIDTH/2-15,2*LD-15,30,30));
        }
        if(model.board[1][3].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(WIDTH/2-15,2*LD-15,30,30));
        }
        
        //-----------------------------------------------------
        
        if(model.board[1][5].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(WIDTH-2*LD-15,2*LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(WIDTH-2*LD-15,2*LD-15,30,30));
        }
        if(model.board[1][5].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(WIDTH-2*LD-15,2*LD-15,30,30));
        }
        
        //-----------------------------------------------------
        
        if(model.board[2][2].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(3*LD-15,3*LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(3*LD-15,3*LD-15,30,30));
        }
        if(model.board[2][2].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(3*LD-15,3*LD-15,30,30));
        }
        
        //-----------------------------------------------------
        
        if(model.board[2][3].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(WIDTH/2-15,3*LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(WIDTH/2-15,3*LD-15,30,30));
        }
        if(model.board[2][3].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(WIDTH/2-15,3*LD-15,30,30));
        }
        
        //-----------------------------------------------------
        
         if(model.board[2][4].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(WIDTH-3*LD-15,3*LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(WIDTH-3*LD-15,3*LD-15,30,30));
        }
        if(model.board[2][4].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(WIDTH-3*LD-15,3*LD-15,30,30));
        }
        
        //-----------------------------------------------------
        
         if(model.board[3][0].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(LD-15,HEIGHT/2-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(LD-15,HEIGHT/2-15,30,30));
        }
        if(model.board[3][0].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(LD-15,HEIGHT/2-15,30,30));
        }
        
        //-----------------------------------------------------
        
         if(model.board[3][1].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(2*LD-15,HEIGHT/2-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(2*LD-15,HEIGHT/2-15,30,30));
        }
        if(model.board[3][1].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(2*LD-15,HEIGHT/2-15,30,30));
        }
        
        //-----------------------------------------------------
        
         if(model.board[3][2].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(3*LD-15,HEIGHT/2-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(3*LD-15,HEIGHT/2-15,30,30));
        }
        if(model.board[3][2].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(3*LD-15,HEIGHT/2-15,30,30));
        }
        
        //-----------------------------------------------------
        
         if(model.board[3][4].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(WIDTH-3*LD-15,HEIGHT/2-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(WIDTH-3*LD-15,HEIGHT/2-15,30,30));
        }
        if(model.board[3][4].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(WIDTH-3*LD-15,HEIGHT/2-15,30,30));
        }
        
        //-----------------------------------------------------
        
         if(model.board[3][5].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(WIDTH-2*LD-15,HEIGHT/2-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(WIDTH-2*LD-15,HEIGHT/2-15,30,30));
        }
        if(model.board[3][5].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(WIDTH-2*LD-15,HEIGHT/2-15,30,30));
        }
        
        //-----------------------------------------------------
        
         if(model.board[3][6].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(WIDTH-LD-15,HEIGHT/2-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(WIDTH-LD-15,HEIGHT/2-15,30,30));
        }
        if(model.board[3][6].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(WIDTH-LD-15,HEIGHT/2-15,30,30));
        }
        
        //-----------------------------------------------------
        
         if(model.board[4][2].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(3*LD-15,HEIGHT-3*LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(3*LD-15,HEIGHT-3*LD-15,30,30));
        }
        if(model.board[4][2].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(3*LD-15,HEIGHT-3*LD-15,30,30));
        }
        
        //-----------------------------------------------------
        
         if(model.board[4][3].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(WIDTH/2-15,HEIGHT-3*LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(WIDTH/2-15,HEIGHT-3*LD-15,30,30));
        }
        if(model.board[4][3].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(WIDTH/2-15,HEIGHT-3*LD-15,30,30));
        }
        
        //-----------------------------------------------------
        
         if(model.board[4][4].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(WIDTH-3*LD-15,HEIGHT-3*LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(WIDTH-3*LD-15,HEIGHT-3*LD-15,30,30));
        }
        if(model.board[4][4].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(WIDTH-3*LD-15,HEIGHT-3*LD-15,30,30));
        }
        
        //-----------------------------------------------------
        
         if(model.board[5][1].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(2*LD-15,HEIGHT-2*LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(2*LD-15,HEIGHT-2*LD-15,30,30));
        }
        if(model.board[5][1].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(2*LD-15,HEIGHT-2*LD-15,30,30));
        }
        
        //-----------------------------------------------------
        
         if(model.board[5][3].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(WIDTH/2-15,HEIGHT-2*LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(WIDTH/2-15,HEIGHT-2*LD-15,30,30));
        }
        if(model.board[5][3].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(WIDTH/2-15,HEIGHT-2*LD-15,30,30));
        }
        
        //-----------------------------------------------------
        
         if(model.board[5][5].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(WIDTH-2*LD-15,HEIGHT-2*LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(WIDTH-2*LD-15,HEIGHT-2*LD-15,30,30));
        }
        if(model.board[5][5].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(WIDTH-2*LD-15,HEIGHT-2*LD-15,30,30));
        }
        
        //-----------------------------------------------------
        
         if(model.board[6][0].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(LD-15,HEIGHT-LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(LD-15,HEIGHT-LD-15,30,30));
        }
        if(model.board[6][0].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(LD-15,HEIGHT-LD-15,30,30));
        }
        
        //-----------------------------------------------------
        
         if(model.board[6][3].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(WIDTH/2-15,HEIGHT-LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(WIDTH/2-15,HEIGHT-LD-15,30,30));
        }
        if(model.board[6][3].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(WIDTH/2-15,HEIGHT-LD-15,30,30));
        }
        
        //-----------------------------------------------------
        
        if(model.board[6][6].getColor().equals("White"))
        {
            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(WIDTH-LD-15,HEIGHT-LD-15,30,30));
            g2.setColor(Color.BLACK);
            g2.draw(new Ellipse2D.Double(WIDTH-LD-15,HEIGHT-LD-15,30,30));
        }
        if(model.board[6][6].getColor().equals("Black"))
        {
            g2.setColor(Color.BLACK);
            g2.fill(new Ellipse2D.Double(WIDTH-LD-15,HEIGHT-LD-15,30,30));
        }
         
    }
    public boolean getClick()
    {
        return clicked;
    }
    public void addML(MouseListener ml)
    {
        this.addMouseListener(ml);
    }
    public int transformColumn(int x)
    {
        if((LD-25<=x)&&(LD+25>=x))
            return 0;
        if((2*LD-25<=x)&&(2*LD+25>=x))
            return 1;
        if((3*LD-25<=x)&&(3*LD+25>=x))
            return 2;
        if((WIDTH/2-25<=x)&&(WIDTH/2+25>=x))
            return 3;
        if((WIDTH-3*LD-25<=x)&&(WIDTH-3*LD+25>=x))
            return 4;
        if((WIDTH-2*LD-25<=x)&&(WIDTH-2*LD+25>=x))
            return 5;
        if((WIDTH-LD-25<=x)&&(WIDTH-LD+25>=x))
            return 6;
        
        return 10;
    }
    public int transformRow(int y)
    {
        if((LD-25<=y)&&(LD+25>=y))
            return 0;
        if((2*LD-25<=y)&&(2*LD+25>=y))
            return 1;
        if((3*LD-25<=y)&&(3*LD+25>=y))
            return 2;
        if((HEIGHT/2-25<=y)&&(HEIGHT/2+25>=y))
            return 3;
        if((HEIGHT-3*LD-25<=y)&&(HEIGHT-3*LD+25>=y))
            return 4;
        if((HEIGHT-2*LD-25<=y)&&(HEIGHT-2*LD+25>=y))
            return 5;
        if((HEIGHT-LD-25<=y)&&(HEIGHT-LD+25>=y))
            return 6;
        
        return 10;
    }
   /* public void mousePressed(MouseEvent event) 
        {
            
        } 
    public void mouseReleased(MouseEvent event) 
        {
            repaint();
        } 
    public void mouseClicked(MouseEvent event) 
        {
            if(event.getClickCount()==1)
                clicked=true;
            if(event.getClickCount()==2)
                doubleClicked=true;
           int tempX,tempY;
           tempX=event.getX();
           tempY=event.getY();
           System.out.println(tempX+" "+tempY);
           if(tempX<30)
            _X=0;
            if(tempX<30)
            _Y=0;
          System.out.println(_X+" "+_Y);
          model.phaseOne();
          repaint();
        } 
    public void mouseEntered(MouseEvent event)
        {
        } 
    public void mouseExited(MouseEvent event)
        {
        }
        */
}