import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;

public class SimpleGui1B implements ActionListener {

	JButton button;
	JFrame frame;
	
	public static void main(String[] args) {
		
		SimpleGui1B gui = new SimpleGui1B();
		gui.go();
		
	}

	public void go() {
		
		frame = new JFrame();
		button = new JButton("change colors");
		
		button.addActionListener(this);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.add(BorderLayout.SOUTH, button);
		frame.add(BorderLayout.CENTER, drawPanel);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		//button.setText("i've been clicked");
		frame.repaint();
	}
	
}
