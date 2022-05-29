package cs.controller;

import java.awt.EventQueue;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

import cs.db.ConnectionDB;

public class LoginController implements MouseInputListener {
	private JTextField email;
	private JPasswordField pass;

	public LoginController(JTextField email, JPasswordField pass) {
		super();
		this.email = email;
		this.pass = pass;
	}

	// Fields checker
	public boolean fieldChecker() {
		if (email.getText().toString().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Fill empty fields");
		} else if (pass.getPassword().toString().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Fill empty fields");
		}
		return false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (!fieldChecker()) {
			String userEmail = email.getText().toString();
			String userPass = String.valueOf(pass.getPassword());
			System.out.println(userPass);
			ConnectionDB db = new ConnectionDB();
			Connection cn = db.getConnection();
			String query = "INSERT INTO USERINF VALUES (default, ?, ?)";
			String query2 = "SELECT * FROM USERINF";
			try {
				PreparedStatement st2 = cn.prepareStatement(query2);
				ResultSet rs2 = st2.executeQuery();
				PreparedStatement st = cn.prepareStatement(query);
				if (rs2.next()) {
					String query3 = "UPDATE USERINF SET user_email='" + userEmail + "' WHERE ID=" + rs2.getInt("id");
					String query4 = "UPDATE USERINF SET user_pass='" + userPass + "' WHERE ID=" + rs2.getInt("id");
					PreparedStatement st3 = cn.prepareStatement(query3);
					PreparedStatement st4 = cn.prepareStatement(query4);
					st3.execute();
					st4.execute();
					JOptionPane.showMessageDialog(null, "Updated email and password!");
				} else {
					st.setString(1, userEmail);
					st.setString(2, userPass);
					st.execute();
					JOptionPane.showMessageDialog(null, "Your email and password saved!");
				}

			} catch (Exception ex) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Login error: " + ex);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
