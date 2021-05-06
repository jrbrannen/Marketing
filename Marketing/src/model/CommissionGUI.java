package model;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.LinkedList;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

/**************************************************************
* Name        : Data Structures Final Project
* Author      : Jeremy Brannen
* Created     : 4/17/2021
* Course      : CIS 152 Data Structures
* Version     : 1.0
* OS          : Windows 10
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program overall description here
*               Input:  list and describe
*               Output: list and describe
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/

public class CommissionGUI {

	private JFrame frame;
	private JButton comPayoutButton;
	private static SalesRep[] allReps; 
	private static Map repMap;
	static PriorityQueue paylist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// create class objects in app
		allReps = new SalesRep[10000];
		repMap = new Map(10000); 
		paylist = new PriorityQueue();
		
		// create sales reps 
		SalesRep one = new SalesRep("Joe", "Dirt");
		SalesRep two = new SalesRep("Harry", "Kerry");
		SalesRep three = new SalesRep("Jo", "Anne");
		SalesRep four = new SalesRep("Ricco", "Suave");
		SalesRep five = new SalesRep("Dennis", "Menace");
		SalesRep six = new SalesRep("Lara", "Croft");
		SalesRep seven = new SalesRep("Peter", "Parker");
		SalesRep eight = new SalesRep("Rex", "Jones");
		SalesRep nine = new SalesRep("Vanilla", "Ice");
		SalesRep ten = new SalesRep("Sy", "Anora");
		
		
		// add all the sales reps
		addRep(one);
		addRep(two);
		addRep(three);
		addRep(four);
		addRep(five);
		addRep(six);
		addRep(seven);
		addRep(eight);
		addRep(nine);
		addRep(ten);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CommissionGUI window = new CommissionGUI();
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
	public CommissionGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 634, 202);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// title label
		JLabel lblNewLael = new JLabel("Welcome To Our Sales Marketing Commision Payout Program");
		lblNewLael.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLael.setForeground(Color.MAGENTA);
		lblNewLael.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 18));
		lblNewLael.setBounds(0, 11, 614, 41);
		frame.getContentPane().add(lblNewLael);
		
		// button that will open an input window
		JButton addRepButton = new JButton("Add A New Sales Rep");
		addRepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddNewSalesRep newRep = new AddNewSalesRep();
				newRep.addNewRep();
				
			}
		});
		addRepButton.setBounds(216, 63, 201, 23);
		frame.getContentPane().add(addRepButton);
		
		// adds a button to open up a calculation window
		comPayoutButton = new JButton("Calculate Sales Commission");
		comPayoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComPayout pay = new ComPayout();
				pay.CommissionPayout();
			}
		});
		comPayoutButton.setBounds(216, 97, 201, 23);
		frame.getContentPane().add(comPayoutButton);
		
		// adds a button that opens a user manual window
		JButton userManuelButton = new JButton("User Manuel");
		userManuelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserManual manual = new UserManual();
				manual.openManual();
			}
		});
		userManuelButton.setBounds(216, 131, 201, 23);
		frame.getContentPane().add(userManuelButton);
		
		
	}
	
	public Map getRepMap() {
		return repMap;
	}

	public void setRepMap(Map repMap) {
		this.repMap = repMap;
	}

	public SalesRep[] getAllReps() {
		return allReps;
	}

	public void setAllReps(SalesRep[] allReps) {
		this.allReps = allReps;
	}
	
	public static PriorityQueue getPaylist() {
		return paylist;
	}

	public void setPaylist(PriorityQueue payroll) {
		CommissionGUI.paylist = payroll;
	}

	// displays all the reps currently in the application
	public void displayAll() {
		
		for(SalesRep rep : allReps) {
			if(rep!= null) {
			System.out.println(rep);
			}
		}
		
	}

	// adds a rep to the map and to a list
	public static void addRep(SalesRep rep) {
		
		
		String nameString = rep.getFirstname() + rep.getLastname();
		int index = repMap.hash(nameString, 10000);
		repMap.insertValue(nameString, rep);
		allReps[index] = rep;
		System.out.println(index);
	}
}
