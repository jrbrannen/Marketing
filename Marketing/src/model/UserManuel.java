/**
 * 
 */
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
 */
public class UserManuel extends JDialog {

	private final JPanel contentPanel = new JPanel();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UserManuel dialog = new UserManuel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UserManuel() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 732, 559);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnThrowsQueueisemptyexception = new JTextPane();
		txtpnThrowsQueueisemptyexception.setText("User Manuel\r\nPart I.\r\n\tBegin by entering a sales representative\u2019s information.\r\n\r\n\r\n");
		txtpnThrowsQueueisemptyexception.setBounds(33, 21, 658, 338);
		contentPanel.add(txtpnThrowsQueueisemptyexception);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						UserManuel dialog = new UserManuel();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	
}
