import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;



public class MyView {
	private JFrame frame;
	private JTextField textFieldCodProdus;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyView window = new MyView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public MyView() {
		initialize();
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	void initialize() {
		frame = new JFrame();
		//frame.getContentPane().setLayout(new GridLayout(7, 2, 10, 10));

	}
}