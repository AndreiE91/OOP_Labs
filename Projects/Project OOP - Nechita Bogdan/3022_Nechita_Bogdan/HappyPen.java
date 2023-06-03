
/**
 * This class is the main application class.
 * 
 * @author Bogdan Nechita
 * @version 05.02.2009
 */
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;


public class HappyPen
{
    private HappyPenFrame window;
    private DrawingModel drawing;
    private DrawingView drawingView;
    private static HappyPen theApp;
    
    public static void main(String[] args)
    {     
        theApp = new HappyPen();
        SwingUtilities.invokeLater(        
            new Runnable()
            {
                public void run()
                {
                    theApp.createGUI();
                }
            });
        
    }   
    
    // method that creates the application GUI
       public void createGUI()
       {
           // create application window
        window = new HappyPenFrame("Happy Pen", this);        
        Toolkit theKit = window.getToolkit();
        Dimension windowSize = theKit.getScreenSize();
        
        //set position at center of screen and size half of the screen size
        window.setBounds(windowSize.width/4, windowSize.height/4,
                        windowSize.width/2, windowSize.height/2);
        drawing = new DrawingModel();
        drawingView = new DrawingView(this);
        drawing.addObserver(drawingView);
        drawing.addObserver(window);
        window.getContentPane().add(drawingView, BorderLayout.CENTER);
        window.setVisible(true);
    }
    
    public HappyPenFrame getWindow()
    {
        return window;
    }
    public DrawingModel getModel()
    {
        return drawing;
    }
    public DrawingView getView()
    {
        return drawingView;
    }
    
    // Handler class for window events
    class WindowHandler extends WindowAdapter 
    {
        // Handler for window closing event
        public void windowClosing(WindowEvent e) 
        {
           
        }
    }
    // Insert a new drawing model
    public void insertModel(DrawingModel newDrawing) {
        drawing = newDrawing; // Store the new sketch
        drawing.addObserver(drawingView); // Add the view as observer
        drawing.addObserver(window); // Add the app window as observer
        drawingView.repaint(); // Repaint the view
    }
}
