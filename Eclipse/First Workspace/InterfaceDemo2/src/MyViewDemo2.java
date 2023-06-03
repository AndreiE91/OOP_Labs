import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class MyViewDemo2 {
	JFrame frame;
	private JTextField textFieldCodProdus;
	private JTextField textFieldDenumireProdus;
	private JTextField texiFieldPretProdus;
	
	public static void main(String[] args) {
		MyViewDemo2 window = new MyViewDemo2();
	}
	
	public MyViewDemo2(){ 
		initialize();
	}
	
	void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JLabel labelCodProdus = new JLabel("Cod Produs");
		labelCodProdus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelCodProdus.setBounds(48, 97, 81, 22);
		frame.getContentPane().add(labelCodProdus);
		
		textFieldCodProdus = new JTextField();
		textFieldCodProdus.setBounds(48, 129, 96, 19);
		frame.getContentPane().add(textFieldCodProdus);
		textFieldCodProdus.setColumns(10);
		
		textFieldDenumireProdus = new JTextField();
		textFieldDenumireProdus.setColumns(10);
		textFieldDenumireProdus.setBounds(221, 129, 96, 19);
		frame.getContentPane().add(textFieldDenumireProdus);
		
		JLabel labelDenumireProdus = new JLabel("Denumire produs");
		labelDenumireProdus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDenumireProdus.setBounds(221, 97, 114, 22);
		frame.getContentPane().add(labelDenumireProdus);
		
		texiFieldPretProdus = new JTextField();
		texiFieldPretProdus.setColumns(10);
		texiFieldPretProdus.setBounds(429, 129, 96, 19);
		frame.getContentPane().add(texiFieldPretProdus);
		
		JLabel labelPretProdus = new JLabel("Pret produs");
		labelPretProdus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelPretProdus.setBounds(429, 97, 81, 22);
		frame.getContentPane().add(labelPretProdus);
		
		JLabel labelTitle = new JLabel("Cumparaturi");
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelTitle.setBounds(380, 35, 101, 32);
		frame.getContentPane().add(labelTitle);
		
		JLabel labelCosCumparaturi = new JLabel("Cos de cumparaturi");
		labelCosCumparaturi.setHorizontalAlignment(SwingConstants.CENTER);
		labelCosCumparaturi.setFont(new Font("Tahoma", Font.ITALIC, 12));
		labelCosCumparaturi.setBounds(368, 181, 127, 32);
		frame.getContentPane().add(labelCosCumparaturi);
		
		JLabel labelGlutenFree = new JLabel("GlutenFree?");
		labelGlutenFree.setBounds(694, 72, 63, 13);
		frame.getContentPane().add(labelGlutenFree);
		
		JCheckBox checkBoxGlutenFree = new JCheckBox("Fara gluten");
		checkBoxGlutenFree.setBounds(683, 99, 93, 21);
		frame.getContentPane().add(checkBoxGlutenFree);
		
		JTextArea textAreaCosCumparaturi = new JTextArea();
		textAreaCosCumparaturi.setBounds(49, 223, 758, 147);
		frame.getContentPane().add(textAreaCosCumparaturi);
		
		JButton buttonAdaugaProdus = new JButton("Adauga produs in cos");
		buttonAdaugaProdus.setBounds(118, 158, 141, 37);
		frame.getContentPane().add(buttonAdaugaProdus);
		
		JButton buttonStergeProdus = new JButton("Sterge produs din cos");
		buttonStergeProdus.setBounds(510, 158, 141, 37);
		frame.getContentPane().add(buttonStergeProdus);
		
		JButton buttonPuneProdusBanda = new JButton("Pune produsul pe banda");
		buttonPuneProdusBanda.setBounds(132, 390, 164, 37);
		frame.getContentPane().add(buttonPuneProdusBanda);
		
		JLabel labelBandaProduse = new JLabel("Banda produse");
		labelBandaProduse.setBounds(24, 396, 81, 25);
		frame.getContentPane().add(labelBandaProduse);
		
		JButton buttonTotalCos = new JButton("Total cos");
		buttonTotalCos.setBounds(643, 398, 108, 37);
		frame.getContentPane().add(buttonTotalCos);
		
		JTextArea textAreaBanda = new JTextArea();
		textAreaBanda.setBounds(48, 437, 560, 65);
		frame.getContentPane().add(textAreaBanda);
		
		JButton buttonTotalBanda = new JButton("Total banda");
		buttonTotalBanda.setBounds(643, 448, 96, 22);
		frame.getContentPane().add(buttonTotalBanda);
		
		JCheckBox checkBoxDiscount = new JCheckBox("20% discount");
		checkBoxDiscount.setBounds(643, 476, 93, 21);
		frame.getContentPane().add(checkBoxDiscount);
	}
 }
