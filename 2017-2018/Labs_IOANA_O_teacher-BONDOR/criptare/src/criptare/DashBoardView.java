package criptare;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DashBoardView extends JFrame{

	JTextField amountField;
	
	JComboBox comboBox;
	
	JButton btnAddPrice;
	
	JButton ethereumShow;
	JButton bitcoinShow;
	JButton rippleShow;
	
	JLabel ethereumLabel;
	JLabel rippleLabel;
	JLabel bitcoinLabel;
	
	JLabel lblBitcoin;
	JLabel lblRipple; 
	JLabel lblEthereum;
	
	
	public String getAmountField() {
		return amountField.getText();
	}


	public void setAmountField(String amountField) {
		this.amountField.setText(amountField);
	}


	public String getComboBox() {
		return comboBox.getSelectedItem().toString();
	}


	public void setEthereumLabel(String stringEtheraum) {
		this.ethereumLabel.setText(stringEtheraum);;
	}


	public void setRippleLabel(String stringRipple) {
		this.rippleLabel.setText(stringRipple);
	}


	public void setBitcoinLabel(String stringBitcoin) {
		this.bitcoinLabel.setText(stringBitcoin);
	}
	
	public DashBoardView() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 29, 110, 20);
		this.getContentPane().add(comboBox);
		comboBox.addItem(CoinType.BITCOIN);
		comboBox.addItem(CoinType.ETHEREUM);
		comboBox.addItem(CoinType.RIPPLE);
		
		amountField = new JTextField();
		amountField.setBounds(147, 29, 86, 20);
		this.getContentPane().add(amountField);
		amountField.setColumns(10);
		
		JLabel label = new JLabel("$");
		label.setBounds(240, 32, 46, 14);
		this.getContentPane().add(label);
		
		btnAddPrice = new JButton("Add price");
		btnAddPrice.setBounds(277, 28, 89, 23);
		this.getContentPane().add(btnAddPrice);
		
		JLabel lblCoinName = new JLabel("Coin name");
		lblCoinName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCoinName.setBounds(44, 97, 76, 14);
		this.getContentPane().add(lblCoinName);
		
		 lblBitcoin = new JLabel("BITCOIN");
		lblBitcoin.setBounds(44, 135, 46, 14);
		this.getContentPane().add(lblBitcoin);
		
		 lblRipple = new JLabel("RIPPLE");
		lblRipple.setBounds(44, 170, 46, 14);
		this.getContentPane().add(lblRipple);
		
		 lblEthereum = new JLabel("ETHEREUM");
		lblEthereum.setBounds(44, 207, 70, 14);
		this.getContentPane().add(lblEthereum);
		
		JLabel label_1 = new JLabel("-");
		label_1.setBounds(121, 135, 46, 14);
		this.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("-");
		label_2.setBounds(121, 170, 46, 14);
		this.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("-");
		label_3.setBounds(121, 207, 46, 14);
		this.getContentPane().add(label_3);
		
		JLabel lblCurrentPrice = new JLabel("Current price($)");
		lblCurrentPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCurrentPrice.setBounds(147, 97, 105, 14);
		this.getContentPane().add(lblCurrentPrice);
		
		 bitcoinLabel = new JLabel(" ");
		bitcoinLabel.setBounds(163, 135, 46, 14);
		this.getContentPane().add(bitcoinLabel);
		
		JLabel lblHistory = new JLabel("History");
		lblHistory.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHistory.setBounds(342, 97, 46, 14);
		this.getContentPane().add(lblHistory);
		
		bitcoinShow = new JButton("Show");
		bitcoinShow.setBounds(315, 131, 89, 23);
		this.getContentPane().add(bitcoinShow);
		
		rippleShow = new JButton("Show");
		rippleShow.setBounds(315, 166, 89, 23);
		this.getContentPane().add(rippleShow);
		
		ethereumShow = new JButton("Show");
		ethereumShow.setBounds(315, 203, 89, 23);
		this.getContentPane().add(ethereumShow);
		
		rippleLabel = new JLabel("");
		rippleLabel.setBounds(163, 170, 46, 14);
		this.getContentPane().add(rippleLabel);
		
		ethereumLabel = new JLabel("");
		ethereumLabel.setBounds(163, 207, 46, 14);
		this.getContentPane().add(ethereumLabel);
	}
	
	public void addAmountListener(ActionListener action) {
		this.btnAddPrice.addActionListener(action);
	}
	
	public void addBitCoinShowAction(ActionListener action) {
		this.bitcoinShow.addActionListener(action);
	}
	
	public void addRippleShowAction(ActionListener action) {
		this.rippleShow.addActionListener(action);
	}
	
	public void addEthereumShowAction(ActionListener action) {
		this.ethereumShow.addActionListener(action);
	}
	
	public void refresh() {
		this.setAmountField(null);
	}
	
	
}
