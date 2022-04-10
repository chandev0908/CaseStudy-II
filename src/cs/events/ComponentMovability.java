package cs.events;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class ComponentMovability {
	
	JFrame frame;
	JComponent comp;
	int xx, xy;											//Used to get and change the current position of this frame
	
	public ComponentMovability(JFrame frame, JComponent comp){
		this.comp = comp;
		this.frame = frame;
	}

	public void setMovable(boolean status) {
		comp.addMouseMotionListener(new MouseMotionAdapter() {
		@Override
		public void mouseDragged(MouseEvent arg0) {
			if(status) {								//If the panel is dragged 
			int x = arg0.getXOnScreen(),				//used to get x current position of the panel
			    y = arg0.getYOnScreen();				//used to get y current position of the panel
			frame.setLocation(x - xx, y - xy);		    //sets position of the panel to the changed current position x,y
			}
		}
	});
		comp.addMouseListener(new MouseAdapter() {
		@Override										//This goes in conjunction with the above Mouse listener	
		public void mousePressed(MouseEvent evt) {		//if panel is pressed (pressed requires holding click event)																				
			   xx = evt.getX();							//initializes the value of x position location of the panel
			   xy = evt.getY();							//initializes the value of y position location of the panel
														
			
		}
	});
		
	}
}
