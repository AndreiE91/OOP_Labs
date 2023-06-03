package javasmmr.pipulapp.views;

import java.awt.event.ActionListener;

import javax.swing.*;

public class NewPersonView extends JFrame {
	
	JTextField name = new JTextField();
	JTextField age = new JTextField();
	
	JButton save = new JButton("save");
	JButton cancel = new JButton("cancel");
	
	public String getName() {
		return name.getText();
	}
	
	public String getAge() {
		return age.getText();
	}
	
	public NewPersonView() {
		
		this.setSize(300, 300);
		this.setLayout(null);
		
		this.add(name);
		name.setColumns(25);
		
		this.add(age);
		age.setColumns(25);
		
		this.add(save);
		
		this.add(cancel);
		
		name.setBounds(10,10,200,30);
		age.setBounds(10,50,200,30);
		save.setBounds(10, 90, 200, 30);
		cancel.setBounds(10, 130, 200, 30);
	}


	public void addCancelButtonActionListener(ActionListener e) {
		cancel.addActionListener(e);// TODO Auto-generated method stub
		
	}
	
	public void addSaveButtonActionListener(ActionListener action) {
		save.addActionListener(action);
	}
	
}
