
package model;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * April 24, 2021
 * GUI class to display a priority queue list for the user to view
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
		
		CommissionGUI.getPaylist().printQueue();

	}	
	

	
}
