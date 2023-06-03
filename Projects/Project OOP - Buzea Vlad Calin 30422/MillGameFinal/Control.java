import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
/**
 * 
 */
public class Control
{
    private static MillGame model;
    private static MillPanel view;
    private static JFrame frame;
    private static JLabel label,mesage;
    private FlowLayout flo = new FlowLayout();
    private static JMenuBar menuBar;
    private static JMenu menu;
    private static JMenuItem menuItem;
    public Control()
    {
        model=new MillGame();
        view=new MillPanel(model);
        frame=new JFrame("Game");
        label=new JLabel();
        mesage=new JLabel();
        menuBar = new JMenuBar();
        
        
    }
    
    
    public static class MA extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            int x,y;
            //Dimension size = frame.getBounds().getSize();
            //System.out.println(size.width+" "+size.height);
            x=e.getX();
            y=e.getY();
            model.detectAction(view.transformRow(y),view.transformColumn(x));
            label.setText(model.leftToPut());
            mesage.setText(model.setGameOver());
            view.repaint();
            frame.repaint();
        }
    }
    public static class resetListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("GAME RESET!");
            model.reset();
            label.repaint();
            mesage.repaint();
            view.repaint();
            frame.repaint();
        }
    }
    public static void main(String args[])
    {
        Control test=new Control();
        menu=new JMenu("Game");
        menu.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menu);
        //
        menuItem = new JMenuItem("Reset",
                                 KeyEvent.VK_T);
        //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menuItem.addActionListener(new resetListener());
        menu.add(menuItem);
        //
        //frame.setLayout(flo);
        //flo.setAlignment(FlowLayout.TRAILING);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(view,BorderLayout.CENTER);
        view.addML(new MA());
        label.setText(model.leftToPut());
        frame.add(label,BorderLayout.EAST);
        label.setVisible(true);
        mesage.setText(model.setGameOver());
        mesage.setForeground(Color.red);
        frame.add(mesage,BorderLayout.SOUTH);
        mesage.setVisible(true);
        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setSize(new Dimension(520,720));
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
