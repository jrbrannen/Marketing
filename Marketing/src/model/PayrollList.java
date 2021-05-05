/**
 * 
 */
package model;

import java.awt.EventQueue;
import java.io.StringWriter;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * May 3, 2021
 */
public class PayrollList {

	private JFrame frame;
	private JLabel payrollOutput;

	/**
	 * Launch the application.
	 */
	public void PayrollList() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayrollList window = new PayrollList();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws QueueIsEmptyException 
	 */
	public PayrollList() throws QueueIsEmptyException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws QueueIsEmptyException 
	 */
	private void initialize() throws QueueIsEmptyException {
		frame = new JFrame();
		frame.setBounds(100, 100, 728, 720);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel payrollOutput = new JLabel();
		payrollOutput.setVerticalAlignment(SwingConstants.TOP);
		payrollOutput.setBounds(596, 437, 58, 53);
		frame.getContentPane().add(payrollOutput);
		String textString = printQueue();
		System.out.println(textString);
		payrollOutput.setText(textString);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(40, 25, 580, 154);
		frame.getContentPane().add(textPane);
		textPane.setText(textString);
	}	

	public String printQueue() throws QueueIsEmptyException {
		
		CommissionGUI gui = new CommissionGUI();
		SalesRep rep;// = new SalesRep();
			String textString = "damn boy";
			while(!CommissionGUI.getPaylist().isEmpty()) {
				
				rep = CommissionGUI.getPaylist().dequeue();
				textString = textString + " " + rep.getFirstname() + " " + rep.getLastname() + "\n";
				System.out.println(rep);
				//System.out.println(textString);
				System.out.println("in loop");
			}
			return textString;
			
	}
}
