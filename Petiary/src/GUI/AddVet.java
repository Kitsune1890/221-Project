package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hasA.Vet;
import mainAndSys.PetiarySys;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddVet extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtSearchName;
	private MainFrame mainframe=null;

	/**
	 * Create the frame.
	 */
	public AddVet(JFrame ma) {
		mainframe=(MainFrame)ma;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(266, 37, 251, 275);
		contentPane.add(scrollPane);
		
		JTextArea txtADisplay = new JTextArea();
		scrollPane.setViewportView(txtADisplay);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(25, 25, 64, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Address:");
		lblNewLabel_1.setBounds(25, 50, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone:");
		lblNewLabel_2.setBounds(25, 73, 64, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Open Days:");
		lblNewLabel_3.setBounds(25, 98, 99, 14);
		contentPane.add(lblNewLabel_3);
		
		JCheckBox chkBoxTUE = new JCheckBox("Tue");
		chkBoxTUE.setBounds(82, 119, 56, 23);
		contentPane.add(chkBoxTUE);
		
		JCheckBox chkBoxMON = new JCheckBox("Mon");
		chkBoxMON.setBounds(16, 119, 64, 23);
		contentPane.add(chkBoxMON);
		
		JCheckBox chkBoxWED = new JCheckBox("Wed");
		chkBoxWED.setBounds(140, 118, 58, 23);
		contentPane.add(chkBoxWED);
		
		JCheckBox chkBoxTHU = new JCheckBox("Thu");
		chkBoxTHU.setBounds(200, 119, 60, 23);
		contentPane.add(chkBoxTHU);
		
		JCheckBox chkBoxFRI = new JCheckBox("Fri");
		chkBoxFRI.setBounds(50, 145, 48, 23);
		contentPane.add(chkBoxFRI);
		
		JCheckBox chkBoxSAT = new JCheckBox("Sat");
		chkBoxSAT.setBounds(102, 145, 48, 23);
		contentPane.add(chkBoxSAT);
		
		JCheckBox chkBoxSUN = new JCheckBox("Sun");
		chkBoxSUN.setBounds(165, 145, 48, 23);
		contentPane.add(chkBoxSUN);
		
		txtName = new JTextField();
		txtName.setBounds(92, 22, 121, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(92, 47, 121, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(92, 70, 121, 20);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		JButton btnAddVet = new JButton("Add");
		btnAddVet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean boolArr[] = {chkBoxMON.isSelected(), chkBoxTUE.isSelected(), chkBoxWED.isSelected(), chkBoxTHU.isSelected(), chkBoxFRI.isSelected(), chkBoxSAT.isSelected(), chkBoxSUN.isSelected()};
				
				//checks if there are any open days
				boolean flag = true;
				for (int i = 0; i < boolArr.length; i++) {
					if(boolArr[i]) {
						flag = false;
					}
				}
				
				if(txtName.getText().equals("") || txtAddress.getText().equals("")|| txtPhone.getText().equals("")) {
					txtADisplay.setText("Please do not leave empty fields!");
				}
				else if (flag) {
					txtADisplay.setText("Please select at least one open day!");
				}
				else if(PetiarySys.addVet(txtName.getText(), txtAddress.getText(), txtPhone.getText(), boolArr)) {
					txtADisplay.setText("The veterinary " + txtName.getText() + " is added!");
					PetiarySys.writeIntoFile();
					txtName.setText("");
					txtAddress.setText("");
					txtPhone.setText("");
					chkBoxMON.setSelected(false);
					chkBoxTUE.setSelected(false);
					chkBoxWED.setSelected(false);
					chkBoxTHU.setSelected(false);
					chkBoxFRI.setSelected(false);
					chkBoxSAT.setSelected(false);
					chkBoxSUN.setSelected(false);
				}
				else {
					txtADisplay.setText("The veterinary " + txtName.getText() + " already exists!");
				}
		
			}
		});
		btnAddVet.setBounds(67, 181, 89, 23);
		contentPane.add(btnAddVet);
		
		JLabel lblNewLabel_4 = new JLabel("Name to search:");
		lblNewLabel_4.setBounds(16, 220, 99, 14);
		contentPane.add(lblNewLabel_4);
		
		txtSearchName = new JTextField();
		txtSearchName.setBounds(127, 217, 96, 20);
		contentPane.add(txtSearchName);
		txtSearchName.setColumns(10);
		
		JButton btnSearchPet = new JButton("Search");
		btnSearchPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtSearchName.getText().equals("")) {
					txtADisplay.setText("Please enter a name to search!");
				}
				else {
					Vet v = PetiarySys.searchVet(txtSearchName.getText());
					if(v != null) {
						txtADisplay.setText("Here is the veterinary\n\n" + v.toString());
					}
					else {
						txtADisplay.setText("The veterinary by the name " + txtSearchName.getText() + " does not exist!");
					}
				}
			}
		});
		btnSearchPet.setBounds(25, 255, 89, 23);
		contentPane.add(btnSearchPet);
		
		JButton btnDeleteVet = new JButton("Delete");
		btnDeleteVet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtSearchName.getText().equals("")) {
					txtADisplay.setText("Please enter a name to search!");
				}
				else {
					Vet v = PetiarySys.searchVet(txtSearchName.getText());
					if(v != null) {
						txtADisplay.setText("The veterinary " + v.getName() + " is deleted!");
						PetiarySys.removeVet(v.getName());

					}
					else {
						txtADisplay.setText("The veterinary by the name " + txtSearchName.getText() + " does not exist!");
					}
				}
			}
		});
		btnDeleteVet.setBounds(122, 255, 89, 23);
		contentPane.add(btnDeleteVet);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PetiarySys.writeIntoFile();
				mainframe.getComboBox().setModel(new DefaultComboBoxModel(PetiarySys.getPetIds()));
				mainframe.setVisible(true);
				dispose();
			}
		});
		btnClose.setBounds(67, 289, 89, 23);
		contentPane.add(btnClose);
	}
}
