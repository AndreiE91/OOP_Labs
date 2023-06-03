package javasmmr.pipulapp.views;

import java.awt.event.ActionListener;

import javax.swing.*;

import javasmmr.pipulapp.models.MyTableModel;

public class PersonView extends JFrame {

	private JTable table = new JTable();
	private JButton newPerson = new JButton("new");
	
	public PersonView() {
		this.setSize(500, 500);
		this.setLayout(null);
		table.setBounds(10, 40, 400, 100);
		newPerson.setBounds(10,10, 100, 20);
		this.add(table);
		this.add(newPerson);
		
	}

	public void setTableModel(MyTableModel myTableModel) {
		table.setModel(myTableModel);
	}


	public void NewActionListener(ActionListener e) {
		newPerson.addActionListener(e);
	}
	
}
