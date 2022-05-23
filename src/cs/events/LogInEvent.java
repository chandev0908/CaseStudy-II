package cs.events;

import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class LogInEvent {
	
	
	public static class LogIn implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static class Exit extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent evt) {
			
			if (JOptionPane.showConfirmDialog(null, "Are you sure?", "Exit", //Option pane close indicator
			    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						System.exit(0);
			}
		}
	}
	
	public static class Register extends MouseAdapter{
						
			private JFrame Window;
			public Register(JFrame Window) {
				this.Window = Window;
			}
		
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Window.dispose();													//dispose this current frame
				
//				Registration frame = new Registration(account);						//Creates and redirects to Registration form
//				frame.setVisible(true);
				
			}
		}
	
	
	
	public static class PasswordVisibility extends MouseAdapter{
		
		private JPasswordField passwordField;
		private JLabel VisibilityButton;
	
		public PasswordVisibility(JPasswordField passwordField,JLabel VisibilityButton){
			this.passwordField = passwordField;
			this.VisibilityButton = VisibilityButton;
		}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {					//on click mouse event witch changes the icon and state of the password field
				if(passwordField.echoCharIsSet()) {					//sets image to not visible
					VisibilityButton.setIcon(new ImageIcon(LogInEvent.class.getResource("/cs/images/NotVisible.png")));
					passwordField.setEchoChar((char)0);				//exposes the hidden password characters
				}else {												//sets image to visible
					VisibilityButton.setIcon(new ImageIcon(LogInEvent.class.getResource("/cs/images/Visible.png")));
					passwordField.setEchoChar(('●'));				//hides the exposed password characters
				}
				
			
		}
	}
	


}
