/**
 * 
 */
package model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Apr 30, 2021
 */
public class ComPayout {

	private JFrame frame;
	private JTextField firstNameInput;
	private JTextField lastNameInput;
	private JTextField salesInput;
	

	/**
	 * Launch the application.
	 */
	public void CommissionPayout() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComPayout window = new ComPayout();
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
	public ComPayout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 726, 483);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel firstNameLabel = new JLabel("Sales Rep First Name");
		firstNameLabel.setBounds(39, 39, 110, 14);
		
		JLabel lastNameLabel = new JLabel("Sales Rep Last Name");
		lastNameLabel.setBounds(39, 74, 102, 14);
		
		JLabel salesLabel = new JLabel("Amount Sold");
		salesLabel.setBounds(39, 112, 96, 14);
		salesLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		firstNameInput = new JTextField();
		firstNameInput.setBounds(153, 33, 200, 20);
		firstNameInput.setColumns(10);
		
		lastNameInput = new JTextField();
		lastNameInput.setBounds(153, 71, 200, 20);
		lastNameInput.setColumns(10);
		
		salesInput = new JTextField();
		salesInput.setBounds(153, 106, 86, 20);
		salesInput.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sales Represenitive: ");
		lblNewLabel.setBounds(39, 228, 200, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel managerDisplayName = new JLabel("Sales Rep Manager: ");
		managerDisplayName.setBounds(41, 267, 200, 14);
		managerDisplayName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel senorSaleManagerLabel = new JLabel("Senor Sales Manager: ");
		senorSaleManagerLabel.setBounds(41, 306, 200, 14);
		senorSaleManagerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel seniorDisplayName = new JLabel("");
		seniorDisplayName.setBounds(239, 306, 201, 14);
		seniorDisplayName.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel managerNameDisplay = new JLabel("");
		managerNameDisplay.setBounds(239, 267, 200, 14);
		managerNameDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel RepsNameDisplay = new JLabel("");
		RepsNameDisplay.setBounds(239, 228, 200, 14);
		RepsNameDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel salesRepComDisplay = new JLabel("");
		salesRepComDisplay.setHorizontalAlignment(SwingConstants.LEFT);
		salesRepComDisplay.setBounds(449, 228, 86, 14);		
		
		JLabel errorMessageLabel = new JLabel("");
		errorMessageLabel.setForeground(Color.RED);
		errorMessageLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		errorMessageLabel.setBounds(41, 194, 368, 23);
		frame.getContentPane().add(errorMessageLabel);
		
		JLabel managerComDisplay = new JLabel("");
		managerComDisplay.setBounds(447, 267, 88, 14);
		frame.getContentPane().add(managerComDisplay);
		
		JLabel seniorManagerComDisplay = new JLabel("");
		seniorManagerComDisplay.setBounds(447, 306, 88, 14);
		frame.getContentPane().add(seniorManagerComDisplay);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNameInput.setText("");
				lastNameInput.setText("");
				salesInput.setText("");
				salesRepComDisplay.setText("");
				RepsNameDisplay.setText("");
				managerNameDisplay.setText("");
				seniorDisplayName.setText("");
				errorMessageLabel.setText("");
				managerComDisplay.setText("");
				seniorManagerComDisplay.setText("");
			}
		});	
		clearButton.setBounds(587, 355, 89, 23);
		frame.getContentPane().add(clearButton);
		
		frame.getContentPane().add(salesRepComDisplay);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(senorSaleManagerLabel);
		frame.getContentPane().add(managerDisplayName);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(firstNameLabel);
		frame.getContentPane().add(firstNameInput);
		frame.getContentPane().add(lastNameLabel);
		frame.getContentPane().add(salesLabel);
		frame.getContentPane().add(salesInput);
		frame.getContentPane().add(lastNameInput);
		frame.getContentPane().add(RepsNameDisplay);
		frame.getContentPane().add(managerNameDisplay);
		frame.getContentPane().add(seniorDisplayName);
		
		JLabel commissionLabel = new JLabel("Commission Payout");
		commissionLabel.setBounds(447, 203, 158, 14);
		frame.getContentPane().add(commissionLabel);
		
		JButton submitCalcButton = new JButton("Calculate Commission");
		submitCalcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				String firstName = firstNameInput.getText().trim();
				String lastName = lastNameInput.getText().trim();
				String nameString = firstName + lastName;
				
				// checks to see if rep entered is not in the system
				if(CommissionGUI.getRepMap().hasKey(nameString) == false) {
					clearButton.doClick();
					errorMessageLabel.setText("Error: "+ firstName + " "+ lastName + " isn't a sales rep.");
				// if rep is in the system
				}else{
					// parse and get sale input
					double saleAmount = Double.parseDouble(salesInput.getText());
					// call calculation method
					double pay = salesRepCommision(saleAmount);
					// display output
					RepsNameDisplay.setText(firstNameInput.getText() + " " + lastNameInput.getText());
					salesRepComDisplay.setText(String.format("$%.2f", pay));
					
					// if rep has a manager
					if(CommissionGUI.getRepMap().findValue(nameString).getManagerFirstName() != null) {
						// get managers info
						firstName = CommissionGUI.getRepMap().findValue(nameString).getManagerFirstName();
						lastName = CommissionGUI.getRepMap().findValue(nameString).getManagerLastName();
						nameString = firstName + lastName;
						// call calculation method
						pay = salesManagerCommission(saleAmount);
						// display output
						managerNameDisplay.setText(firstName + " " + lastName);
						managerComDisplay.setText(String.format("$%.2f", pay));
						
						// if the manager has a manager
						if(CommissionGUI.getRepMap().findValue(nameString).getManagerFirstName() != null) {
							firstName = CommissionGUI.getRepMap().findValue(nameString).getManagerFirstName();
							lastName = CommissionGUI.getRepMap().findValue(nameString).getManagerLastName();
							nameString = firstName + lastName;
							// call calculation method
							pay = seniorManagerCommission(saleAmount);
							// display output
							seniorDisplayName.setText(firstName + " " + lastName);
							seniorManagerComDisplay.setText(String.format("$%.2f", pay));
						}
					}
						
				}
				
			}
		});
		submitCalcButton.setBounds(218, 160, 135, 23);
		frame.getContentPane().add(submitCalcButton);
		
		// add everyone getting paid to a priority queue
		JButton addToPayrollButton = new JButton("Add To Payroll");
		addToPayrollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	//			CommissionGUI gui = new CommissionGUI();
				String firstName = firstNameInput.getText().trim();
				String lastName = lastNameInput.getText().trim();
				String nameString = firstName + lastName;
				int high = 0;
				int med = 1;
				int low = 2;
				
				// check to if rep is not in system with error message
				if(CommissionGUI.getRepMap().hasKey(nameString) == false) {
					clearButton.doClick();
					errorMessageLabel.setText("Error: "+ firstName + " "+ lastName + " isn't a sales rep.");	
				// if rep is in system
				}else {
					// find rep info in map and set priority to high
					CommissionGUI.getRepMap().findValue(nameString).setPriority(high);
					CommissionGUI.getRepMap().findValue(nameString).setCommission(salesRepCommision(Double.parseDouble(salesInput.getText())));
					// enqueue the rep with message
					CommissionGUI.getPaylist().enqueue(CommissionGUI.getRepMap().findValue(nameString));
					System.out.println("In enque else");
					errorMessageLabel.setText("Sales Rep(s) Added To Payroll");
					
					// if rep has a manager
					if(!managerNameDisplay.getText().equals("")) {
						// get managers info
						firstName = CommissionGUI.getRepMap().findValue(nameString).getManagerFirstName();
						lastName = CommissionGUI.getRepMap().findValue(nameString).getManagerLastName();
						nameString = firstName + lastName;
						// set priority
						CommissionGUI.getRepMap().findValue(nameString).setPriority(med);
						CommissionGUI.getRepMap().findValue(nameString).setCommission(salesManagerCommission(Double.parseDouble(salesInput.getText())));
						// enqueue 
						CommissionGUI.getPaylist().enqueue(CommissionGUI.getRepMap().findValue(nameString));
						
						// if rep has a senior manager
						if(!seniorDisplayName.getText().contentEquals("")) {
							// get senior manager info
							firstName = CommissionGUI.getRepMap().findValue(nameString).getManagerFirstName();
							lastName = CommissionGUI.getRepMap().findValue(nameString).getManagerLastName();
							nameString = firstName + lastName;
							// set priority
							CommissionGUI.getRepMap().findValue(nameString).setPriority(low);
							CommissionGUI.getRepMap().findValue(nameString).setCommission(seniorManagerCommission(Double.parseDouble(salesInput.getText())));
							// enqueue
							CommissionGUI.getPaylist().enqueue(CommissionGUI.getRepMap().findValue(nameString));
						}
					}
					
				}
				// reset all fields
				firstNameInput.setText("");
				lastNameInput.setText("");
				salesInput.setText("");
				salesRepComDisplay.setText("");
				RepsNameDisplay.setText("");
				managerNameDisplay.setText("");
				seniorDisplayName.setText("");
				managerComDisplay.setText("");
				seniorManagerComDisplay.setText("");
			}
		});
		addToPayrollButton.setBounds(237, 355, 172, 23);
		frame.getContentPane().add(addToPayrollButton);
		
		// button that prints the priority queue of payroll
		JButton dequeButton = new JButton("Rep Pay Priority");
		dequeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				PayrollList pay;
				try {
					pay = new PayrollList();
					pay.PayrollList();
				} catch (QueueIsEmptyException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
					
			}
		});
		dequeButton.setBounds(419, 355, 158, 23);
		frame.getContentPane().add(dequeButton);
		
	
	
	}
	// calculation for sales rep commission
	public double salesRepCommision(double sale) {
		
			double rate = .30;
			return sale * rate;
	}
	
	// calculation for sales manager commission
	public double salesManagerCommission(double sale) {
			double rate = .1;
			return sale * rate;
	}
	
	// calculation for senior sales manager commission
	public double seniorManagerCommission(double sale) {
			double rate = .05;
			return sale * rate;
	}
}
