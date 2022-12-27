package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AddPet extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the frame.
	 */
	public AddPet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(22, 24, 93, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Breed:");
		lblNewLabel_1.setBounds(22, 49, 93, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Birthdate:");
		lblNewLabel_2.setBounds(22, 74, 93, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Weight:");
		lblNewLabel_3.setBounds(22, 99, 93, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Illnesses:");
		lblNewLabel_4.setBounds(22, 124, 93, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Veterinary:");
		lblNewLabel_5.setBounds(22, 147, 93, 14);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(125, 21, 129, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 46, 129, 20);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 71, 129, 20);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(125, 96, 129, 20);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(125, 121, 129, 20);
		textField_4.setColumns(10);
		contentPane.add(textField_4);
		
		JComboBox cbVetList = new JComboBox();
		cbVetList.setBounds(125, 147, 129, 22);
		contentPane.add(cbVetList);
		
		JLabel lblNewLabel_6 = new JLabel("Id to search:");
		lblNewLabel_6.setBounds(86, 224, 78, 20);
		contentPane.add(lblNewLabel_6);
		
		JButton btnAddPet = new JButton("Add");
		btnAddPet.setBounds(99, 180, 89, 23);
		contentPane.add(btnAddPet);
		
		textField_5 = new JTextField();
		textField_5.setBounds(171, 224, 36, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnSearchPet = new JButton("Search");
		btnSearchPet.setBounds(96, 255, 108, 23);
		contentPane.add(btnSearchPet);
		
		JButton btnDeletePet = new JButton("Delete Pet");
		btnDeletePet.setBounds(96, 289, 108, 23);
		contentPane.add(btnDeletePet);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(294, 24, 220, 277);
		contentPane.add(scrollPane);
		
		JTextArea txtADisplay = new JTextArea();
		scrollPane.setViewportView(txtADisplay);
	}
}
