package Constants;


/**
 * This class contains the constants used in the HappyPen application.
 * 
 * @author Bogdan Nechita
 * @version 05.02.2009
 */
import java.awt.Color;
import java.io.File;

public class HappyPenConstants
{
    // Element type definitions
    public final static int LINE = 101;
    public final static int RECTANGLE = 102;
    public final static int CIRCLE = 103;
    public final static int CURVE = 104;
    // Initial conditions
    public final static int DEFAULT_ELEMENT_TYPE = LINE;
    public final static Color DEFAULT_ELEMENT_COLOR = Color.BLUE;
    public final static File DEFAULT_DIRECTORY = new File("C:/Drawings");
    public final static String DEFAULT_FILENAME = "Drawing.gif";
}
