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
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setBounds(36, 191, 360, 20);
		frame.getContentPane().add(errorLabel);
		
		JButton addRepButton = new JButton("Add Sales Rep");
		addRepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommissionGUI gui = new CommissionGUI();
				SalesRep rep = new SalesRep(firstNameInput.getText(),lastNameInput.getText());
				String tempFirstName = uplinkFirstNameInput.getText().trim();
				String tempLastName = uplinkLastNameInput.getText().trim();
			//	String tempNameString = tempFirstName + tempLastName;
				if(!tempFirstName.equals("") || !tempLastName.equals("")) {
					if(gui.getRepMap().hasKey(tempFirstName + tempLastName)) {
						rep.setManagerFirstName(uplinkFirstNameInput.getText());
						rep.setManagerLastName(uplinkLastNameInput.getText());
						CommissionGUI.addRep(rep);
						errorLabel.setText("Sales Rep added.");
					}else {
						uplinkFirstNameInput.setText("");
						uplinkLastNameInput.setText("");
						errorLabel.setText("Error sales rep not added: " + tempFirstName + " " + tempLastName + " is not a manager.");
					}
				}else {
					errorLabel.setText("Sales Rep added without manager.");
					CommissionGUI.addRep(rep);
				}
			}
		});
		addRepButton.setBounds(229, 246, 123, 23);
		frame.getContentPane().add(addRepButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstNameInput.setText("");
				lastNameInput.setText("");
				socialInput.setText("");
				uplinkFirstNameInput.setText("");
				uplinkLastNameInput.setText("");

			}
		});
		clearButton.setBounds(362, 246, 98, 23);
		frame.getContentPane().add(clearButton);
		
		JButton displayAll = new JButton("Display Current Reps");
		displayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommissionGUI gui = new CommissionGUI();
				gui.displayAll();
			}
		});
		displayAll.setBounds(70, 246, 149, 23);
		frame.getContentPane().add(displayAll);
		
		
	}
}
