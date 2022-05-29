package cs.pages;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.pdf.TextField;

import cs.components.CScrollBar;
import cs.components.ImageManager;
import cs.components.Page;
import cs.controller.LoginController;
import cs.controller.PasswordVisibilityController;
import cs.db.ConnectionDB;
import cs.primaries.LogIn;

import javax.swing.JTextField;
import java.awt.Font;
import java.sql.*;

public class Profile extends Page {
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel VisibilityButton;
	ImageManager IM = new ImageManager();

	public Profile() {

		headerPane = new JPanel();
		headerPane.setBounds(0, 0, 969, 216);
		headerPane.setOpaque(false);

		scrollPane = new JScrollPane();
		scrollPanel = new JPanel();
		scrollPanel.setBounds(24, 269, 919, 322);
		scrollPanel.setBackground(Color.decode(foreground));

		scrollPane.setBounds(58, 170, 840, 373);
		scrollPane.setVerticalScrollBar(new CScrollBar());
		scrollPane.setHorizontalScrollBar(new CScrollBar());
		scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(new Color(0, 0, 0, 0));
		scrollPanel.setLayout(null);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Page.class.getResource("/cs/images/Icon.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(372, 75, 175, 175);
		add(lblNewLabel_1);
		headerPane.setLayout(null);
		add(headerPane);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Page.class.getResource("/cs/images/glitchCover.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 969, 186);
		headerPane.add(lblNewLabel);
		add(scrollPanel);

		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField.setBackground(new Color(33, 45, 58));
		textField.setBounds(119, 39, 257, 24);
		scrollPanel.add(textField);

		JLabel lblEmail = new JLabel();
		lblEmail.setText("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(34, 31, 75, 35);
		scrollPanel.add(lblEmail);

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		passwordField.setColumns(10);
		passwordField.setBorder(new EmptyBorder(0, 0, 0, 0));
		passwordField.setBackground(new Color(33, 45, 58));
		passwordField.setBounds(602, 39, 257, 24);
		scrollPanel.add(passwordField);

		JLabel lblPassword = new JLabel();
		lblPassword.setText("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(482, 31, 110, 35);
		scrollPanel.add(lblPassword);

		JLabel lblSave = new JLabel();
		lblSave.setText("  Save");
		lblSave.setIcon(IM.rescaleImage(20, 20, "Save"));
		lblSave.setForeground(Color.WHITE);
		lblSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSave.setBounds(834, 261, 75, 35);
		scrollPanel.add(lblSave);

		VisibilityButton = new JLabel("");
		VisibilityButton.setBounds(869, 39, 16, 23);
		VisibilityButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		VisibilityButton.setIcon(new ImageIcon(LogIn.class.getResource("/cs/images/Visible.png")));
		scrollPanel.add(VisibilityButton);

		// Going to set default values for email and pass if theres current data in db
		ConnectionDB db = new ConnectionDB();
		try {
			Connection cn = db.getConnection();
			String query = "SELECT * FROM USERINF";
			PreparedStatement st = cn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			if(rs.next()){
				textField.setText(rs.getString("user_email"));
				passwordField.setText(rs.getString("user_pass"));
			}else{
				JOptionPane.showMessageDialog(null, "Email and password is required for sending email! You can go to profile to login your GMAIL account");
			}
			
		} catch (Exception ex) {
		}
		// Controller
		LoginController lc = new LoginController(textField, passwordField);
		lblSave.addMouseListener(lc);

		initEvents();
	}

	private void initEvents() {
		VisibilityButton.addMouseListener(new PasswordVisibilityController(passwordField, VisibilityButton));

	}
}
