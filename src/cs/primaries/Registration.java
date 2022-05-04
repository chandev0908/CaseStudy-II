package cs.primaries;


import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Registration extends JFrame {
		
	private JPanel HeaderPanel,contentPane;
	
	//title with icon 
	private JLabel lblTitle;
	//icon besides the password field
	private JLabel lblPasswordVisibility;
	//password fields 
	private JPasswordField txtPassword, txtConfirmPassword;
	//main submit button
	private Button btnRegister;
	//header labels 
	private JLabel lblQuestion, lblLogIn, lblUsername, lblPassword, lblErrorPrompt, lblName;
	//used to set position
	int xx,xy;
	//textfield used for inserting data into the program
	private JTextField txtName, txtUsername,txtEmail;
	


	


	public Registration(String []account) {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 579);
		setLocationRelativeTo(null);
				
		contentPane = new JPanel();									//Mouse event of this Title bar container for setLocation
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) { 			//If the panel is dragged 
				int x = arg0.getXOnScreen(),						//used to get x current position of the panel
				    y = arg0.getYOnScreen();						//used to get y current position of the panel
				Registration.this.setLocation(x - xx, y - xy);		//sets position of the panel to the changed current position x,y
				
			}
		}); 
		contentPane.addMouseListener(new MouseAdapter() {				
			@Override												//This goes in conjunction with the above Mouse listener
			public void mousePressed(MouseEvent evt) {				//if panel is pressed (pressed requires holding click event)
				xx = evt.getX();									//initializes the value of x position location of the panel
				xy = evt.getY();									//initializes the value of y position location of the panel
				
			}
		});
		
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 1, true), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		HeaderPanel = new JPanel();
		HeaderPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		HeaderPanel.setBackground(new Color(33, 33, 33));
		HeaderPanel.setBounds(0, 0, 1100, 72);
		contentPane.add(HeaderPanel);
		HeaderPanel.setLayout(null);
		
		lblTitle = new JLabel("Registration Form\r\n");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(115, 20, 272, 32);
		HeaderPanel.add(lblTitle);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setIcon(new ImageIcon(Registration.class.getResource("/cs/images/User.png")));
		lblTitle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 23));
		
		lblErrorPrompt = new JLabel("");
		lblErrorPrompt.setHorizontalAlignment(JLabel.CENTER);
		lblErrorPrompt.setForeground(Color.RED);
		lblErrorPrompt.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblErrorPrompt.setBounds(442, 88, 283, 15);
		contentPane.add(lblErrorPrompt);
		
		lblName = new JLabel("<html>Name <font color=\"red\"> *");
		lblName.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblName.setHorizontalAlignment(JLabel.CENTER);
		lblName.setBounds(41, 99, 117, 41);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		txtName.setSelectedTextColor(new Color(255, 255, 255));
		txtName.setSelectionColor(new Color(139, 0, 0));
		txtName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		txtName.setColumns(10);
		txtName.setBounds(163, 99, 283, 41);
		contentPane.add(txtName);
		
		lblUsername = new JLabel("<html>Username <font color=\"red\"> *");
		lblUsername.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblUsername.setHorizontalAlignment(JLabel.CENTER);
		lblUsername.setBounds(41, 158, 117, 41);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		txtUsername.setSelectedTextColor(new Color(255, 255, 255));
		txtUsername.setSelectionColor(new Color(139, 0, 0));
		txtUsername.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		txtUsername.setBounds(163, 158, 283, 41);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		lblPassword = new JLabel("<html> Password <font color=\"red\">    *");
		lblPassword.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblPassword.setHorizontalAlignment(JLabel.CENTER);
		lblPassword.setBounds(41, 230, 117, 41);
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		txtPassword.setSelectedTextColor(new Color(255, 255, 255));
		txtPassword.setSelectionColor(new Color(139, 0, 0));
		txtPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		txtPassword.setBounds(163, 230, 283, 41);
		contentPane.add(txtPassword);
	
		
		lblPasswordVisibility = new JLabel("");
		lblPasswordVisibility.setIcon(new ImageIcon(Registration.class.getResource("/cs/images/NotVisible.png")));
		lblPasswordVisibility.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPasswordVisibility.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {					//on click mouse event witch changes the icon and state of the password field
				if( txtPassword.echoCharIsSet()) {						//sets image to not visible
					lblPasswordVisibility.setIcon(new ImageIcon(Registration.class.getResource("/firstQuiz/images/NotVisible.png")));
					txtPassword.setEchoChar((char)0);					//exposes the hidden password characters
				}else {													//sets image to visible
					lblPasswordVisibility.setIcon(new ImageIcon(Registration.class.getResource("/firstQuiz/images/Visible.png")));
					txtPassword.setEchoChar(('●'));						//hides the exposed password characters
				}		
				
			
			}
		});
		lblPasswordVisibility.setBounds(456, 307, 16, 23);
		contentPane.add(lblPasswordVisibility);
		
		JLabel lblConfirmPassword = new JLabel("<html>Confirm Password <font color=\"red\"> *");
		lblConfirmPassword.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblConfirmPassword.setBounds(41, 302, 117, 41);
		contentPane.add(lblConfirmPassword);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		txtConfirmPassword.setSelectedTextColor(new Color(255, 255, 255));
		txtConfirmPassword.setSelectionColor(new Color(139, 0, 0));
		txtConfirmPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		txtConfirmPassword.setBounds(163, 302, 283, 41);
		contentPane.add(txtConfirmPassword);
		
		JLabel lblEmail = new JLabel("Email Address");
		lblEmail.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblEmail.setHorizontalAlignment(JLabel.CENTER);
		lblEmail.setBounds(41, 379, 117, 41);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setSelectionColor(new Color(139, 0, 0));
		txtEmail.setSelectedTextColor(Color.WHITE);
		txtEmail.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		txtEmail.setColumns(10);
		txtEmail.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		txtEmail.setBounds(163, 379, 283, 41);
		contentPane.add(txtEmail);
		
		btnRegister = new Button("Sign Up");
