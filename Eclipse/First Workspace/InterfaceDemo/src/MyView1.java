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

public class MyView1 {

	private JFrame frame;
	private JTextField licenceNumberTextField;
	private JTextField idTextField;
	private JTextField idUpdateTextField;
	private JTextField detailsTextField;
	private JTextField typeCodeTextField;
	private JTextField newIdUpdateTextField;
	private JTextField licNumberUpdateTextField;
	private JTextField detailsUpdateTextField;
	private JTextField typeCodeUpdateTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyView1 window = new MyView1();
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
	public MyView1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 963, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel titleLabel = new JLabel("Vehicles");
		titleLabel.setForeground(new Color(255, 0, 0));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton showButton = new JButton("Show");
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		showButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JTextArea showTextArea = new JTextArea();
		
		licenceNumberTextField = new JTextField();
		licenceNumberTextField.setColumns(10);
		
		JLabel licenceNumberLabel = new JLabel("Licence Number");
		licenceNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		idTextField = new JTextField();
		idTextField.setColumns(10);
		
		JLabel idLabelUpdate = new JLabel("ID");
		idLabelUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		idUpdateTextField = new JTextField();
		idUpdateTextField.setColumns(10);
		
		detailsTextField = new JTextField();
		detailsTextField.setColumns(10);
		
		JLabel labelDetails = new JLabel("Details");
		labelDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel labelTypeCode = new JLabel("Type Code");
		labelTypeCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		typeCodeTextField = new JTextField();
		typeCodeTextField.setColumns(10);
		
		JLabel newIdLabel = new JLabel("New ID");
		newIdLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		newIdUpdateTextField = new JTextField();
		newIdUpdateTextField.setColumns(10);
		
		JLabel labelNewLicence = new JLabel("New LicNumber");
		labelNewLicence.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel labelNewDetails = new JLabel("New Details");
		labelNewDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel labelNewTypeCode = new JLabel("New Type Code");
		labelNewTypeCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		licNumberUpdateTextField = new JTextField();
		licNumberUpdateTextField.setColumns(10);
		
		detailsUpdateTextField = new JTextField();
		detailsUpdateTextField.setColumns(10);
		
		typeCodeUpdateTextField = new JTextField();
		typeCodeUpdateTextField.setColumns(10);
		
		JTextArea typesTextArea = new JTextArea();
		
		JButton showTypesButton = new JButton("Show Types");
		showTypesButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton createButton = new JButton("Create");
		createButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton updateButton = new JButton("Update");
		updateButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
							.addGap(215)
							.addComponent(showButton, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
							.addGap(96))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(15)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addGroup(groupLayout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(licenceNumberLabel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(licenceNumberTextField, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
															.addComponent(idLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
															.addComponent(idLabelUpdate, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
														.addComponent(newIdLabel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
														.addComponent(labelNewLicence, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
														.addComponent(labelNewDetails, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
														.addComponent(labelNewTypeCode, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(newIdUpdateTextField, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
														.addComponent(idUpdateTextField, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
														.addComponent(licNumberUpdateTextField, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
														.addComponent(detailsUpdateTextField, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
														.addComponent(typeCodeUpdateTextField, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
														.addComponent(idTextField, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(labelDetails, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(detailsTextField, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(labelTypeCode, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
														.addGap(11)
														.addComponent(typeCodeTextField, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))))
										.addGap(10))
									.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
											.addComponent(createButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
										.addGap(98)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(86)
									.addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(showTextArea, GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(typesTextArea, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(showTypesButton, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(50)
									.addComponent(showButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(licenceNumberLabel)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(labelDetails, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
										.addComponent(detailsTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(14)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(labelTypeCode, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
										.addComponent(typeCodeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(39)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(idLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
										.addComponent(idTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(72)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(idLabelUpdate, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
										.addComponent(idUpdateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(39)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(labelNewLicence, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
										.addComponent(licNumberUpdateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(labelNewDetails, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
										.addComponent(detailsUpdateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(labelNewTypeCode, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
										.addComponent(typeCodeUpdateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(19)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(showTextArea, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(typesTextArea, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(showTypesButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
													.addGap(52))))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(licenceNumberTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(75)
											.addComponent(createButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
											.addGap(31)
											.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
											.addGap(180)
											.addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(354)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(newIdUpdateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(newIdLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
