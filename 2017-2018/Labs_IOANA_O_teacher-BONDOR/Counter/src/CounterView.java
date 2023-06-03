import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CounterView extends JFrame{
	
	public JButton start = new JButton("START");;
	public JButton stop = new JButton("STOP");;
	public JLabel label;
	
	public CounterView() {
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("LABEL");
		label.setBounds(157, 11, 101, 47);
		getContentPane().add(label);
		
		JButton stop = new JButton("STOP");
		stop.setBounds(258, 60, 101, 154);
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(stop);
		
		JButton start = new JButton("START");
		start.setBounds(54, 60, 101, 154);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(start);
		
	}

	public void startActionListener(ActionListener e) {
		start.addActionListener(e);
	}
	
	public void stopActionListener(ActionListener e) {
		stop.addActionListener(e);
	}

	public void setCounterLabel(String labelText) {
		this.label.setText(labelText);
	}
	
}
