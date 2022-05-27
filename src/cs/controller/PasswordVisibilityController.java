package cs.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class PasswordVisibilityController extends MouseAdapter{
	
	private JPasswordField passwordField;
	private JLabel VisibilityButton;

	public PasswordVisibilityController(JPasswordField passwordField,JLabel VisibilityButton){
		this.passwordField = passwordField;
		this.VisibilityButton = VisibilityButton;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {					//on click mouse event witch changes the icon and state of the password field
			if(passwordField.echoCharIsSet()) {					//sets image to not visible
				VisibilityButton.setIcon(new ImageIcon(LoginController.class.getResource("/cs/images/NotVisible.png")));
				passwordField.setEchoChar((char)0);				//exposes the hidden password characters
			}else {												//sets image to visible
				VisibilityButton.setIcon(new ImageIcon(LoginController.class.getResource("/cs/images/Visible.png")));
				passwordField.setEchoChar(('●'));				//hides the exposed password characters
			}
			
		
	}
}



