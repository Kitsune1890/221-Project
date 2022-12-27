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
	
	private static int petid=123;
	
	
	

	/**
	 * Create the frame.
	 */
	public AddPet(MainFrame fr) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 402);
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
		
		JComboBox cbVetList = new JComboBox();
		String[] arr=new String[20];
		arr[0]="asd";arr[1]="bcs";
		cbVetList.setModel(new DefaultComboBoxModel(arr));
		
		
		cbVetList.setBounds(125, 186, 129, 22);
		contentPane.add(cbVetList);
		
		JLabel lblNewLabel_6 = new JLabel("Id to search:");
		lblNewLabel_6.setBounds(72, 271, 78, 20);
		contentPane.add(lblNewLabel_6);
		
		JButton btnAddPet = new JButton("Add");
		
		btnAddPet.setBounds(99, 219, 89, 23);
		contentPane.add(btnAddPet);
		
		petIdField = new JTextField();
		petIdField.setBounds(157, 271, 36, 20);
		contentPane.add(petIdField);
		petIdField.setColumns(10);
		
		JButton btnSearchPet = new JButton("Search");
		
		btnSearchPet.setBounds(21, 301, 108, 23);
		contentPane.add(btnSearchPet);
		
		JButton btnDeletePet = new JButton("Delete Pet");
		
		btnDeletePet.setBounds(132, 301, 108, 23);
		contentPane.add(btnDeletePet);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(294, 24, 220, 277);
		contentPane.add(scrollPane);
		
		JTextArea txtADisplay = new JTextArea();
		scrollPane.setViewportView(txtADisplay);
		
		JButton btnClose = new JButton("Close");
		
		btnClose.setBounds(89, 334, 85, 21);
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
		
		cbVetList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashSet<Vet> vetset=PetiarySys.getVets();
				String[] names=new String[20];
				int n=0;
				for(Vet v : vetset) {
					names[n]= v.getName();
					n++;
				}
				names[0]="ahmet";
				names[1]="mehmet";
				//cbVetList.setModel(new DefaultComboBoxModel(names));
			}
		});
		
		
		btnAddPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnSearchPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnDeletePet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
