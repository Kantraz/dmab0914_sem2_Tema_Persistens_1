import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;


public class PanelItems extends JPanel {
	private JTextField textField;
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
	public PanelItems() {
		setLayout(null);
		
		JLabel label = new JLabel("Type:");
		label.setBounds(10, 11, 81, 16);
		add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(101, 11, 226, 16);
		add(textField);
		
		JLabel label_1 = new JLabel("Pris pr stk:");
		label_1.setBounds(10, 40, 81, 16);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 40, 226, 16);
		add(textField_1);
		
		JLabel label_2 = new JLabel("M\u00E6ngde:");
		label_2.setBounds(10, 69, 81, 16);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(101, 69, 226, 16);
		add(textField_2);
		
		JButton button = new JButton("Opret");
		button.setBounds(10, 142, 97, 25);
		add(button);
		
		JButton button_1 = new JButton("Opdater");
		button_1.setEnabled(false);
		button_1.setBounds(119, 142, 97, 25);
		add(button_1);
		
		JButton button_2 = new JButton("Slet");
		button_2.setBounds(228, 142, 97, 25);
		add(button_2);
		
		JButton button_3 = new JButton("Ryd");
		button_3.setBounds(337, 142, 97, 25);
		add(button_3);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(10, 182, 526, 16);
		add(label_3);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 96, 424, 31);
		add(panel);
		
		JLabel label_4 = new JLabel("ID:");
		label_4.setBounds(10, 8, 56, 16);
		panel.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(92, 8, 226, 16);
		panel.add(textField_3);
		
		JButton button_4 = new JButton("S\u00F8g");
		button_4.setBounds(328, 5, 82, 22);
		panel.add(button_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 209, 424, 123);
		add(scrollPane);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(535, 11, 135, 16);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(535, 40, 135, 16);
		add(textField_5);
		
		JLabel lblIndkbspris = new JLabel("Indk\u00F8bspris:");
		lblIndkbspris.setBounds(444, 40, 81, 16);
		add(lblIndkbspris);
		
		JLabel lblPrisForLeje = new JLabel("Pris for leje:");
		lblPrisForLeje.setBounds(444, 11, 81, 16);
		add(lblPrisForLeje);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(535, 98, 135, 16);
		add(textField_6);
		
		JLabel lblMin = new JLabel("Min lager:");
		lblMin.setBounds(444, 98, 81, 16);
		add(lblMin);
		
		JLabel lblLand = new JLabel("Land:");
		lblLand.setBounds(444, 69, 81, 16);
		add(lblLand);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(535, 69, 135, 16);
		add(textField_7);

	}

}
