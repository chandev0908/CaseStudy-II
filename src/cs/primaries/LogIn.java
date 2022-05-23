package cs.primaries;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import cs.events.ComponentMovability;
import cs.events.LogInEvent;

import javax.swing.SwingConstants;



public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;					
	private JButton LogIn;
	private JLabel CloseButton, RegisterButton, VisibilityButton;
	
	//Constructor used to create an instance in the main method
	public LogIn() {
		initComponents();
		initEvents();
	}
	
	private void initComponents() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
															
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLocation(getLocation());
		
		JPanel panel = new JPanel();
		panel.setBounds(0, -28, 269, 547);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPicutreLabel = new JLabel("");
		lblPicutreLabel.setBounds(0, 28, 269, 508);
		lblPicutreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPicutreLabel.setIcon(new ImageIcon(LogIn.class.getResource("/cs/images/Banner.png")));
		panel.add(lblPicutreLabel);
		
		Label lblUsername = new Label("Username");
		lblUsername.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblUsername.setBounds(297, 72, 127, 41);
		contentPane.add(lblUsername);
		
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		textField.setBounds(297, 119, 283, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Label lblPassword = new Label("Password");
		lblPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblPassword.setBounds(297, 196, 127, 41);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		passwordField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		passwordField.setBounds(297, 243, 283, 41);
		contentPane.add(passwordField);
		
		VisibilityButton = new JLabel("");
		VisibilityButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
		VisibilityButton.setIcon(new ImageIcon(LogIn.class.getResource("/cs/images/Visible.png")));
		VisibilityButton.setBounds(586, 250, 16, 23);
		contentPane.add(VisibilityButton);
		
		Label lblErrorPrompt = new Label("");
		lblErrorPrompt.setForeground(Color.RED);
		lblErrorPrompt.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblErrorPrompt.setBounds(297, 290, 283, 15);
		contentPane.add(lblErrorPrompt);

		
		LogIn = new JButton("Log In");
		LogIn.setForeground(Color.WHITE);
		
			
		LogIn.setBackground(new Color(204, 51, 51));
		LogIn.setBounds(340, 321, 187, 60);
		contentPane.add(LogIn);
		
		CloseButton = new JLabel("X");
		CloseButton.setForeground(new Color(255, 0, 0));
		CloseButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		CloseButton.setBounds(585, 10, 29, 36);
		contentPane.add(CloseButton);
		
		RegisterButton = new JLabel("Sign Up");
		RegisterButton.setForeground(Color.RED);
		RegisterButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		RegisterButton.setBounds(473, 398, 63, 17);
		contentPane.add(RegisterButton);

		
		Label label = new Label("Don't have account?"); 							//Question label
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		label.setBounds(340, 398, 139, 17);
		contentPane.add(label);
		
	}

	private void initEvents() {
		//Set Frame to Movable
		ComponentMovability move = new ComponentMovability(LogIn.this, contentPane);
		move.setMovable(true);
		//Login Events
		LogIn.addActionListener(new LogInEvent.LogIn());
		CloseButton.addMouseListener(new LogInEvent.Exit());
		RegisterButton.addMouseListener(new LogInEvent.Register(this));
		VisibilityButton.addMouseListener(new LogInEvent.PasswordVisibility(passwordField, VisibilityButton));
	}

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					LogIn frame = new LogIn(); 						//Create the instance of main
					frame.setVisible(true);
		
				} catch (Exception e) {
					e.printStackTrace();							//Catches any error and prints it into a console	
				}
			}
		});
	}

}

