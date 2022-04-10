package cs.pages;

import javax.swing.JLabel;

import cs.components.Page;

import java.awt.Font;
import java.awt.Color;

public class LogOut extends Page {

	/**
	 * Create the panel.
	 */
	public LogOut() {
		
		JLabel lblName_1 = new JLabel();
		lblName_1.setText("<W.I.P> Page is Currently Unavailable\r\n");
		lblName_1.setForeground(Color.WHITE);
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1.setBounds(10, 11, 356, 35);
		scrollPanel.add(lblName_1);

	}

}
