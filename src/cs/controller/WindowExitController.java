package cs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cs.db.ConnectionDB;

public class WindowExitController implements ActionListener{

	private JFrame frame;
	public WindowExitController(JFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // Code Duplicated from LogIn Events due to lack of insight
		if (JOptionPane.showConfirmDialog(frame,
				"Are you sure your email and pass will be permanently removed?", "Exit", // Option pane close
																							// indicator
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			ConnectionDB db = new ConnectionDB();
			Connection cn = db.getConnection();
			String query = "DELETE FROM USERINF WHERE ID = ?;";
			String query2 = "SELECT * FROM USERINF";
			try {
				PreparedStatement st2 = cn.prepareStatement(query2);
				ResultSet rs2 = st2.executeQuery();	
				rs2.next();
				// Delete current email and pass
				PreparedStatement st = cn.prepareStatement(query);
				st.setInt(1, rs2.getInt("id"));
				st.execute();
			} catch (Exception ex) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Logout error:" + ex);
			}
			frame.dispose();
		}

	}
}
