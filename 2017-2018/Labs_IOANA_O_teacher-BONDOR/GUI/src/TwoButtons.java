import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class TwoButtons {

	JFrame frame;
	JLabel label;

	public static void main(String[] args) {

		TwoButtons gui = new TwoButtons();
		gui.go();

	}

	public void go() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton labelButton = new JButton("change label");
		labelButton.addActionListener(new LabelButtonListener());
		
		JButton colorButton = new JButton("change color");
		colorButton.addActionListener(new ColorButtonListener());
		
		label = new JLabel("i am a label");
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.add(BorderLayout.CENTER,drawPanel);
		frame.add(BorderLayout.SOUTH, colorButton);
		frame.add(BorderLayout.EAST,labelButton);
		frame.add(BorderLayout.WEST, label);
		
		frame.setSize(500,  500);
		frame.setVisible(true);
		
	}

	class LabelButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			label.setText("Ouch!!");

		}

	}
	
	
	class ColorButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
		
	}

	
	
}
