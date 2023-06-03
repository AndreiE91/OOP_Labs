package lab11;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

public class PersonView extends JFrame {

	private JTable table = new JTable();
	JButton newButton = new JButton("New");

	public PersonView() {
		this.setSize(500, 500);
		this.setLayout(null);
		table.setBounds(10, 40, 400, 70);
		this.add(table);

		newButton.setBounds(270, 130, 100, 50);
		this.add(newButton);
	}

	public void setTableModel(MyTableModel myTableModel) {
		table.setModel(myTableModel);
	}

	public void addNew(ActionListener action) {
		newButton.addActionListener(action);
	}

}