//		btnRegister.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//locale variables used for comparison and data checking
//				String inputName = txtName.getText(),
//					   inputUser = txtUsername.getText(),
//					   inputPass= String.valueOf(txtPassword.getPassword() ),
//				       confirmPass = String.valueOf(txtConfirmPassword.getPassword());
//				
//				if (inputName.trim().equals("") || inputUser.trim().equals("") || inputPass.trim().equals("") || confirmPass.trim().equals("")){
//					lblErrorPrompt.setText("Please fill in all the required fields.");				//when required fields are not filled
//				}
//				else if(!inputPass.equals(confirmPass)) {											//checks if password and confirmation is mismatched
//					lblErrorPrompt.setText("Password does not match.");
//				}																					//check if password and confirmation is matched and all required fields are filled
//				else if(inputPass.equals(confirmPass) && !inputUser.trim().equals("") && !inputName.trim().equals("")) {
//																									//transfers all the data in the textfields and password fields into a string array															
//					account[0] = inputName;															//name
//					account[1] = inputUser;															//username
//					account[2] = inputPass;															//password				
//					account[3] = txtGender.getText();												//gender
//					account[4] = txtReligion.getText();												//religion
//					account[5] = txtNationality.getText();											//nationality
//					account[6] = txtEmail.getText();												//email
//					account[7] = txtOpinion.getText();												//opinion
//					
//					
//					dispose();																		//exits this current frame
//					
//					LogIn login =new LogIn(account);												//enters/re-enter the login page
//					login.setVisible(true);
//				}
//	
//					
//
//			}
//		});
		
		final JCheckBox cbTerm = new JCheckBox("I read and agree to Terms of Service");
		cbTerm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		cbTerm.setBackground(Color.WHITE);
		cbTerm.setBounds(452, 666, 257, 23);
//		cbTerm.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//																				
//				if(cbTerm.isSelected()) {								//if radio checkbox is on
//					btnRegister.setEnabled(true);						//sets the register button to click-able
//				}
//				else{
//					btnRegister.setEnabled(false);						//sets the register button to un-click-able
//				
//				}
//			}
//		});
//		contentPane.add(cbTerm);
		btnRegister.setEnabled(false);
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setBackground(new Color(33, 33, 33));
		btnRegister.setBounds(157, 466, 196, 49);
		contentPane.add(btnRegister);
		
		lblQuestion = new JLabel("Already have an account?");
		lblQuestion.setForeground(Color.BLACK);
		lblQuestion.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblQuestion.setBounds(150, 521, 172, 17);
		contentPane.add(lblQuestion);
		
		lblLogIn = new JLabel("Log In");
//		lblLogIn.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				dispose();												//exits this current frame
//				
//				LogIn frame = new LogIn(account);
//				frame.setVisible(true);									//enters/re-enter the login page
//			}
//		});
		lblLogIn.setForeground(Color.RED);
		lblLogIn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblLogIn.setBounds(323, 521, 63, 17);
		contentPane.add(lblLogIn);
	}
}