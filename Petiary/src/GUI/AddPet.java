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
	private JTextField nameField;
	private JTextField breedField;
	private JTextField bdateField;
	private JTextField weightField;
	private JTextField illnessField;
	private JTextField petIdField;
	
	

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
		
		nameField = new JTextField();
		nameField.setBounds(125, 21, 129, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		breedField = new JTextField();
		breedField.setBounds(125, 46, 129, 20);
		breedField.setColumns(10);
		contentPane.add(breedField);
		
		bdateField = new JTextField();
		bdateField.setBounds(125, 71, 129, 20);
		bdateField.setColumns(10);
		contentPane.add(bdateField);
		
		weightField = new JTextField();
		weightField.setBounds(125, 96, 129, 20);
		weightField.setColumns(10);
		contentPane.add(weightField);
		
		illnessField = new JTextField();
		illnessField.setBounds(125, 121, 129, 20);
		illnessField.setColumns(10);
		contentPane.add(illnessField);
		
		JComboBox cbVetList = new JComboBox();
		cbVetList.setBounds(125, 147, 129, 22);
		contentPane.add(cbVetList);
		
		JLabel lblNewLabel_6 = new JLabel("Id to search:");
		lblNewLabel_6.setBounds(86, 224, 78, 20);
		contentPane.add(lblNewLabel_6);
		
		JButton btnAddPet = new JButton("Add");
		btnAddPet.setBounds(99, 180, 89, 23);
		contentPane.add(btnAddPet);
		
		petIdField = new JTextField();
		petIdField.setBounds(171, 224, 36, 20);
		contentPane.add(petIdField);
		petIdField.setColumns(10);
		
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
