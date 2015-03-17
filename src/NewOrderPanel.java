import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;


public class NewOrderPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public NewOrderPanel() {
		setLayout(null);
		
		JLabel label = new JLabel("Samlet pris i DKK:");
		label.setBounds(368, 237, 112, 16);
		add(label);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(477, 237, 126, 16);
		add(textField);
		
		JButton button = new JButton("Afslut ordre");
		button.setBounds(245, 231, 113, 25);
		add(button);
		
		JButton button_1 = new JButton("Ryd");
		button_1.setBounds(20, 231, 97, 25);
		add(button_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(10, 264, 368, 16);
		add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(245, 11, 358, 217);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 128, 225, 101);
		add(panel);
		
		JButton button_2 = new JButton("Slet vare");
		button_2.setBounds(117, 68, 97, 23);
		panel.add(button_2);
		
		JButton button_3 = new JButton("Tilf\u00F8j vare");
		button_3.setBounds(10, 67, 97, 25);
		panel.add(button_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(62, 40, 152, 16);
		panel.add(textField_1);
		
		JLabel label_2 = new JLabel("Antal:");
		label_2.setBounds(10, 40, 56, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Vare ID:");
		label_3.setBounds(10, 11, 56, 16);
		panel.add(label_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(0, 0, 0, 0);
		panel.add(panel_1);
		
		textField_2 = new JTextField();
		textField_2.setText("S\u00E6lger ID");
		textField_2.setColumns(10);
		textField_2.setBounds(0, 0, 0, 0);
		panel.add(textField_2);
		
		JCheckBox checkBox = new JCheckBox("Erhvervskunde");
		checkBox.setBounds(0, 0, 0, 0);
		panel.add(checkBox);
		
		textField_3 = new JTextField();
		textField_3.setText("Telefonnummer/CVR");
		textField_3.setColumns(10);
		textField_3.setBounds(0, 0, 0, 0);
		panel.add(textField_3);
		
		JLabel label_4 = new JLabel("Kunde:");
		label_4.setBounds(0, 0, 0, 0);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("S\u00E6lger:");
		label_5.setBounds(0, 0, 0, 0);
		panel.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(62, 11, 152, 16);
		panel.add(textField_4);

	}
}
