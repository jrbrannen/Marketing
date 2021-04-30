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
	private JTextField firstName;
	private JTextField lastName;
	private JTextField level;
	private LinkedList<SalesRep> reps = new LinkedList();
	private JButton btnNewButton;
	private final Action action = new SwingAction();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frame.setBounds(100, 100, 927, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(87, 108, 597, 170);
		frame.getContentPane().add(textPane);
		
		JButton addRepButton = new JButton("Add A Sales Rep");
		addRepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddNewSalesRep newRep = new AddNewSalesRep();
				newRep.addNewRep();
				
			}
		});
		addRepButton.setBounds(87, 321, 130, 23);
		frame.getContentPane().add(addRepButton);
		
		JLabel lblNewLael = new JLabel("Welcome To Our Marketing Commision Payout Program");
		lblNewLael.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLael.setForeground(Color.MAGENTA);
		lblNewLael.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 18));
		lblNewLael.setBounds(80, 11, 604, 41);
		frame.getContentPane().add(lblNewLael);
		
		firstName = new JTextField();
		firstName.setBounds(87, 374, 130, 20);
		frame.getContentPane().add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(246, 374, 130, 20);
		frame.getContentPane().add(lastName);
		lastName.setColumns(10);
		
		level = new JTextField();
		level.setBounds(460, 374, 86, 20);
		frame.getContentPane().add(level);
		level.setColumns(10);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(265, 321, 135, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}
	
	private void addSalesRep() {
		
		SalesRep newrep = new SalesRep();
		newrep.setFirstname(firstName.getText());
		newrep.setLastname(lastName.getText());
		int lvl = Integer.parseInt(level.getText());
		newrep.setLevel(lvl);
		
		reps.add(newrep);
	
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
