package criptare;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class HistoryView extends JFrame{

	JButton btnClose;
	JTextField textField;
	
	
	
	public void setTextField(String textField) {
		this.textField.setText(textField);
	}

	public HistoryView() {
		
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(false);
		this.getContentPane().setLayout(null);
		
		btnClose = new JButton("CLOSE");
		btnClose.setBounds(319, 210, 89, 23);
		this.getContentPane().add(btnClose);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 414, 188);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
	}
		
	public void addCloseAction(ActionListener action) {
		this.btnClose.addActionListener(action);
	
	}
	
}
