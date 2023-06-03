import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;

public class SimpleGui1 {

	
	public static void main(String[] args) {

		SimpleGui1 gui = new SimpleGui1();
		gui.go();
		
	}
	
	public void go() {
	

		JFrame frame = new JFrame();
		JButton button = new JButton("Click this!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font bigFont = new Font("Times New Roman",Font.ITALIC,20);
		button.setFont(bigFont);
		
		
		JButton south = new JButton("south");
		JButton west = new JButton("west");
		JButton east = new JButton("east");
		JButton center = new JButton("center");
		
		// frame.getContentPane().add(button);
		frame.add(BorderLayout.NORTH,button);
		frame.add(BorderLayout.EAST,east);
		frame.add(BorderLayout.WEST,west);
		frame.add(BorderLayout.CENTER,center);
		frame.add(BorderLayout.SOUTH,south);

		
		frame.setSize(300, 300);

		frame.setVisible(true);

	}

}
