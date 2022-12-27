package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private AddVac vac;
	private AddPet addpet;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		vac = new AddVac(this);
		vac.setVisible(false);
		
		addpet=new AddPet(this);
		addpet.setVisible(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(613, 11, 68, 73);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(164, 27, 415, 31);
		contentPane.add(comboBox);
		
		JButton btnShow = new JButton("Show");
		btnShow.setBounds(318, 69, 115, 23);
		contentPane.add(btnShow);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 103, 626, 359);
		contentPane.add(scrollPane);
		
		JTextArea txtADisplay = new JTextArea();
		scrollPane.setViewportView(txtADisplay);
		
		JButton btnAddPet = new JButton("Add / Remove Pet");
		btnAddPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addpet.setVisible(true);
				dispose();
			}
		});
		btnAddPet.setBounds(115, 486, 206, 23);
		contentPane.add(btnAddPet);
		
		JButton btnAddVet = new JButton("Add / Remove Veterinary");
		btnAddVet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAddVet.setBounds(333, 486, 198, 23);
		contentPane.add(btnAddVet);
		
		JButton btnAddVac = new JButton("Add Vaccination");
		btnAddVac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				vac.setVisible(true);
			}
		});
		btnAddVac.setBounds(541, 486, 140, 23);
		contentPane.add(btnAddVac);
	}
}
