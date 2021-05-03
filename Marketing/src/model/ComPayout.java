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
		
		JLabel uplinkDisplayName = new JLabel("Representives Uplink: ");
		uplinkDisplayName.setBounds(39, 253, 200, 14);
		uplinkDisplayName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblRepresentivesSeniorUplink = new JLabel("Representive's Senior Uplink: ");
		lblRepresentivesSeniorUplink.setBounds(39, 279, 200, 14);
		lblRepresentivesSeniorUplink.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel seniorDisplayName = new JLabel("");
		seniorDisplayName.setBounds(239, 279, 201, 14);
		seniorDisplayName.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel uplinkNameDisplay = new JLabel("");
		uplinkNameDisplay.setBounds(239, 254, 200, 14);
		uplinkNameDisplay.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel RepsNameDisplay = new JLabel("");
		RepsNameDisplay.setBounds(239, 228, 200, 14);
		RepsNameDisplay.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel salesRepPayDisplay = new JLabel("");
		salesRepPayDisplay.setHorizontalAlignment(SwingConstants.LEFT);
		salesRepPayDisplay.setBounds(449, 228, 86, 14);		
		
		JLabel errorMessageLabel = new JLabel("");
		errorMessageLabel.setBounds(72, 194, 281, 23);
		frame.getContentPane().add(errorMessageLabel);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNameInput.setText("");
				lastNameInput.setText("");
				salesInput.setText("");
				salesRepPayDisplay.setText("");
				RepsNameDisplay.setText("");
				uplinkNameDisplay.setText("");
				seniorDisplayName.setText("");
				errorMessageLabel.setText("");
			}
		});	
		clearButton.setBounds(264, 153, 89, 23);
		frame.getContentPane().add(clearButton);
		
		frame.getContentPane().add(salesRepPayDisplay);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblRepresentivesSeniorUplink);
		frame.getContentPane().add(uplinkDisplayName);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(firstNameLabel);
		frame.getContentPane().add(firstNameInput);
		frame.getContentPane().add(lastNameLabel);
		frame.getContentPane().add(salesLabel);
		frame.getContentPane().add(salesInput);
		frame.getContentPane().add(lastNameInput);
		frame.getContentPane().add(RepsNameDisplay);
		frame.getContentPane().add(uplinkNameDisplay);
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
				String nameString = firstName + lastName;;
				
				
				if(gui.getRepMap().hasKey(nameString) == false) {
					RepsNameDisplay.setText("Error: "+ firstName + " "+ lastName + " isn't a sales rep.");
					clearButton.doClick();
				}else {
					double saleAmount = Double.parseDouble(salesInput.getText());
					double pay = salesRepCommision(saleAmount);
					RepsNameDisplay.setText(firstNameInput.getText() + " " + lastNameInput.getText());
					salesRepPayDisplay.setText(String.format("$%.2f", pay));
					configSalesManager(nameString);
					
				}
				
			}

			private void configSalesManager(String nameString) {
				// TODO Auto-generated method stub
				
				
			}
		});
		submitCalcButton.setBounds(72, 153, 135, 23);
		frame.getContentPane().add(submitCalcButton);
		
		JButton addToPayrollButton = new JButton("Add To Payroll");
		addToPayrollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CommissionGUI gui = new CommissionGUI();
				String firstName = firstNameInput.getText().trim();
				String lastName = lastNameInput.getText().trim();
				String nameString = firstName + lastName;
				
				if(gui.getRepMap().hasKey(nameString) == false) {
					RepsNameDisplay.setText("Error: "+ firstName + " "+ lastName + " isn't a sales rep.");
					clearButton.doClick();
				}else {
					gui.getPayroll().enqueue(gui.getRepMap().findValue(nameString));
					
				}
			}
		});
		addToPayrollButton.setBounds(86, 355, 172, 23);
		frame.getContentPane().add(addToPayrollButton);
		
		JButton dequeButton = new JButton("Dequeue");
		dequeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommissionGUI gui = new CommissionGUI();
					try {
						System.out.println(gui.getPayroll().dequeue());
					} catch (QueueIsEmptyException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			
			}
		});
		dequeButton.setBounds(385, 355, 158, 23);
		frame.getContentPane().add(dequeButton);
	
	}
	// calculation for sales rep commission
	public double salesRepCommision(double sale) {
		
			double rate = .30;
			return sale * rate;
	}
}
