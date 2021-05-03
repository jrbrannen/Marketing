/**
 * 
 */
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

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Apr 26, 2021
 */
public class CommissionGUI {

	private JFrame frame;
	//private LinkedList<SalesRep> reps = new LinkedList();
	private JButton comPayoutButton;
	private static SalesRep[] allReps; 
	private static Map repMap;
	private static PriorityQueue payroll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		allReps = new SalesRep[10000];
		repMap = new Map(10000); 
		payroll = new PriorityQueue();
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
		
		JButton addRepButton = new JButton("Add A New Sales Rep");
		addRepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddNewSalesRep newRep = new AddNewSalesRep();
				newRep.addNewRep();
				
			}
		});
		addRepButton.setBounds(216, 63, 201, 23);
		frame.getContentPane().add(addRepButton);
		
		JLabel lblNewLael = new JLabel("Welcome To Our Sales Marketing Commision Payout Program");
		lblNewLael.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLael.setForeground(Color.MAGENTA);
		lblNewLael.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 18));
		lblNewLael.setBounds(0, 11, 614, 41);
		frame.getContentPane().add(lblNewLael);
		
		comPayoutButton = new JButton("Calculate Sales Commission");
		comPayoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComPayout pay = new ComPayout();
				pay.CommissionPayout();
			}
		});
		comPayoutButton.setBounds(216, 97, 201, 23);
		frame.getContentPane().add(comPayoutButton);
		
		
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
	
	public PriorityQueue getPayroll() {
		return payroll;
	}

	public void setPayroll(PriorityQueue payroll) {
		CommissionGUI.payroll = payroll;
	}

	public void displayAll() {
		
		for(SalesRep rep : allReps) {
			if(rep!= null) {
			System.out.println(rep);
			}
		}
		
	}

	public void addRep(SalesRep rep) {
		
		
		String nameString = rep.getFirstname() + rep.getLastname();
		int index = repMap.hash(nameString, 10000);
		repMap.insertValue(nameString, rep);
		allReps[index] = rep;
		System.out.println(index);
	}
	
}
