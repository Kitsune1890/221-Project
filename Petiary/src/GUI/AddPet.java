package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hasA.Vet;
import isA.Pet;
import mainAndSys.PetiarySys;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.ParseException;
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
	private JTextArea txtADisplay;
	private JTextField idField;

	public JComboBox getCbVetList() {
		return cbVetList;
	}

	public JTextArea getADisplay() {
		return txtADisplay;
	}




	/**
	 * Create the frame.
	 */
	public AddPet(MainFrame fr) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(21, 90, 93, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Breed:");
		lblNewLabel_1.setBounds(21, 115, 93, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Birthdate:");
		lblNewLabel_2.setBounds(21, 140, 93, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Weight:");
		lblNewLabel_3.setBounds(21, 165, 93, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Illnesses:");
		lblNewLabel_4.setBounds(21, 190, 93, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Veterinary:");
		lblNewLabel_5.setBounds(21, 213, 93, 14);
		contentPane.add(lblNewLabel_5);
		
		nameField = new JTextField();
		nameField.setBounds(124, 87, 129, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		breedField = new JTextField();
		breedField.setBounds(124, 112, 129, 20);
		breedField.setColumns(10);
		contentPane.add(breedField);
		
		bdateField = new JTextField();
		bdateField.setToolTipText("ex: 12/12/2022");
		bdateField.setBounds(124, 137, 129, 20);
		bdateField.setColumns(10);
		contentPane.add(bdateField);
		
		weightField = new JTextField();
		weightField.setBounds(124, 162, 129, 20);
		weightField.setColumns(10);
		contentPane.add(weightField);
		
		illnessField = new JTextField();
		illnessField.setBounds(124, 187, 129, 20);
		illnessField.setColumns(10);
		contentPane.add(illnessField);
		
		cbVetList = new JComboBox();
		cbVetList.setBounds(124, 213, 129, 22);
		contentPane.add(cbVetList);
		
		JLabel lblNewLabel_6 = new JLabel("Id to search:");
		lblNewLabel_6.setBounds(70, 326, 78, 20);
		contentPane.add(lblNewLabel_6);
		
		JButton btnAddPet = new JButton("Add");
		
		btnAddPet.setBounds(102, 283, 89, 23);
		contentPane.add(btnAddPet);
		
		petIdField = new JTextField();
		petIdField.setBounds(155, 326, 36, 20);
		contentPane.add(petIdField);
		petIdField.setColumns(10);
		
		JButton btnSearchPet = new JButton("Search");
		
		btnSearchPet.setBounds(34, 356, 108, 23);
		contentPane.add(btnSearchPet);
		
		JButton btnDeletePet = new JButton("Delete Pet");
		
		btnDeletePet.setBounds(145, 356, 108, 23);
		contentPane.add(btnDeletePet);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(294, 24, 246, 369);
		contentPane.add(scrollPane);
		
		txtADisplay = new JTextArea();
		scrollPane.setViewportView(txtADisplay);
		
		JButton btnClose = new JButton("Close");
		
		btnClose.setBounds(102, 389, 85, 21);
		contentPane.add(btnClose);
		
		JRadioButton dog = new JRadioButton("dog");
		
		catOrDog.add(dog);
		dog.setBounds(144, 24, 62, 21);
		contentPane.add(dog);
		
		JRadioButton cat = new JRadioButton("cat",true);
		
		catOrDog.add(cat);
		cat.setBounds(209, 24, 79, 21);
		contentPane.add(cat);
		
		JLabel lblNewLabel_7 = new JLabel("Select Your Pet:  ");
		lblNewLabel_7.setBounds(23, 28, 116, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel dogsizelabel = new JLabel("Dog size:  ");
		dogsizelabel.setBounds(21, 248, 70, 13);
		contentPane.add(dogsizelabel);
		
		JLabel idlabel = new JLabel("ID:  ");
		idlabel.setBounds(21, 63, 45, 13);
		contentPane.add(idlabel);
		
		idField = new JTextField();
		idField.setBounds(124, 60, 129, 19);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JComboBox dogsize_CB = new JComboBox();
		dogsize_CB.setModel(new DefaultComboBoxModel(new String[] {"Small", "Medium", "Large"}));
		dogsize_CB.setBounds(124, 246, 129, 20);
		contentPane.add(dogsize_CB);
		dogsize_CB.setVisible(false);
		
		dogsizelabel.setVisible(false);
		
		dog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dogsizelabel.setVisible(true);
				dogsize_CB.setVisible(true);
			}
		});
		
		cat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dogsizelabel.setVisible(false);
				dogsize_CB.setVisible(false);
			}
		});
		
		
		btnAddPet.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				//int id, String name, String breed, Calendar bDate, String illness, Vet vet, double weight,
				if(idField.getText().isBlank() || nameField.getText().isBlank() ||breedField.getText().isBlank()|| bdateField.getText().isBlank() || weightField.getText().isBlank() || cbVetList.getSelectedItem() == null) {
					txtADisplay.setText("Please fill all the fields.");
				}
				else {
					int id = Integer.parseInt(idField.getText());
					
					String name=nameField.getText();
					String breed=breedField.getText();
					
					Calendar cal=null;
					try {
						cal = PetiarySys.stringtoCalendar(bdateField.getText());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					if(cal.compareTo(Calendar.getInstance())>0) {
						txtADisplay.setText("Birthday cannot be later than today's date.");
					}
					else {
						String illness=illnessField.getText();
						Vet vet=PetiarySys.searchVet(cbVetList.getSelectedItem().toString());
						
						double weight=Double.parseDouble(weightField.getText());
						
						boolean completed=false;
						if(cat.isSelected()) {
							completed=PetiarySys.addCat(id,name, breed, cal, illness, vet, weight);
						}
						else
						{
							String dogsize=(dogsize_CB.getSelectedItem().toString());
							completed=PetiarySys.addDog(id,name, breed, cal, illness, vet, weight,dogsize );
						
						}
						
						if(completed) {
							txtADisplay.setText("The pet named " + name + " is added!");
							PetiarySys.writeIntoFile();
							
						}
						else {
							txtADisplay.setText("The pet named " + name + " already exists!");
						}
						
						idField.setText(""); nameField.setText(""); breedField.setText(""); bdateField.setText(""); weightField.setText("");
					}
					
				}
				
				
			}
		});
		
		btnSearchPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!petIdField.getText().equals("")) {
					Pet pet = PetiarySys.searchPet(petIdField.getText());
					if(pet == null) {
						txtADisplay.setText("The pet by the Id " + petIdField.getText() + "does not exist.");
					}
					else {
						txtADisplay.setText(pet.toString());
					}
				}else {
					txtADisplay.setText("Please enter an ID.");
				}
				
				
				
			}
		});
		
		btnDeletePet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!petIdField.getText().equals("")) {
					boolean success=PetiarySys.removePet(petIdField.getText());
					if(success) {
						txtADisplay.setText("successfully removed");
					}
					else {
						txtADisplay.setText("couldn't removed");
					}
				}
				else {
					txtADisplay.setText("Please enter ID");
				}
				
			}
		});
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idField.setText(""); nameField.setText(""); breedField.setText(""); bdateField.setText(""); weightField.setText("");
				fr.getComboBox().setModel(new DefaultComboBoxModel(PetiarySys.getPetIds()));
				fr.setVisible(true);
				dispose();
			}
		});
		
		
	}
	
	
}
