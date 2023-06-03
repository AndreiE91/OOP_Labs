
/**
 * this class defines particular shapes.
 * 
 * @author Bogdan Nechita
 * @version 05.02.2009
 */
import java.awt.Color;
import java.awt.Shape;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.awt.geom.PathIterator;
import java.util.Vector;
import java.awt.geom.AffineTransform;

public abstract class Element implements Serializable
{
    protected Color color;
    public Element(Color color)
    {
        this.color = color;
    }
    
    public Color getColor()
    {
        return color;
    }
    public abstract Shape getShape();
    public abstract java.awt.Rectangle getBounds();
    public abstract void modify(Point start, Point last);
    
    // class to define a line
    public static class Line extends Element 
    {
        public Line(Point start, Point end, Color color) {
            super(color);
            line = new Line2D.Double(start, end);
        }
        
        public Shape getShape() {
            return line;
        }
        
        public java.awt.Rectangle getBounds() {
            return line.getBounds();
        }
       
        public void modify(Point start, Point last) {
            line.x2 = last.x;
            line.y2 = last.y;
        }
        private Line2D.Double line;
        // Method to serialize a line
        private void writeObject(ObjectOutputStream out) throws IOException {
            out.writeDouble(line.x2);
            out.writeDouble(line.y2);
        }
        // Method to deserialize a line
        private void readObject(ObjectInputStream in)
        throws IOException, ClassNotFoundException {
            double x2 = in.readDouble();
            double y2 = in.readDouble();
            line = new Line2D.Double(0,0,x2,y2);
        }
    }
    // class to define a rectangle
    public static class Rectangle extends Element 
    {
        public Rectangle(Point start, Point end, Color color) 
        {
            super(color);
            rectangle = new Rectangle2D.Double(
            Math.min(start.x, end.x), Math.min(start.y, end.y),
            Math.abs(start.x - end.x), Math.abs(start.y - end.y)); 
        }
        
        public Shape getShape() 
        {
            return rectangle;
        }
        
        public java.awt.Rectangle getBounds() {
            return rectangle.getBounds();
        }
        
        public void modify(Point start, Point last) {
            rectangle.x = Math.min(start.x, last.x);
            rectangle.y = Math.min(start.y, last.y);
            rectangle.width = Math.abs(start.x - last.x);
            rectangle.height = Math.abs(start.y - last.y);
        }
        private Rectangle2D.Double rectangle;
        // Method to serialize a rectangle
        private void writeObject(ObjectOutputStream out) throws IOException 
        {
            out.writeDouble(rectangle.width);
            out.writeDouble(rectangle.height);
        }
        // Method to deserialize a rectangle
        private void readObject(ObjectInputStream in)
        throws IOException, ClassNotFoundException {
            double width = in.readDouble();
            double height = in.readDouble();
            rectangle = new Rectangle2D.Double(0,0,width,height);
        }
    }
    // class that defines a circle
    public static class Circle extends Element 
    {
        public Circle(Point center, Point circum, Color color) 
        {
            super(color);
            // Radius is distance from center to circumference
            double radius = center.distance(circum);
            circle = new Ellipse2D.Double(center.x - radius, center.y - radius, 2.*radius, 2.*radius);
        }
        // Return the circle as a Shape reference
        public Shape getShape() {
            return circle;
        }
        // Return the rectangle bounding this circle
        public java.awt.Rectangle getBounds() {
            return circle.getBounds();
        }
        // Recreate this circle
        public void modify(Point center, Point circum) {
            double radius = center.distance(circum);
            circle.x = center.x - (int)radius;
            circle.y = center.y - (int)radius;
            circle.width = circle.height = 2*radius;
        }
        private Ellipse2D.Double circle;
        // Method to serialze a circle
        private void writeObject(ObjectOutputStream out) throws IOException 
        {
            out.writeDouble(circle.width);
        }
        // Method to deserialize a circle
        private void readObject(ObjectInputStream in)
        throws IOException, ClassNotFoundException {
            double width = in.readDouble();
            circle = new Ellipse2D.Double(0,0,width,width);
        }
    }
    //class that defines a curve
    public static class Curve extends Element {
        public Curve(Point start, Point next, Color color) {
            super(color);
            curve = new GeneralPath();
            curve.moveTo(start.x, start.y); 
            curve.lineTo(next.x, next.y); 
        }
       
        public void modify(Point start, Point next) {
            curve.lineTo(next.x, next.y); 
        }
        
        public Shape getShape() {
            return curve;
        }
        
        public java.awt.Rectangle getBounds() {
            return curve.getBounds();
        }
        private GeneralPath curve;
        // Method to serialize a curve
        private void writeObject(ObjectOutputStream out) throws IOException 
        {
            PathIterator iterator = curve.getPathIterator(new AffineTransform());
            Vector<Float> coords = new Vector<Float>();
            int maxCoordCount = 6;
            float[] temp = new float[maxCoordCount]; // Stores segment data
            int result = iterator.currentSegment(temp); // Get first segment
            assert(result == iterator.SEG_MOVETO);
            iterator.next(); // Next segment
            while(!iterator.isDone()) 
            { // While there are segments
                result = iterator.currentSegment(temp); // Get the segment data
                assert(result == iterator.SEG_LINETO);
                coords.add(temp[0]); // Add x coordinate to Vector
                coords.add(temp[1]); // Add y coordinate
                iterator.next(); // Go to next segment
            }
            out.writeObject(coords); // Save the Vector
        }
        // Method to deserialize a curve
        private void readObject(ObjectInputStream in)
        throws IOException, ClassNotFoundException {
            Vector<Float> coords = (Vector<Float>)in.readObject(); // Read vector
            curve = new GeneralPath(); // Create a path
            curve.moveTo(0,0); // Move to the origin
            for(int i = 0 ; i<coords.size() ; i += 2 ) { // For each pair of elements
                curve.lineTo(coords.get(i), coords.get(i+1)); // Create a line segment
            }
        }
    }
}














