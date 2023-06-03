import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Panel1 implements ActionListener, ItemListener, ListSelectionListener {

	JList list;
	JTextArea text; 
	JCheckBox check;
	JFrame frame;
	
	public static void main(String[] args) {

		Panel1 gui = new Panel1();
		gui.go();
		
	}
	
	public void go() {
	

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.blue);

	/*  panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		frame.add(BorderLayout.EAST,panel);
		
		JButton button = new JButton("shock me");
		panel.add(button);
		
		JButton button2 = new JButton("bliss");
		panel.add(button2);
		
		JButton button3 = new JButton("huh?");
		panel.add(button3);
	*/
		//frame.setContentPane(panel);
		
		
		/*JTextField field = new JTextField("wuuut");
		//field.setText("whatever");
		frame.add(field);
		field.requestFocus();
		field.selectAll();
		
		JButton button = new JButton("shock me");
		frame.add(BorderLayout.WEST,button);
		
		
		System.out.println(field.getText());
		*/
		
		/*JButton button = new JButton("just click this, dude");
		button.addActionListener(this);
		
		text = new JTextArea(10,20);
		JScrollPane scroller = new JScrollPane(text);
		text.setLineWrap(true);
		
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scroller);

		
		frame.add(BorderLayout.SOUTH, button);
		frame.add(BorderLayout.CENTER,panel);
		
		check = new JCheckBox("Goes to 11");
		frame.add(BorderLayout.NORTH,check);
		check.addItemListener(this);
		*/
		
		String[] listEntries = { "abc", "poate", "va", "ploua", "ce", "sa", "mai",
				"faceee", "va", "ploua", "ce", "sa", "mai", "faceee","va",
				"ploua", "ce", "sa", "mai", "faceee"};
		list = new JList(listEntries);
		
		JScrollPane scroller = new JScrollPane(list);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		frame.add(BorderLayout.CENTER,panel);
		panel.add(scroller);
		list.setVisibleRowCount(4);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
		
		//check.setSelected(false);
		frame.setSize(300, 300);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		text.append("button clicked\n");
		Font font = new Font("Calibri",Font.BOLD,28);
		text.setFont(font);
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		String onOrOff = "off";
		if(check.isSelected()) {
			onOrOff = "on";
			System.out.println("Check box is "   + onOrOff);
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		
		if ( event.getValueIsAdjusting()) {
			String selection = (String) list.getSelectedValue();
			System.out.println(selection);
		}
		
	}

}

