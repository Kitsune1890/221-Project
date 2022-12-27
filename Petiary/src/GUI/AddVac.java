package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class AddVac extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private MainFrame frame=null;

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
		comboBox.setBounds(157, 80, 123, 22);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(157, 115, 123, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton add_bt = new JButton("Add\r\n");
		add_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add_bt.setBounds(108, 170, 89, 23);
		contentPane.add(add_bt);
		
		JButton show_bt = new JButton("Show All");
		show_bt.setBounds(108, 202, 89, 23);
		contentPane.add(show_bt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(301, 36, 178, 226);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
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
