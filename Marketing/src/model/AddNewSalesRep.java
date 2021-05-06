/**
 * 
 */
package model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

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
	private JTextField socialInput;

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
		frame.setBounds(100, 100, 597, 340);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(115, 68, 89, 14);
		frame.getContentPane().add(firstNameLabel);
		
		firstNameInput = new JTextField();
		firstNameInput.setBounds(208, 62, 186, 20);
		frame.getContentPane().add(firstNameInput);
		firstNameInput.setColumns(10);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(115, 93, 89, 14);
		frame.getContentPane().add(lastNameLabel);
		
		lastNameInput = new JTextField();
		lastNameInput.setBounds(208, 87, 186, 20);
		frame.getContentPane().add(lastNameInput);
		lastNameInput.setColumns(10);
		
		JLabel socialLabel = new JLabel("Social Security #");
		socialLabel.setBounds(115, 118, 89, 14);
		frame.getContentPane().add(socialLabel);
		
		socialInput = new JTextField();
		socialInput.setBounds(208, 112, 186, 20);
		frame.getContentPane().add(socialInput);
		socialInput.setColumns(10);
		
		JLabel lblUplinksFirstName = new JLabel("Uplink's First Name");
		lblUplinksFirstName.setBounds(115, 143, 89, 14);
		frame.getContentPane().add(lblUplinksFirstName);
		
		uplinkFirstNameInput = new JTextField();
		uplinkFirstNameInput.setBounds(208, 137, 186, 20);
		frame.getContentPane().add(uplinkFirstNameInput);
		uplinkFirstNameInput.setColumns(10);
		
		JLabel lblUplinksLastName = new JLabel("Uplink's Last Name");
		lblUplinksLastName.setBounds(115, 168, 89, 14);
		frame.getContentPane().add(lblUplinksLastName);
		
		uplinkLastNameInput = new JTextField();
		uplinkLastNameInput.setBounds(208, 162, 186, 20);
		frame.getContentPane().add(uplinkLastNameInput);
		uplinkLastNameInput.setColumns(10);
		
		JLabel errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setBounds(36, 191, 360, 20);
		frame.getContentPane().add(errorLabel);
		
		// adds a rep to the map
		JButton addRepButton = new JButton("Add Sales Rep");
		addRepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	//			CommissionGUI gui = new CommissionGUI();
				// create a new rep getting name input
				SalesRep rep = new SalesRep(firstNameInput.getText().trim(),lastNameInput.getText().trim());
				String repNameString = firstNameInput.getText().trim() + lastNameInput.getText().trim();
				// managers name input
				String tempFirstName = uplinkFirstNameInput.getText().trim();
				String tempLastName = uplinkLastNameInput.getText().trim();
				String tempNameString = tempFirstName + tempLastName;
				
				// checks to see if manager fields are not empty 
				if(!tempFirstName.equals("") || !tempLastName.equals("")) {
					// Verifies manager is in the system
					if(CommissionGUI.getRepMap().hasKey(tempNameString) == true) {
						
						CommissionGUI.getRepMap().insertValue(repNameString, rep);
						// updates the reps manager information
						CommissionGUI.getRepMap().findValue(repNameString).setManagerFirstName(uplinkFirstNameInput.getText());
						CommissionGUI.getRepMap().findValue(repNameString).setManagerLastName(uplinkLastNameInput.getText());
						// adds the rep to the map with message output
						errorLabel.setText("Sales Rep added.");
						// manager is not verified, does not add the rep with message
					}else {
						uplinkFirstNameInput.setText("");
						uplinkLastNameInput.setText("");
						errorLabel.setText("Error sales rep not added: " + tempFirstName + " " + tempLastName + " is not a manager.");
					}
				// if rep input fields are empty with error message	
				}else if (firstNameInput.getText().trim().equals("") || lastNameInput.getText().trim().equals("")){
					errorLabel.setText("Sales Rep must have a first and last name.");
				// adds a rep with no manager information
				}else {
					errorLabel.setText("Sales Rep added without manager.");
					CommissionGUI.getRepMap().insertValue(repNameString, rep);
				}
			}
		});
		addRepButton.setBounds(229, 246, 123, 23);
		frame.getContentPane().add(addRepButton);
		
		// clears all fields in window
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstNameInput.setText("");
				lastNameInput.setText("");
				socialInput.setText("");
				uplinkFirstNameInput.setText("");
				uplinkLastNameInput.setText("");
				errorLabel.setText("");

			}
		});
		clearButton.setBounds(362, 246, 98, 23);
		frame.getContentPane().add(clearButton);
		
		// display all reps currently in system
		JButton displayAll = new JButton("Display Current Reps");
		displayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommissionGUI.getRepMap().displayAll();
			}
		});
		displayAll.setBounds(70, 246, 149, 23);
		frame.getContentPane().add(displayAll);	
	}

}
