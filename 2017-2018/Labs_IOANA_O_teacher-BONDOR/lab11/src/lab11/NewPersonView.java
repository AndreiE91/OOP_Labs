package lab11;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

public class NewPersonView extends JFrame {

	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JButton saveButton = new JButton("Save");
	JButton cancelButton = new JButton("Cancel");

	public String getName() {
		return tf1.getText();
	}

	public String getAge() {
		return tf2.getText();
	}

	public NewPersonView() {
		this.setSize(500, 500);
		this.setLayout(null);

		JLabel name = new JLabel(" name ");

		JLabel age = new JLabel("age");

		this.add(name);
		this.add(tf1);
		this.add(age);
		this.add(tf2);
		this.add(saveButton);
		this.add(cancelButton);

		name.setBounds(170, 50, 100, 30);
		tf1.setBounds(170, 80, 100, 30);

		age.setBounds(170, 140, 100, 30);
		tf2.setBounds(170, 170, 100, 30);

		saveButton.setBounds(50, 220, 100, 50);

		cancelButton.setBounds(250, 220, 100, 50);

	}

	public void cancel(ActionListener action2) {
		cancelButton.addActionListener(action2);
	}

	public void save(ActionListener action3) {
		saveButton.addActionListener(action3);
	}
}
