
/**
 * This class displays the drawing.
 * 
 * @author Bogdan Nechita
 * @version 05.02.2009
 */

import javax.swing.JComponent;
import java.util.Observer;
import java.util.Observable;
import java.awt.Graphics;
import java.awt.Graphics2D;


import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

import static Constants.HappyPenConstants.*;
import java.awt.Rectangle;

class DrawingView extends JComponent implements Observer
{
    private HappyPen theApp;
    private Point start; // Stores cursor position on press
    private Point last; // Stores cursor position on drag
    private Element tempElement; // Stores a temporary element
    private boolean button1Down = false;
    
    public DrawingView(HappyPen theApp)
    {
        this.theApp = theApp;
        MouseHandler handler = new MouseHandler(); // create the mouse listener
        addMouseListener(handler); // Listen for button events
        addMouseMotionListener(handler); // Listen for motion events
    }
    public void update(Observable o, Object rectangle)
    {
        if(rectangle != null & rectangle instanceof Rectangle) {
            repaint((Rectangle)rectangle);
        } else {
            repaint();
        }
        
    }
    public void paint(Graphics g)
    {
        Graphics2D g2D = (Graphics2D)g;
        
        for(Element element : theApp.getModel())
        {
            //element = (Element)elements.next();
            g2D.setPaint(element.getColor());
            g2D.draw(element.getShape());
        }
        
    }
    class MouseHandler extends MouseInputAdapter 
    {
        private Graphics2D g2D = null;
        public void mousePressed(MouseEvent e) {
           start = e.getPoint();
          if(button1Down = (e.getButton() == MouseEvent.BUTTON1)) 
          {
              g2D = (Graphics2D)getGraphics(); 
              g2D.setXORMode(getBackground()); 
              g2D.setPaint(theApp.getWindow().getElementColor()); 
            }
        }
        public void mouseDragged(MouseEvent e) {
            last = e.getPoint(); 
            if(button1Down) {
                if(tempElement == null) 
                { 
                    tempElement = createElement(start, last); 
                } 
                else 
                {
                    g2D.draw(tempElement.getShape()); 
                    tempElement.modify(start, last); 
                }
                g2D.draw(tempElement.getShape()); 
            }
        }
        public void mouseReleased(MouseEvent e) 
        {
            if(button1Down = (e.getButton()==MouseEvent.BUTTON1)) 
            {
                button1Down = false; 
                if(tempElement != null) 
                { 
                    theApp.getModel().add(tempElement); 
                    tempElement = null; 
                }
                if(g2D != null) 
                {
                    g2D.dispose(); 
                    g2D = null; 
                }
                start = last = null; 
            }
        }

        
        private Element createElement(Point start, Point end) 
        {
            switch(theApp.getWindow().getElementType()) {
                case LINE:
                return new Element.Line(start, end,
                theApp.getWindow().getElementColor());               
                case RECTANGLE:
                return new Element.Rectangle(start, end, theApp.getWindow().getElementColor());
                case CIRCLE:
                return new Element.Circle(start, end, theApp.getWindow().getElementColor());
                case CURVE:
                return new Element.Curve(start, end, theApp.getWindow().getElementColor());
               
                default:
                assert false; 
            }
            return null;
        }
    }
}
