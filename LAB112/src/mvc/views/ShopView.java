package mvc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ShopView extends JFrame {
    private JFrame frame;
    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextField totalTextField;
    private JButton createButton = new JButton("CREATE");
    private JButton computeTotalButton = new JButton("COMPUTE TOTAL");
    private JButton showButton = new JButton("SHOW");
    private JTextArea showTextArea = new JTextArea();


    public ShopView() {
        this.getContentPane().setBackground(Color.ORANGE);
        this.getContentPane().setForeground(new Color(255, 176, 208));
        this.setBounds(100, 100, 673, 451);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("Candy Shop");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        titleLabel.setBounds(244, 43, 171, 85);
        this.getContentPane().add(titleLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        nameLabel.setBounds(47, 142, 47, 32);
        this.getContentPane().add(nameLabel);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        priceLabel.setBounds(47, 184, 47, 32);
        this.getContentPane().add(priceLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(104, 151, 126, 19);
        this.getContentPane().add(nameTextField);
        nameTextField.setColumns(10);

        priceTextField = new JTextField();
        priceTextField.setBounds(104, 193, 126, 19);
        this.getContentPane().add(priceTextField);
        priceTextField.setColumns(10);

        createButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        createButton.setBounds(116, 243, 96, 32);
        this.getContentPane().add(createButton);

        JLabel totalLabel = new JLabel("Total");
        totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        totalLabel.setBounds(47, 312, 47, 32);
        this.getContentPane().add(totalLabel);

        totalTextField = new JTextField();
        totalTextField.setColumns(10);
        totalTextField.setBounds(104, 321, 126, 19);
        this.getContentPane().add(totalTextField);

        computeTotalButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        computeTotalButton.setBounds(104, 285, 126, 32);
        this.getContentPane().add(computeTotalButton);

        showButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        showButton.setBounds(470, 112, 106, 32);
        this.getContentPane().add(showButton);

        //step 15 line wrap
        showTextArea.setLineWrap(true);
        showTextArea.setBounds(405, 154, 223, 216);
        this.getContentPane().add(showTextArea);
        this.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    // step 4
    // schimbam JTextField cu String ca return type
    public String getNameTextField() {
        // step 5
        // in loc de return nameField o sa avem nameField.getText();
        return nameTextField.getText();
    }

    // step 6
    // ca si parametru o sa primim un String in loc de JTextField
    public void setNameTextField(String nameTextField) {
        // step 7
        this.nameTextField.setText(nameTextField);
    }

    //step 8
    //o sa modificam ret type in double
    public double getPriceTextField() {
        //step 9
        //conversie din String la double
        return Double.parseDouble(priceTextField.getText());
    }

    //step 10
    //primim double ca parametru
    public void setPriceTextField(double priceTextField) {
        //step 11
        //conversie din double la String
        this.priceTextField.setText(String.valueOf(priceTextField));
    }

    public double getTotalTextField() {
        return Double.parseDouble(totalTextField.getText());
    }

    public void setTotalTextField(double totalTextField) {
        this.totalTextField.setText(String.valueOf(totalTextField));
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public void setCreateButton(JButton createButton) {
        this.createButton = createButton;
    }

    public JButton getComputeTotalButton() {
        return computeTotalButton;
    }

    public void setComputeTotalButton(JButton computeTotalButton) {
        this.computeTotalButton = computeTotalButton;
    }

    public JButton getShowButton() {
        return showButton;
    }

    public void setShowButton(JButton showButton) {
        this.showButton = showButton;
    }

    public String getShowTextArea() {
        return showTextArea.getText();
    }

    public void setShowTextArea(String showTextArea) {
        this.showTextArea.setText(showTextArea);
    }

    // step 2
    // ne facem o metoda care primeste un ActionListener si
    // il atribuie butonului din view
    public void addShowListener(ActionListener actionListener) {
        showButton.addActionListener(actionListener);
    }

    //step 16
    //facem iar o metoda ce primeste un ActionListener dar
    //pt computeTotal acum
    public void addTotalButtonListener(ActionListener actionListener) {
        computeTotalButton.addActionListener(actionListener);
    }

    public void addCreateButtonListener(ActionListener actionListener) {
        createButton.addActionListener(actionListener);
    }

    //step 24
    //metoda ce ne arunca un popup cand apare exceptie
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
        refresh();
    }

    //step 25
    //metoda pt resetat fereastra
    public void refresh() {
        nameTextField.setText(null);
        priceTextField.setText(null);
        totalTextField.setText(null);
        showTextArea.setText(null);
    }

    public void cleanCreateField() {
        nameTextField.setText(null);
        priceTextField.setText(null);
    }
}
