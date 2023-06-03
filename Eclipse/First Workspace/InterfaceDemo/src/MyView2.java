import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;

public class MyView2 {

	private JFrame frame;
	private JTextField computeBeverageTotalTextField;
	private JTextField showRatingTextField;
	private JTextField addBeverageTextField;
	private JTextField nameTextField;
	private JTextField quantityTextField;
	private JTextField pricePerUnitTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyView2 window = new MyView2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyView2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 722, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel titleLabel = new JLabel("MANAGE BEVERAGES");
		titleLabel.setBounds(190, 29, 300, 62);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(titleLabel);
		
		JButton addBeverageButton = new JButton("ADD BEVERAGE");
		addBeverageButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		addBeverageButton.setBounds(447, 101, 120, 40);
		frame.getContentPane().add(addBeverageButton);
		
		JButton showRatingButton = new JButton("SHOW RATING");
		showRatingButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		showRatingButton.setBounds(388, 174, 120, 40);
		frame.getContentPane().add(showRatingButton);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		nameLabel.setBounds(42, 85, 92, 26);
		frame.getContentPane().add(nameLabel);
		
		JComboBox categoryComboBox = new JComboBox();
		categoryComboBox.setBounds(144, 353, 112, 21);
		frame.getContentPane().add(categoryComboBox);
		
		JLabel quantityLabel = new JLabel("Quantity");
		quantityLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		quantityLabel.setBounds(42, 133, 92, 26);
		frame.getContentPane().add(quantityLabel);
		
		JLabel pricePerUnitLabel = new JLabel("Price/ 1 Unit");
		pricePerUnitLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		pricePerUnitLabel.setBounds(42, 188, 92, 26);
		frame.getContentPane().add(pricePerUnitLabel);
		
		JLabel ingredientsLabel = new JLabel("Ingredients");
		ingredientsLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		ingredientsLabel.setBounds(42, 245, 92, 26);
		frame.getContentPane().add(ingredientsLabel);
		
		JLabel categoryLabel = new JLabel("Category");
		categoryLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		categoryLabel.setBounds(42, 348, 92, 26);
		frame.getContentPane().add(categoryLabel);
		
		JButton computeBeverageTotalButton = new JButton("COMPUTE BEVERAGE TOTAL");
		computeBeverageTotalButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		computeBeverageTotalButton.setBounds(348, 261, 177, 40);
		frame.getContentPane().add(computeBeverageTotalButton);
		
		computeBeverageTotalTextField = new JTextField();
		computeBeverageTotalTextField.setText("");
		computeBeverageTotalTextField.setBounds(549, 261, 96, 37);
		frame.getContentPane().add(computeBeverageTotalTextField);
		computeBeverageTotalTextField.setColumns(10);
		
		showRatingTextField = new JTextField();
		showRatingTextField.setText("");
		showRatingTextField.setColumns(10);
		showRatingTextField.setBounds(538, 176, 96, 37);
		frame.getContentPane().add(showRatingTextField);
		
		addBeverageTextField = new JTextField();
		addBeverageTextField.setText("");
		addBeverageTextField.setColumns(10);
		addBeverageTextField.setBounds(577, 101, 96, 37);
		frame.getContentPane().add(addBeverageTextField);
		
		nameTextField = new JTextField();
		nameTextField.setText("");
		nameTextField.setColumns(10);
		nameTextField.setBounds(115, 91, 120, 21);
		frame.getContentPane().add(nameTextField);
		
		quantityTextField = new JTextField();
		quantityTextField.setText("");
		quantityTextField.setColumns(10);
		quantityTextField.setBounds(115, 139, 120, 21);
		frame.getContentPane().add(quantityTextField);
		
		pricePerUnitTextField = new JTextField();
		pricePerUnitTextField.setText("");
		pricePerUnitTextField.setColumns(10);
		pricePerUnitTextField.setBounds(149, 193, 145, 21);
		frame.getContentPane().add(pricePerUnitTextField);
		
		JTextArea ingredientsTextArea = new JTextArea();
		ingredientsTextArea.setBounds(144, 239, 150, 91);
		frame.getContentPane().add(ingredientsTextArea);
	}
}
