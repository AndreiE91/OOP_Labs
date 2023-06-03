package lab12;

import java.awt.event.ActionListener;

import javax.swing.*;

public class CounterView extends JFrame{
	private JLabel l1;
	private JButton b1;
	private JButton b2;
	public CounterView()
	{

		JPanel panel = new JPanel();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300, 200);;
		
		l1 = new JLabel("");
		
		
        b1 = new JButton("Start");
        b2 = new JButton("Stop");
        
        
        panel.add(l1);
        
        panel.add(b1);
        panel.add(b2);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        this.setContentPane(panel);
		this.setVisible(true);
	}
	public void addActionListener(ActionListener al) {
		b1.addActionListener(al);
	}
	public void addActionListener2(ActionListener al) {
		b2.addActionListener(al);
	}
	public void setCounterLabel(long count)
	{
		String number = String.valueOf(count);
		l1.setText(number);
	}
}
