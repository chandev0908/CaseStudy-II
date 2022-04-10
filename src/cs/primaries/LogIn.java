package cs.primaries;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import cs.events.ComponentMovability;

import javax.swing.SwingConstants;



public class LogIn extends JFrame {

	private JPanel contentPane;
	
	private JTextField textField;
	private JPasswordField passwordField;					
	
	int xx, xy;
	

	/**
	 * Create the frame.
	 */
	
	//Constructor used to create an instance in the main method
	public LogIn() {
		
		
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
		
		//Set Frame to Movable
		ComponentMovability move = new ComponentMovability(LogIn.this, contentPane);
		move.setMovable(true);
		
		
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
		
		JLabel lblPasswordVisibility = new JLabel("");
		lblPasswordVisibility.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPasswordVisibility.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {					//on click mouse event witch changes the icon and state of the password field
					if(passwordField.echoCharIsSet()) {					//sets image to not visible
						lblPasswordVisibility.setIcon(new ImageIcon(LogIn.class.getResource("/cs/images/NotVisible.png")));
						passwordField.setEchoChar((char)0);				//exposes the hidden password characters
					}else {												//sets image to visible
						lblPasswordVisibility.setIcon(new ImageIcon(LogIn.class.getResource("/cs/images/Visible.png")));
						passwordField.setEchoChar(('●'));				//hides the exposed password characters
					}
					
				
			}
		});
		
		lblPasswordVisibility.setIcon(new ImageIcon(LogIn.class.getResource("/cs/images/Visible.png")));
		lblPasswordVisibility.setBounds(586, 250, 16, 23);
		contentPane.add(lblPasswordVisibility);
		
		Label lblErrorPrompt = new Label("");
		lblErrorPrompt.setForeground(Color.RED);
		lblErrorPrompt.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblErrorPrompt.setBounds(297, 290, 283, 15);
		contentPane.add(lblErrorPrompt);

		
		Button LogIn = new Button("Log In");
		LogIn.setForeground(Color.WHITE);
		LogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				}
			});
			
			
		

		LogIn.setBackground(new Color(204, 51, 51));
		LogIn.setBounds(340, 321, 187, 60);
		contentPane.add(LogIn);
		
		Label lblClose = new Label("X");
	
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				
				if (JOptionPane.showConfirmDialog(null, "Are you sure?", "Exit", //Option pane close indicator
				    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							System.exit(0);
				}
			}
			
		});
		
		Label lblRegister = new Label("Sign Up");
		lblRegister.addMouseListener(new MouseAdapter() {							//Creates and redirects to Registration form
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();															//dispose this current frame
				
//				Registration frame = new Registration(account);
//				frame.setVisible(true);
				
			}
		});
		
		lblRegister.setForeground(Color.RED);
		lblRegister.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblRegister.setBounds(473, 398, 63, 17);
		contentPane.add(lblRegister);
		lblClose.setForeground(new Color(255, 0, 0));
		lblClose.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		lblClose.setBounds(585, 10, 29, 36);
		contentPane.add(lblClose);
		
		Label label = new Label("Don't have account?"); 							//Question label
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		label.setBounds(340, 398, 139, 17);
		contentPane.add(label);
		
		
	}



	/**
	 * Application Launch Main method
	 */

	
	public static void main(String[] args) {
		/*
		 * EventQueue will process all the GUI components of all the different class
		 * before moving on and creating the instance of Main
		 * Without this the instance will be created before every other components added even processed 
		 */
		
		//it is still possible to run without this but this will cause unwanted graphical issues
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

