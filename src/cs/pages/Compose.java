package cs.pages;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import cs.components.CScrollBar;
import cs.components.Page;
import cs.controller.SendEmailController;

import javax.swing.JEditorPane;
import javax.swing.JLabel;

public class Compose extends Page{

	/**
	 * Create the panel.
	 */

	public Compose() {
		
		scrollPane.setBounds(58, 170,840,373);
		scrollPane.setVerticalScrollBar(new CScrollBar());
		scrollPane.setHorizontalScrollBar(new CScrollBar());
		scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(new Color(0,0,0,0));
		scrollPanel.setLayout(null);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPanel.add(scrollPane);
		
		JEditorPane txtCompose = new JEditorPane();
		scrollPane.setViewportView(txtCompose);
		txtCompose.setForeground(Color.WHITE);
		txtCompose.setBackground(Color.decode("#212d3a"));
		
		JLabel lblSave = new JLabel();
		lblSave.setText("Save");
		lblSave.setForeground(Color.WHITE);
		lblSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSave.setBounds(653, 124, 75, 35);
		scrollPanel.add(lblSave);
		
		JLabel lblSend = new JLabel();
		lblSend.setText("Send");
		lblSend.setForeground(Color.WHITE);
		lblSend.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSend.setBounds(738, 124, 75, 35);
		scrollPanel.add(lblSend);

		JLabel lblView = new JLabel();
		lblView.setText("View");
		lblView.setForeground(Color.WHITE);
		lblView.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblView.setBounds(823, 124, 75, 35);
		scrollPanel.add(lblView);
		
		JLabel lblSubject = new JLabel();
		lblSubject.setText("Subject:");
		lblSubject.setForeground(Color.WHITE);
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubject.setBounds(58, 24, 102, 35);
		scrollPanel.add(lblSubject);
		
		JTextField txtSubject = new JTextField();
		txtSubject.setForeground(Color.WHITE);
		txtSubject.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSubject.setColumns(10);
		txtSubject.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtSubject.setBackground(new Color(33, 45, 58));
		txtSubject.setBounds(170, 32, 257, 24);
		scrollPanel.add(txtSubject);
		
		JTextField txtRecipient = new JTextField();
		txtRecipient.setForeground(Color.WHITE);
		txtRecipient.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtRecipient.setColumns(10);
		txtRecipient.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtRecipient.setBackground(new Color(33, 45, 58));
		txtRecipient.setBounds(170, 78, 257, 24);
		scrollPanel.add(txtRecipient);
		
		JLabel lblRecipient = new JLabel();
		lblRecipient.setText("Recipient:");
		lblRecipient.setForeground(Color.WHITE);
		lblRecipient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRecipient.setBounds(58, 70, 102, 35);
		scrollPanel.add(lblRecipient);
		
		JLabel lblMessage = new JLabel();
		lblMessage.setText("Message:");
		lblMessage.setForeground(Color.WHITE);
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMessage.setBounds(58, 128, 102, 35);
		scrollPanel.add(lblMessage);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(578, 32, 259, 24);
		scrollPanel.add(dateChooser);
		
		JLabel lblDate = new JLabel();
		lblDate.setText("Date:");
		lblDate.setForeground(Color.WHITE);
		lblDate.setBackground(new Color(33, 45, 58));
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(493, 24, 75, 35);
		scrollPanel.add(lblDate);

		// Mouse Listener for Send
		SendEmailController sendController = new SendEmailController(txtCompose, txtSubject, txtRecipient);
		lblSend.addMouseListener(sendController);
	}
}
