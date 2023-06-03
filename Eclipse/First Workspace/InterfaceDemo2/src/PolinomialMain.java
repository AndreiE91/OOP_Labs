import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PolinomialMain {
	JFrame frame;
	
	public static void main(String[] args) {
		PolinomialMain window = new PolinomialMain();
	}
	
	public PolinomialMain(){ 
		initialize();
	}
	
	void initialize() {
		frame = new JFrame();
		
		JLabel labelTitle = new JLabel("Warehouse Management Application");
		labelTitle.setBounds(35, 10, 747, 133);
		labelTitle.setFont(new Font("Vivaldi", Font.BOLD, 50));
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(labelTitle);
		
		JButton buttonClients = new JButton("Clients");
		buttonClients.setBackground(new Color(240, 240, 240));
		buttonClients.setFont(new Font("Tahoma", Font.BOLD, 25));
		buttonClients.setBounds(41, 327, 180, 77);
		frame.getContentPane().add(buttonClients);
		
		JButton buttonProducts = new JButton("Products");
		buttonProducts.setFont(new Font("Tahoma", Font.BOLD, 25));
		buttonProducts.setBounds(231, 327, 180, 77);
		frame.getContentPane().add(buttonProducts);
		
		JButton buttonOrders = new JButton("Orders");
		buttonOrders.setFont(new Font("Tahoma", Font.BOLD, 25));
		buttonOrders.setBounds(432, 327, 180, 77);
		frame.getContentPane().add(buttonOrders);
		
		JButton buttonBills = new JButton("Bills");
		buttonBills.setFont(new Font("Tahoma", Font.BOLD, 25));
		buttonBills.setBounds(622, 327, 180, 77);
		frame.getContentPane().add(buttonBills);
		
	}
 }
