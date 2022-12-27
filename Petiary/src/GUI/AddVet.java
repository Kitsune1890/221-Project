package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AddVet extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtSearchName;

	/**
	 * Create the frame.
	 */
	public AddVet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		lblNewLabel_3.setBounds(25, 98, 64, 14);
		contentPane.add(lblNewLabel_3);
		
		JCheckBox chkBoxTUE = new JCheckBox("Tue");
		chkBoxTUE.setBounds(16, 118, 48, 23);
		contentPane.add(chkBoxTUE);
		
		JCheckBox chkBoxMON = new JCheckBox("Mon");
		chkBoxMON.setBounds(67, 118, 48, 23);
		contentPane.add(chkBoxMON);
		
		JCheckBox chkBoxWED = new JCheckBox("Wed");
		chkBoxWED.setBounds(122, 118, 48, 23);
		contentPane.add(chkBoxWED);
		
		JCheckBox chkBoxTHU = new JCheckBox("Thu");
		chkBoxTHU.setBounds(175, 118, 48, 23);
		contentPane.add(chkBoxTHU);
		
		JCheckBox chkBoxFRI = new JCheckBox("Fri");
		chkBoxFRI.setBounds(35, 151, 48, 23);
		contentPane.add(chkBoxFRI);
		
		JCheckBox chkBoxSAT = new JCheckBox("Sat");
		chkBoxSAT.setBounds(87, 151, 48, 23);
		contentPane.add(chkBoxSAT);
		
		JCheckBox chkBoxSUN = new JCheckBox("Sun");
		chkBoxSUN.setBounds(150, 151, 48, 23);
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
		btnSearchPet.setBounds(25, 255, 89, 23);
		contentPane.add(btnSearchPet);
		
		JButton btnDeleteVet = new JButton("Delete");
		btnDeleteVet.setBounds(122, 255, 89, 23);
		contentPane.add(btnDeleteVet);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(67, 289, 89, 23);
		contentPane.add(btnClose);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(266, 37, 251, 275);
		contentPane.add(scrollPane);
		
		JTextArea txtADisplay = new JTextArea();
		scrollPane.setViewportView(txtADisplay);
	}
}