package criptare;

import java.util.*;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

public class Controller {

	private HistoryView history;
	private DashBoardView dashView;

	public Controller() {

		this.history = new HistoryView();
		this.dashView = new DashBoardView();
		dashView.setVisible(true);

		Map<Integer, String> bitcoinMap = new HashMap<>();
		Map<Integer, String> rippleMap = new HashMap<>();
		Map<Integer, String> ethMap = new HashMap<>();

		this.dashView.addAmountListener(e -> {
			int aux = 1;
			String amount = this.dashView.getAmountField();

			// ASTA CA SA MA CALMEZ
			// PFFAI M-AM CALMAT PUTIN
			// System.out.println(amount);
			// System.out.println(this.dashView.getComboBox());
			try {
				if (Integer.parseInt(amount) != 0) {
					if (this.dashView.getComboBox() == this.dashView.lblBitcoin.getText()) {
						this.dashView.bitcoinLabel.setText(amount);
						bitcoinMap.put(aux, amount);

					} else if (this.dashView.getComboBox() == this.dashView.lblEthereum.getText()) {
						this.dashView.ethereumLabel.setText(amount);
						ethMap.put(aux, amount);
					} else if (this.dashView.getComboBox() == this.dashView.lblRipple.getText()) {
						this.dashView.rippleLabel.setText(amount);
						rippleMap.put(aux, amount);
					}
					aux++;
				} else {
					JOptionPane.showMessageDialog(this.dashView, "Invalid amount!");
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this.dashView, "You didn't write any numerical value!");
			}
		
			this.dashView.refresh();
			
		});

		this.dashView.addBitCoinShowAction(e -> {
	
			for (Entry<Integer, String> entryBit : bitcoinMap.entrySet()) {
				String bitString= entryBit+".0 $";
				this.history.setTextField("i can only display the last introduced value " + bitString);
			}
			
			this.dashView.setVisible(false);
			this.history.setVisible(true);
			this.history.setLocation(this.dashView.getLocation().x, this.dashView.getLocation().y);
		});

		this.dashView.addRippleShowAction(e -> {
			
			for (Entry<Integer, String> entryBit : rippleMap.entrySet()) {
				String bitString = entryBit+"$";
				this.history.setTextField("i can only display the last introduced value " + bitString);
			}
			
			this.dashView.setVisible(false);
			this.history.setVisible(true);
			this.history.setLocation(this.dashView.getLocation().x, this.dashView.getLocation().y);
		});

		this.dashView.addEthereumShowAction(e -> {
			
			for (Entry<Integer, String> entryBit : ethMap.entrySet()) {
				String bitString = entryBit+"$";
				this.history.setTextField("i can only display the last introduced value " + bitString);
			}
			
			this.dashView.setVisible(false);
			this.history.setVisible(true);
			this.history.setLocation(this.dashView.getLocation().x, this.dashView.getLocation().y);
		});

		this.history.addCloseAction(e -> {
			this.history.setVisible(false);
			this.dashView.setVisible(true);
			this.dashView.setLocation(this.history.getLocation().x, this.history.getLocation().y);
		});

	}

}
