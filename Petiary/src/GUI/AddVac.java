package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hasA.Vaccination;
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
		setBounds(100, 100, 532, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JTextArea textArea = new JTextArea();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Title = new JLabel("Add Vacination");
		Title.setBounds(21, 22, 103, 14);
		contentPane.add(Title);
		
		JLabel type = new JLabel("Vacination Type :");
		type.setBounds(21, 84, 110, 14);
		contentPane.add(type);
		
		JLabel date = new JLabel("Last Vacination Date :");
		date.setBounds(21, 118, 139, 14);
		contentPane.add(date);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(PetiarySys.getVacNames()));
		comboBox.setBounds(157, 80, 123, 22);
		contentPane.add(comboBox);
		
		date_tf = new JTextField();
		date_tf.setBounds(157, 115, 123, 20);
		contentPane.add(date_tf);
		date_tf.setColumns(10);
		
		JButton add_bt = new JButton("Add\r\n");
		add_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = false;
				int index = 0;
					try {
						Calendar calendar = PetiarySys.stringtoCalendar(date_tf.getText());
						ArrayList<Vaccination> temp = (ArrayList<Vaccination>) PetiarySys.getVacTemplate().clone();
						Vaccination vac;
						if(PetiarySys.searchPet((String) mf.getComboBox().getSelectedItem()).getVac().size() == 0) {
							vac = temp.get(PetiarySys.getVacTemplateIndex((String)comboBox.getSelectedItem()));
							vac.addVacDate(calendar);
							PetiarySys.searchPet((String) mf.getComboBox().getSelectedItem()).getVac().add(vac);
							textArea.setText((String) mf.getComboBox().getSelectedItem() + "Vaccination record added");
						}else {
							for(int i = 0; i < PetiarySys.searchPet((String) mf.getComboBox().getSelectedItem()).getVac().size(); i++) {
								if(PetiarySys.getVacTemplateIndex((String)comboBox.getSelectedItem()) == temp.get(i).getId()) {
									flag = true;
									index = i;
								}
							}
							if(flag) {
								if(calendar.compareTo(PetiarySys.searchPet((String) mf.getComboBox().getSelectedItem()).getVac().get(index).getVactinationDates().get(PetiarySys.searchPet((String) mf.getComboBox().getSelectedItem()).getVac().get(index).getVactinationDates().size()-1))>0) {
									PetiarySys.searchPet((String) mf.getComboBox().getSelectedItem()).getVac().get(index).addVacDate(calendar);
									textArea.setText((String) mf.getComboBox().getSelectedItem() + "Vaccination record Updated");
								}else {
									textArea.setText("You should add newer that current date");
								}
							}
								
							else {
								vac = temp.get(PetiarySys.getVacTemplateIndex((String)comboBox.getSelectedItem()));
								vac.addVacDate(calendar);
								PetiarySys.searchPet((String) mf.getComboBox().getSelectedItem()).getVac().add(vac);
								textArea.setText((String) mf.getComboBox().getSelectedItem() + "Vaccination record added");
							}
						}						
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						textArea.setText("Please Enter A date");
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
		scrollPane.setBounds(301, 36, 178, 226);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(textArea);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PetiarySys.writeIntoFile();
				mf.setVisible(true);
				dispose();
			}
		});
		btnClose.setBounds(108, 239, 89, 23);
		contentPane.add(btnClose);
	}
}
