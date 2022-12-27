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

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 602);
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
		
		JTextPane txtPDisplay = new JTextPane();
		scrollPane.setViewportView(txtPDisplay);
		
		JButton btnAddPet = new JButton("Add Pet");
		btnAddPet.setBounds(181, 486, 140, 23);
		contentPane.add(btnAddPet);
		
		JButton btnAddVet = new JButton("Add Vetenarian");
		btnAddVet.setBounds(333, 486, 138, 23);
		contentPane.add(btnAddVet);
		
		JButton btnAddVac = new JButton("Add Vaccination");
		btnAddVac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddVac.setBounds(481, 486, 140, 23);
		contentPane.add(btnAddVac);
		
		JButton btnRmvPet = new JButton("Remove Pet");
		btnRmvPet.setBounds(233, 520, 140, 23);
		contentPane.add(btnRmvPet);
		
		JButton btnRmvVet = new JButton("Remove Vetenatian");
		btnRmvVet.setBounds(383, 520, 196, 23);
		contentPane.add(btnRmvVet);
	}
}
