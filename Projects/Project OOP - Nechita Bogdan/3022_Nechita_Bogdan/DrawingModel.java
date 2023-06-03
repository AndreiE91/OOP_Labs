
/**
 * This class contains the text and graphics used to build a drawing.
 * 
 * @author Bogdan Nechita
 * @version 05.02.2009
 */
import java.util.Observable;
import java.util.LinkedList;
import java.util.Iterator;
import java.io.Serializable;

class DrawingModel extends Observable implements Iterable<Element>, Serializable
{
   public LinkedList<Element> elements = new LinkedList<Element>();
    
    public boolean remove(Element element)
    {
        boolean removed = elements.remove(element);
        if(removed)
        {
            setChanged();
            notifyObservers(element.getBounds());
        }
        return removed;        
    }
   public void add(Element element) 
   {
       elements.add(element);
       setChanged();
       notifyObservers(element.getBounds());
    }
    public Iterator<Element> iterator() 
    {
        return elements.iterator();
    }
    
}

