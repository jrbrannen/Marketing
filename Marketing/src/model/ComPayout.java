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
		
		JLabel salesRepPayDisplay = new JLabel("");
		salesRepPayDisplay.setHorizontalAlignment(SwingConstants.LEFT);
		salesRepPayDisplay.setBounds(449, 228, 86, 14);		
		
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
				salesRepPayDisplay.setText("");
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
		
		frame.getContentPane().add(salesRepPayDisplay);
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
		
		JLabel commissionLabel = new JLabel("Comission Payout");
		commissionLabel.setBounds(447, 203, 158, 14);
		frame.getContentPane().add(commissionLabel);
		
		JButton submitCalcButton = new JButton("Calculate Commission");
		submitCalcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommissionGUI gui = new CommissionGUI();
				String firstName = firstNameInput.getText().trim();
				String lastName = lastNameInput.getText().trim();
				String nameString = firstName + lastName;
				
				if(gui.getRepMap().hasKey(nameString) == false) {
					clearButton.doClick();
					errorMessageLabel.setText("Error: "+ firstName + " "+ lastName + " isn't a sales rep.");
				}else {
					
					double saleAmount = Double.parseDouble(salesInput.getText());
					double pay = salesRepCommision(saleAmount);
					RepsNameDisplay.setText(firstNameInput.getText() + " " + lastNameInput.getText());
					salesRepPayDisplay.setText(String.format("$%.2f", pay));
					
					if(gui.getRepMap().findValue(nameString).getManagerFirstName() != null) {
						firstName = gui.getRepMap().findValue(nameString).getManagerFirstName();
						lastName = gui.getRepMap().findValue(nameString).getManagerLastName();
						nameString = firstName + lastName;
						//configSalesManager(nameString);
						pay = salesManagerCommission(saleAmount);
						managerNameDisplay.setText(firstName + " " + lastName);
						managerComDisplay.setText(String.format("$%.2f", pay));
						System.out.println(gui.getRepMap().findValue(nameString).getManagerFirstName());
						if(gui.getRepMap().findValue(nameString).getManagerFirstName() != null) {
							firstName = gui.getRepMap().findValue(nameString).getManagerFirstName();
							lastName = gui.getRepMap().findValue(nameString).getManagerLastName();
							nameString = firstName + lastName;
							pay = seniorManagerCommission(saleAmount);
							seniorDisplayName.setText(firstName + " " + lastName);
							seniorManagerComDisplay.setText(String.format("$%.2f", pay));
						}
					}
						
				}
				
			}
			
//			private void configSalesManager(String nameString) {
//				// TODO Auto-generated method stub
//				
//				
//			}
		});
		submitCalcButton.setBounds(218, 160, 135, 23);
		frame.getContentPane().add(submitCalcButton);
		
		JButton addToPayrollButton = new JButton("Add To Payroll");
		addToPayrollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CommissionGUI gui = new CommissionGUI();
				String firstName = firstNameInput.getText().trim();
				String lastName = lastNameInput.getText().trim();
				String nameString = firstName + lastName;
				int high = 0;
				int med = 1;
				int low = 2;
				
				if(gui.getRepMap().hasKey(nameString) == false) {
					clearButton.doClick();
					errorMessageLabel.setText("Error: "+ firstName + " "+ lastName + " isn't a sales rep.");	
				}else {
					gui.getRepMap().findValue(nameString).setPriority(high);
					gui.getPaylist().enqueue(gui.getRepMap().findValue(nameString));
					System.out.println("In enque else");
					errorMessageLabel.setText("Sales Rep(s) Added To Payroll");
					if(!managerNameDisplay.getText().equals("")) {
						firstName = gui.getRepMap().findValue(nameString).getManagerFirstName();
						lastName = gui.getRepMap().findValue(nameString).getManagerLastName();
						nameString = firstName + lastName;
						gui.getRepMap().findValue(nameString).setPriority(med);
						gui.getPaylist().enqueue(gui.getRepMap().findValue(nameString));
						if(!seniorDisplayName.getText().contentEquals("")) {
							firstName = gui.getRepMap().findValue(nameString).getManagerFirstName();
							lastName = gui.getRepMap().findValue(nameString).getManagerLastName();
							nameString = firstName + lastName;
							gui.getRepMap().findValue(nameString).setPriority(low);
							gui.getPaylist().enqueue(gui.getRepMap().findValue(nameString));
						}
					}
					
				}
				firstNameInput.setText("");
				lastNameInput.setText("");
				salesInput.setText("");
				salesRepPayDisplay.setText("");
				RepsNameDisplay.setText("");
				managerNameDisplay.setText("");
				seniorDisplayName.setText("");
				managerComDisplay.setText("");
				seniorManagerComDisplay.setText("");
			}
		});
		addToPayrollButton.setBounds(237, 355, 172, 23);
		frame.getContentPane().add(addToPayrollButton);
		
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
	
	public double salesManagerCommission(double sale) {
			double rate = .1;
			return sale * rate;
	}
	
	public double seniorManagerCommission(double sale) {
			double rate = .05;
			return sale * rate;
	}
}
