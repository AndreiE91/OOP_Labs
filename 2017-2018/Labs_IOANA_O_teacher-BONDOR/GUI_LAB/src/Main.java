import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);

		JPanel panel = new JPanel();
		frame.add(panel);

		JLabel username = new JLabel("username");
		panel.add(username);

		JTextField usernameText = new JTextField();
		usernameText.setColumns(25);
		panel.add(usernameText);

		JLabel password = new JLabel("password");
		panel.add(password);

		JPasswordField passwordField = new JPasswordField(10);
		panel.add(passwordField);
		passwordField.setColumns(25);

		JButton register = new JButton("register");
		panel.add(register);

		JButton logIn = new JButton("log in");
		panel.add(logIn);

		Color color = new Color(120, 125, 210);
		panel.setBackground(color);

		// actions on buttons
		logIn.addActionListener(e -> {
			
			/*
			 * TODO
			 * SA FACI SA DEVINA ERROR LABEL VIZIBIL DACA NU E LOGAT CLIENTUUL
			 */
			
		});
		
		Map<String,String> users = new HashMap();
		
		register.addActionListener(e -> {
			//String pass = String.valueOf(passwordField.getPassword());
			//users.put(usernameText.getText(),pass);
			System.out.println("you have been reigstered");
		});
		
		JLabel errorLabel = new JLabel("error");
		Font font = new Font("Arial", Font.BOLD,20);
		errorLabel.setFont(font);
		errorLabel.setForeground(Color.RED);
		errorLabel.setVisible(false);
		panel.add(errorLabel);
		
		
		
		frame.setVisible(true);
	}

}