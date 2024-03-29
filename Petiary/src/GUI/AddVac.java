package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hasA.Vaccination;
import isA.Pet;
import mainAndSys.PetiarySys;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class AddVac extends JFrame {

	private JPanel contentPane;
	private JTextField date_tf;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AddVac(MainFrame mf) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JTextArea textArea = new JTextArea();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Title = new JLabel("Add Vaccination");
		Title.setBounds(21, 22, 103, 14);
		contentPane.add(Title);
		
		JLabel type = new JLabel("Vaccination Type :");
		type.setBounds(21, 84, 110, 14);
		contentPane.add(type);
		
		JLabel date = new JLabel("Last Vaccination Date :");
		date.setBounds(21, 118, 139, 14);
		contentPane.add(date);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(PetiarySys.getVacNames()));
		comboBox.setBounds(157, 80, 123, 22);
		contentPane.add(comboBox);
		
		date_tf = new JTextField();
		date_tf.setToolTipText("ex: 12/12/2022");
		date_tf.setBounds(157, 115, 123, 20);
		contentPane.add(date_tf);
		date_tf.setColumns(10);
		
		JButton add_bt = new JButton("Add\r\n");
		add_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						Calendar calendar = PetiarySys.stringtoCalendar(date_tf.getText());
						Pet pet =  PetiarySys.searchPet(mf.getComboBox().getSelectedItem().toString());
						int index = comboBox.getSelectedIndex();
						if(PetiarySys.addVaccination(pet, index, calendar)) {
							textArea.setText("Vaccination record added to" + pet.getId() + ".");
							PetiarySys.writeIntoFile();
						}else {
							textArea.setText("Please enter a valid date!");
						}
						
						
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						textArea.setText("Please enter a date.");
					}
			}
		});
		add_bt.setBounds(108, 170, 89, 23);
		contentPane.add(add_bt);
		
		JButton show_bt = new JButton("Show All");
		show_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PetiarySys.searchPet((String) mf.getComboBox().getSelectedItem()).getVac().size() == 0) {
					textArea.setText("There is no vaccination record");
				}else {
					textArea.setText(PetiarySys.displayVac(PetiarySys.searchPet((String) mf.getComboBox().getSelectedItem())));
				}
			}
		});
		show_bt.setBounds(108, 202, 89, 23);
		contentPane.add(show_bt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(301, 36, 364, 250);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(textArea);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mf.setVisible(true);
				dispose();
			}
		});
		btnClose.setBounds(108, 239, 89, 23);
		contentPane.add(btnClose);
	}
}
