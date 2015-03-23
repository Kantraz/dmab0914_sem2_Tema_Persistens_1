package GUI;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;


public class CustomerPanel extends JPanel {
	private JTextField txtName;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public CustomerPanel() {
		setLayout(null);
		
		JLabel label = new JLabel("Navn:");
		label.setBounds(10, 11, 56, 16);
		add(label);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(133, 11, 226, 16);
		add(txtName);
		
		JLabel label_1 = new JLabel("Adresse:");
		label_1.setBounds(10, 40, 56, 16);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(133, 40, 225, 16);
		add(textField_1);
		
		JLabel label_2 = new JLabel("By:");
		label_2.setBounds(10, 98, 56, 16);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(133, 98, 225, 16);
		add(textField_2);
		
		JLabel label_3 = new JLabel("Email:");
		label_3.setBounds(10, 127, 56, 16);
		add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(133, 127, 225, 16);
		add(textField_3);
		
		JLabel label_4 = new JLabel("Telefon:");
		label_4.setBounds(10, 156, 56, 16);
		add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(133, 156, 225, 16);
		add(textField_4);
		
		JCheckBox checkBox = new JCheckBox("Erhvervskunde");
		checkBox.setEnabled(false);
		checkBox.setBounds(10, 217, 113, 25);
		add(checkBox);
		
		JLabel label_5 = new JLabel("CVR/EAN:");
		label_5.setBounds(10, 251, 65, 16);
		add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(133, 251, 225, 16);
		add(textField_5);
		
		JButton button = new JButton("Opret");
		button.setBounds(10, 298, 97, 25);
		add(button);
		
		JButton button_1 = new JButton("Opdater");
		button_1.setEnabled(false);
		button_1.setBounds(119, 298, 97, 25);
		add(button_1);
		
		JButton button_2 = new JButton("Slet");
		button_2.setBounds(335, 298, 97, 25);
		add(button_2);
		
		JButton button_3 = new JButton("Ryd");
		button_3.setBounds(442, 298, 97, 25);
		add(button_3);
		
		JButton button_4 = new JButton("S\u00F8g");
		button_4.setBounds(228, 298, 97, 25);
		add(button_4);
		
		JLabel label_6 = new JLabel("Oprettelsesdato:");
		label_6.setBounds(10, 188, 113, 16);
		add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(133, 188, 225, 16);
		add(textField_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(10, 307, 526, 16);
		add(label_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFocusable(false);
		scrollPane.setBounds(369, 11, 301, 164);
		add(scrollPane);
		
		JCheckBox checkBox_1 = new JCheckBox("Forening");
		checkBox_1.setEnabled(false);
		checkBox_1.setBounds(133, 218, 113, 25);
		add(checkBox_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(134, 71, 225, 16);
		add(textField_7);
		
		JLabel label_8 = new JLabel("Postnummer:");
		label_8.setBounds(11, 71, 56, 16);
		add(label_8);

	}
}
