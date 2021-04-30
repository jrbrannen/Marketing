/**
 * 
 */
package model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Apr 30, 2021
 */
public class AddNewSalesRep {

	private JFrame frame;
	private JTextField firstNameInput;
	private JTextField lastNameInput;
	private JTextField uplinkFirstNameInput;
	private JTextField uplinkLastNameInput;

	/**
	 * Launch the application.
	 */
	public void addNewRep() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewSalesRep window = new AddNewSalesRep();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddNewSalesRep() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 941, 478);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel firstName = new JLabel("First Name");
		firstName.setBounds(115, 60, 93, 25);
		frame.getContentPane().add(firstName);
		
		firstNameInput = new JTextField();
		firstNameInput.setBounds(229, 62, 191, 20);
		frame.getContentPane().add(firstNameInput);
		firstNameInput.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(115, 96, 93, 14);
		frame.getContentPane().add(lblLastName);
		
		lastNameInput = new JTextField();
		lastNameInput.setBounds(229, 93, 191, 20);
		frame.getContentPane().add(lastNameInput);
		lastNameInput.setColumns(10);
		
		JLabel lblUplinksFirstName = new JLabel("Uplink's First Name");
		lblUplinksFirstName.setBounds(115, 156, 93, 14);
		frame.getContentPane().add(lblUplinksFirstName);
		
		JLabel lblUplinksLastName = new JLabel("Uplink's Last Name");
		lblUplinksLastName.setBounds(115, 191, 93, 14);
		frame.getContentPane().add(lblUplinksLastName);
		
		uplinkFirstNameInput = new JTextField();
		uplinkFirstNameInput.setBounds(229, 153, 191, 20);
		frame.getContentPane().add(uplinkFirstNameInput);
		uplinkFirstNameInput.setColumns(10);
		
		uplinkLastNameInput = new JTextField();
		uplinkLastNameInput.setBounds(229, 188, 191, 20);
		frame.getContentPane().add(uplinkLastNameInput);
		uplinkLastNameInput.setColumns(10);
	}
}
