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
		addRepButton.setBounds(216, 63, 149, 23);
		frame.getContentPane().add(addRepButton);
		
		JLabel lblNewLael = new JLabel("Welcome To Our Marketing Commision Payout Program");
		lblNewLael.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLael.setForeground(Color.MAGENTA);
		lblNewLael.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 18));
		lblNewLael.setBounds(10, 11, 604, 41);
		frame.getContentPane().add(lblNewLael);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComPayout pay = new ComPayout();
				pay.CommissionPayout();
			}
		});
		btnNewButton.setBounds(226, 97, 135, 23);
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
