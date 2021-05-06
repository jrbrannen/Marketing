package model;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * May 2, 2021
 * GUI class displays a user manual
 */
public class UserManual extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void openManual() {
		try {
			UserManual dialog = new UserManual();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UserManual() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 732, 712);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnThrowsQueueisemptyexception = new JTextPane();
		txtpnThrowsQueueisemptyexception.setEditable(false);
		txtpnThrowsQueueisemptyexception.setText("				User Manuel\r\n" + 
				"When the application executes a window will pop up giving you two options.\r\n" + 
				"	-Add a new sales rep\r\n" + 
				"	-Calculate sales commission\r\n" + 
				"If you’d like to add a new sales representative, click on “Add A New Sales Rep” and a window to add them will pop up.\r\n" + 
				"	-From here you can add as many reps as you’d like with the following\r\n" + 
				"		The sales representative social security number\r\n" + 
				"		The sales representative’s manager’s first and last name\r\n" + 
				"	-After all information is entered at the bottom of the window you can click on the “Add Sales Rep” button 		and the rep will be added.\r\n" + 
				"	-You can also display all Sales Representatives currently in the application by clicking on “Display 		Current Reps”\r\n" + 
				"	-Once you are finished adding or editing sales reps you can close this window\r\n" + 
				"To calculate a commission, you can click on the “Calculate Sales Commission” button.\r\n" + 
				"	-Here you can enter the first and last name of the sales rep and the dollar amount that they sold\r\n" + 
				"	-Once entered push the “Calculate Commission” button.\r\n" + 
				"	-The commission amount due to the sales rep will show along with any commissions for their 		appropriate managers.\r\n" + 
				"		Reps get 30% of their sales\r\n" + 
				"		Managers get 10% of a rep’s sales\r\n" + 
				"		Senior managers get 5% of a rep’s sales\r\n" + 
				"	-The next step is to review the information and add them to the payroll.  If the information is correct click 		on the “Add to payroll” button.\r\n" + 
				"		Add as many different sales as you’d like by entering a new rep, then calculating, and 			finally by adding them to the payroll.\r\n" + 
				"		Once you’ve entered all the sales and are ready to see who to payout click on the “Rep Pay 			Priority” button.\r\n" + 
				"By using the “Rep Pay Priority” anyone who made a sale will be pushed out of the queue in order to be paid.  This will display the correct order in which all employees should be paid along with amount to pay them for each sale.\r\n" + 
				"	A rep will get paid first before any manager they have\r\n" + 
				"	A manager will get paid after all reps have been paid and before any senior managers are paid\r\n" + 
				"	Senior managers will get paid last");
		txtpnThrowsQueueisemptyexception.setBounds(35, 21, 658, 608);
		contentPanel.add(txtpnThrowsQueueisemptyexception);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

		}
	}

	
}
