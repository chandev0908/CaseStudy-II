package cs.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WindowExitController extends MouseAdapter{

	private JFrame frame;
	public WindowExitController(JFrame frame){
		this.frame = frame;
	}
	
	@Override 
	public void mouseClicked(MouseEvent e) {
		if (JOptionPane.showConfirmDialog(frame, "Are you sure?", "Exit", //Option pane close indicator
		    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
		}
	}
}
