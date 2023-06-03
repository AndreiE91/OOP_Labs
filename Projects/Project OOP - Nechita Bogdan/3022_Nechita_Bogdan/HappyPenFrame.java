
/**
 * This is the main frame for the application. It creates the GUI.
 * 
 * @author Nechita Bogdan 
 * @version 05.02.2009
 */
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import static java.awt.Color.*;
import static Constants.HappyPenConstants.*;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.AbstractAction;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JFileChooser;
import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class HappyPenFrame extends JFrame implements Observer
{
    private JMenuBar menuBar = new JMenuBar();
    private JMenuItem newItem, openItem, closeItem, saveItem, saveAsItem,
            lineItem, rectangleItem,circleItem,curveItem,redItem, yellowItem,greenItem,blueItem;
    private Color elementColor = DEFAULT_ELEMENT_COLOR;
    private int elementType = DEFAULT_ELEMENT_TYPE;
    // File actions
    private FileAction newAction, openAction, closeAction,
            saveAction, saveAsAction, printAction;
    // Type actions
    private TypeAction lineAction, rectangleAction, circleAction, curveAction;
    // Element color actions
    private ColorAction redAction, yellowAction,
            greenAction, blueAction;
    
    private JToolBar toolBar;
    private HappyPen theApp;  
    private String frameTitle;
    private String filename = DEFAULT_FILENAME; 
    private File modelFile; 
    private boolean drawingChanged = false;
    private JFileChooser files;
    
    
    //constructor
    public HappyPenFrame(String title, HappyPen theApp)
    {
        //set window title
        frameTitle = title + ": ";
        setTitle(frameTitle + filename);
        
        if(!DEFAULT_DIRECTORY.exists()) {
            if(!DEFAULT_DIRECTORY.mkdirs()) {
                JOptionPane.showMessageDialog(this, "Error creating default directory",
                "Directory Creation Error",
                JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }
        
        this.theApp = theApp;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //add menu bar to window
        setJMenuBar(menuBar);
        
        //create menu elements
        JMenu fileMenu = new JMenu("File");
        JMenu elementMenu = new JMenu("Elements");
                   
       //create the action items for the File menu
       newAction = new FileAction("New");
       openAction = new FileAction("Open");
       closeAction = new FileAction("Close");
       saveAction = new FileAction("Save");       
       saveAsAction = new FileAction("Save As...");
       
       //create the file drop down menu 
       fileMenu.add(new JMenuItem(newAction)).setIcon(null);
       fileMenu.add(new JMenuItem(openAction)).setIcon(null);
       fileMenu.add(new JMenuItem(closeAction)).setIcon(null);
       fileMenu.addSeparator(); 
       fileMenu.add(new JMenuItem(saveAction)).setIcon(null);
             
              
       // build the Element drop down menu
       elementMenu.add(new JMenuItem(lineAction = new TypeAction("Line", LINE))).setIcon(null);
       elementMenu.add(new JMenuItem(rectangleAction = new TypeAction("Rectangle", RECTANGLE))).setIcon(null);
       elementMenu.add(new JMenuItem(circleAction = new TypeAction("Circle", CIRCLE))).setIcon(null);
       elementMenu.add(new JMenuItem(curveAction = new TypeAction("Curve", CURVE))).setIcon(null);
       elementMenu.addSeparator();
       JMenu colorMenu = new JMenu("Color"); 
       elementMenu.add(colorMenu); 
       colorMenu.add(new JMenuItem(redAction = new ColorAction("Red", RED))).setIcon(null);
       colorMenu.add(new JMenuItem(yellowAction = new ColorAction("Yellow", YELLOW))).setIcon(null);
       colorMenu.add(new JMenuItem(greenAction = new ColorAction("Green", GREEN))).setIcon(null);
       colorMenu.add(new JMenuItem(blueAction = new ColorAction("Blue", BLUE))).setIcon(null);
             
       // adding the toolbar
       toolBar = new JToolBar();
       toolBar.setBorder(BorderFactory.createEtchedBorder(WHITE, LIGHT_GRAY));
       
       // Add element type buttons
       toolBar.addSeparator();
       addToolBarButton(lineAction);
       addToolBarButton(rectangleAction);
       addToolBarButton(circleAction);
       addToolBarButton(curveAction);
       // Add element color buttons
       toolBar.addSeparator();
       addToolBarButton(redAction);
       addToolBarButton(yellowAction);
       addToolBarButton(greenAction);
       addToolBarButton(blueAction);
       toolBar.addSeparator();
       
       getContentPane().add(toolBar, BorderLayout.NORTH);
       
       //add the file menu
        menuBar.add(fileMenu);
        menuBar.add(elementMenu);
        //set the default directory of the file chooser
        files = new JFileChooser(DEFAULT_DIRECTORY);
    }
    
    //inner class that handles type menu items
       class TypeListener implements ActionListener
       {
           private int type;
           
           TypeListener(int type)
            {
               this.type = type;
            }
            //set element type
            public void actionPerformed(ActionEvent e)
            {
                elementType = type;
            }
        }
        
     // inner class that handles color menu items
     class ColorListener implements ActionListener
     {
         private Color color;
         
         public ColorListener(Color color)
            {
             this.color = color;
            }
         //set the color
         public void actionPerformed(ActionEvent e)
         {
             elementColor = color;
            }
     }
     
     // inner class handling actions for File menu
     class FileAction extends AbstractAction
     {
         FileAction(String name)
         {
             super(name); 
             String iconFileName = "Images/" + name + ".gif";
             if(new File(iconFileName).exists()) {
                 putValue(SMALL_ICON, new ImageIcon(iconFileName));
                }
            }
         public void actionPerformed(ActionEvent e)
         {
             String name = (String)getValue(NAME);
             if(name.equals(saveAction.getValue(NAME))) {
                 saveOperation();
                
                } else if(name.equals(openAction.getValue(NAME))) {
                    checkForSave();
                    // Now open a sketch file
                    File file = showDialog(
                    "Open Drawing File", 
                    "Open", // Button lable
                    "Read a sketch from file", 
                    null); // No file selected
                    if(file != null) { // If a file was selected
                        openDrawing(file); // then read it
                    }
                } else if(name.equals(newAction.getValue(NAME))) {
                    checkForSave();
                    theApp.insertModel(new DrawingModel()); 
                    modelFile = null; 
                    filename = DEFAULT_FILENAME; 
                    setTitle(frameTitle + files.getCurrentDirectory() + "\\" + filename);
                    drawingChanged = false; 
                } 
            }
     }
     // inner class for handling actions for element menu
     class TypeAction extends AbstractAction
     {
         private int typeId;
         TypeAction(String name, int typeId)
         {
            super(name);
            this.typeId = typeId;
            String iconFileName = "Images/" + name + ".gif";
             if(new File(iconFileName).exists()) {
                 putValue(SMALL_ICON, new ImageIcon(iconFileName));
                }
         }
         public void actionPerformed(ActionEvent e)
         {
             elementType = typeId;
            }
     }
     
     // inner class for handling actions for color menu items
     class ColorAction extends AbstractAction
     {
         private Color color;         
         public ColorAction(String name, Color color) {
             super(name);
             this.color = color;
             String iconFileName = "Images/" + name + ".gif";
             if(new File(iconFileName).exists()) {
                 putValue(SMALL_ICON, new ImageIcon(iconFileName));
                }
            }
            public void actionPerformed(ActionEvent e) {
                elementColor = color;
          }
        }
     // Method to add a button to the toolbar
     private JButton addToolBarButton(Action action)
     {
         JButton button = new JButton(action);
         button.setBorder(BorderFactory.createRaisedBevelBorder());
         button.setText(null);
         toolBar.add(button);
         return button;
        }
      public Color getElementColor() 
      {
          return elementColor;
        }
      public int getElementType() 
      {
          return elementType;
        }
      public void update(Observable o, Object obj) 
      {
          drawingChanged = true;
        }
      //  file save dialog
      private File showDialog(String dialogTitle,
      String approveButtonText,
      String approveButtonTooltip,
      File file) { // Current file – if any
          files.setDialogTitle(dialogTitle);
          files.setApproveButtonText(approveButtonText);
          files.setApproveButtonToolTipText(approveButtonTooltip);
          files.setFileSelectionMode(files.FILES_ONLY);
          files.rescanCurrentDirectory();
          files.setSelectedFile(file);
          int result = files.showDialog(HappyPenFrame.this, null); // Show the dialog
          return (result == files.APPROVE_OPTION) ? files.getSelectedFile() : null;
        }
       // deciding if the drawing must be saved or not
       private void saveOperation() {
           if(!drawingChanged) {
               return;
            }
            File file = modelFile;
            if(file == null) {
                file = showDialog("Save Drawing","Save","Save the drawing",
                new File(files.getCurrentDirectory(), filename));
                if(file == null || (file.exists() && // Check for existence
                JOptionPane.NO_OPTION == // Overwrite warning
                JOptionPane.showConfirmDialog(HappyPenFrame.this,
                file.getName()+" exists. Overwrite?",
                "Confirm Save",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE)))
                return; // No selected file
            }
            saveSketch(file);
        }
        // writing the drawing to a file
        private void saveSketch(File outFile) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(outFile)));
                out.writeObject(theApp.getModel()); 
                out.close(); 
            } catch(IOException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(HappyPenFrame.this,
                "Error writing the drawing file.",
                "File Output Error",
                JOptionPane.ERROR_MESSAGE);
                return; 
            }
            if(outFile != modelFile) 
            { 
                modelFile = outFile; 
                filename = modelFile.getName(); 
                setTitle(frameTitle + modelFile.getPath()); 
            }
            drawingChanged = false; 
        }
            // Prompt for save operation when necessary
         public void checkForSave() 
            {
                if(drawingChanged && JOptionPane.YES_OPTION ==
                JOptionPane.showConfirmDialog(HappyPenFrame.this,
                "Current file has changed. Save current file?",
                "Confirm Save Current File",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE)) 
                {
                    saveOperation();
                }
            }
        // Method for opening file
        public void openDrawing(File inFile) 
        {
            try {
                ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream(inFile)));
                theApp.insertModel((DrawingModel)in.readObject());
                in.close();
                modelFile = inFile;
                filename = modelFile.getName(); // Update the file name
                setTitle(frameTitle+modelFile.getPath()); // Change the window title
                drawingChanged = false; 
            } catch(Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(HappyPenFrame.this,
                "Error reading a drawing file.",
                "File Input Error",
                JOptionPane.ERROR_MESSAGE);
            }
        }
}
