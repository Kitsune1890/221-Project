package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import mainAndSys.PetiarySys;

import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
	private AddVet addvet;
	private JComboBox comboBox;

	
	ImageIcon cat = new ImageIcon("cat.jpeg");
	ImageIcon dog = new ImageIcon("dog.jpeg");
	
	private JLabel imageLbl;
    
	public JComboBox getComboBox() {
		return comboBox;
	}



	/**
	 * Create the frame.
	 */
	public MainFrame() {
		vac = new AddVac(this);
		vac.setVisible(false);
		
		addpet=new AddPet(this);
		addpet.setVisible(false);
		
		addvet=new AddVet(this);
		addvet.setVisible(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 103, 626, 359);
		contentPane.add(scrollPane);
		
		JTextArea txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
		
		JLabel imageLbl = new JLabel("");
		imageLbl.setBounds(613, 11, 68, 73);
		contentPane.add(imageLbl);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("cat"))
					imageLbl.setIcon(cat);
				else
					imageLbl.setIcon(dog);
			}
		});
		comboBox.setBounds(164, 27, 415, 31);
		contentPane.add(comboBox);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() == null)
					txtArea.setText("Please choose a pet.");
				else {
					String str = comboBox.getSelectedItem().toString();
					txtArea.setText(PetiarySys.searchPet(str).toString());  
				}
			}
		});
		btnShow.setBounds(318, 69, 115, 23);
		contentPane.add(btnShow);
		
		
		
		JButton btnAddPet = new JButton("Add / Remove Pet");
		btnAddPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = addpet.getCbVetList();
				cb.setModel(new DefaultComboBoxModel(PetiarySys.getVetnames()));
				addpet.setVisible(true);
				dispose();
			}
		});
		btnAddPet.setBounds(115, 486, 206, 23);
		contentPane.add(btnAddPet);
		
		JButton btnAddVet = new JButton("Add / Remove Veterinary");
		btnAddVet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addvet.setVisible(true);
				dispose();
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
