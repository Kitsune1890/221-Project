package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hasA.Vet;
import mainAndSys.PetiarySys;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashSet;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class AddPet extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField breedField;
	private JTextField bdateField;
	private JTextField weightField;
	private JTextField illnessField;
	private JTextField petIdField;
	private final ButtonGroup catOrDog = new ButtonGroup();
	private JComboBox cbVetList;
	
	private static int petid=123;
	private JTextField dogsizeField;

	public JComboBox getCbVetList() {
		return cbVetList;
	}




	/**
	 * Create the frame.
	 */
	public AddPet(MainFrame fr) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(22, 63, 93, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Breed:");
		lblNewLabel_1.setBounds(22, 88, 93, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Birthdate:");
		lblNewLabel_2.setBounds(22, 113, 93, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Weight:");
		lblNewLabel_3.setBounds(22, 138, 93, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Illnesses:");
		lblNewLabel_4.setBounds(22, 163, 93, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Veterinary:");
		lblNewLabel_5.setBounds(22, 186, 93, 14);
		contentPane.add(lblNewLabel_5);
		
		nameField = new JTextField();
		nameField.setBounds(125, 60, 129, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		breedField = new JTextField();
		breedField.setBounds(125, 85, 129, 20);
		breedField.setColumns(10);
		contentPane.add(breedField);
		
		bdateField = new JTextField();
		bdateField.setBounds(125, 110, 129, 20);
		bdateField.setColumns(10);
		contentPane.add(bdateField);
		
		weightField = new JTextField();
		weightField.setBounds(125, 135, 129, 20);
		weightField.setColumns(10);
		contentPane.add(weightField);
		
		illnessField = new JTextField();
		illnessField.setBounds(125, 160, 129, 20);
		illnessField.setColumns(10);
		contentPane.add(illnessField);
		
		cbVetList = new JComboBox();
		cbVetList.setBounds(125, 186, 129, 22);
		contentPane.add(cbVetList);
		
		JLabel lblNewLabel_6 = new JLabel("Id to search:");
		lblNewLabel_6.setBounds(73, 300, 78, 20);
		contentPane.add(lblNewLabel_6);
		
		JButton btnAddPet = new JButton("Add");
		
		btnAddPet.setBounds(105, 257, 89, 23);
		contentPane.add(btnAddPet);
		
		petIdField = new JTextField();
		petIdField.setBounds(158, 300, 36, 20);
		contentPane.add(petIdField);
		petIdField.setColumns(10);
		
		JButton btnSearchPet = new JButton("Search");
		
		btnSearchPet.setBounds(22, 330, 108, 23);
		contentPane.add(btnSearchPet);
		
		JButton btnDeletePet = new JButton("Delete Pet");
		
		btnDeletePet.setBounds(133, 330, 108, 23);
		contentPane.add(btnDeletePet);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(294, 24, 220, 277);
		contentPane.add(scrollPane);
		
		JTextArea txtADisplay = new JTextArea();
		scrollPane.setViewportView(txtADisplay);
		
		JButton btnClose = new JButton("Close");
		
		btnClose.setBounds(90, 363, 85, 21);
		contentPane.add(btnClose);
		
		JRadioButton dog = new JRadioButton("dog");
		
		catOrDog.add(dog);
		dog.setBounds(125, 24, 62, 21);
		contentPane.add(dog);
		
		JRadioButton cat = new JRadioButton("cat");
		
		catOrDog.add(cat);
		cat.setBounds(190, 24, 79, 21);
		contentPane.add(cat);
		
		JLabel lblNewLabel_7 = new JLabel("Select Your Pet:  ");
		lblNewLabel_7.setBounds(23, 28, 92, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel dogsizelabel = new JLabel("Dog size:  ");
		dogsizelabel.setBounds(22, 221, 70, 13);
		contentPane.add(dogsizelabel);
		
		
		dogsizeField = new JTextField();
		dogsizeField.setBounds(125, 218, 96, 19);
		contentPane.add(dogsizeField);
		dogsizeField.setColumns(10);
		
		dogsizelabel.setVisible(false);
		dogsizeField.setVisible(false);
		
		dog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dogsizelabel.setVisible(true);
				dogsizeField.setVisible(true);
			}
		});
		
		cat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dogsizelabel.setVisible(false);
				dogsizeField.setVisible(false);
			}
		});
		
		
		btnAddPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int id, String name, String breed, Calendar bDate, String illness, Vet vet, double weight,
				if(nameField.getText().isBlank() ||breedField.getText().isBlank()|| bdateField.getText().isBlank() || weightField.getText().isBlank()) {
					txtADisplay.setText("please fill all of the fields");
				}
				else {
					String name=nameField.getText();
					String breed=breedField.getText();
					
					String[] bdate=bdateField.getText().split("/");
					
					Calendar cal = Calendar.getInstance();
					cal.set(Integer.parseInt(bdate[2]), Integer.parseInt(bdate[1]), Integer.parseInt(bdate[0]));
					
					String illness=illnessField.getText();
					Vet vet=PetiarySys.searchVet(cbVetList.getName());
					
					double weight=Double.parseDouble(weightField.getText());
					
					boolean completed=false;
					if(cat.isSelected()) {
						completed=PetiarySys.addCat(petid, name, breed, cal, illness, vet, weight);
						
					}
					else
					{
						if(dogsizeField.getText().isBlank()) {
							txtADisplay.setText("please fill all of the fields");
						}
						else {
							String dogsize=(dogsizeField.getText());
							completed=PetiarySys.addDog(petid, name, breed, cal, illness, vet, weight,dogsize );
						}
						
						if(completed) {
							txtADisplay.setText("couln't added");
						}
						else {
							txtADisplay.setText("added");
						}
						petid++;
						
					}
				}
				
				
			}
		});
		
		btnSearchPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtADisplay.setText(PetiarySys.searchPet(petIdField.getText()).toString());
			}
		});
		
		btnDeletePet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean success=PetiarySys.removePet(petIdField.getText());
				if(success) {
					txtADisplay.setText("successfully removed");
				}
				else {
					txtADisplay.setText("couldn't removed");
				}
				
			}
		});
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fr.setVisible(true);
				dispose();
			}
		});
	}
}
