package cs.pages;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import cs.components.CScrollBar;
import cs.components.CTable;
import cs.components.Page;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		JEditorPane editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		editorPane.setForeground(Color.WHITE);
		editorPane.setBackground(Color.decode("#212d3a"));
		
		JLabel lblUpdate = new JLabel();
		lblUpdate.setText("Save");
		lblUpdate.setForeground(Color.WHITE);
		lblUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUpdate.setBounds(653, 124, 75, 35);
		scrollPanel.add(lblUpdate);
		
		JLabel lblDelete = new JLabel();
		lblDelete.setText("Send");
		lblDelete.setForeground(Color.WHITE);
		lblDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDelete.setBounds(738, 124, 75, 35);
		scrollPanel.add(lblDelete);
		
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
		
		JTextField textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField.setBackground(new Color(33, 45, 58));
		textField.setBounds(170, 32, 257, 24);
		scrollPanel.add(textField);
		
		JTextField textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_1.setBackground(new Color(33, 45, 58));
		textField_1.setBounds(170, 78, 257, 24);
		scrollPanel.add(textField_1);
		
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
		
	
		
		
	}
}
