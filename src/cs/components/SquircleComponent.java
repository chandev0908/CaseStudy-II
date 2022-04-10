package cs.components;

import javax.swing.JComponent;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.awt.Color;
import java.awt.GradientPaint;

//Custom Container Component with a Round edge border
@SuppressWarnings("serial")
public class SquircleComponent extends JComponent {

	private String hex_one, hex_two;
	private boolean hasGradient;
	private FlatEdgeLocale type = FlatEdgeLocale.NONE;
	
	//initialization
	public SquircleComponent() {
		setOpaque(false);
	}
	
//	public SquircleComponent(SquircleComponent reference) {
//		setOpaque(false);
//		copyComponent(reference);
//	}
	
	//Type used to indicate the a flat edge
	public static enum FlatEdgeLocale {
		 SOUTH, EAST, NONE, ALL;
	}

	//Method used to draw the visual aspect (border) of the component
	@Override 
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//Color Gradient for the custom component
		if(hasGradient) {
			GradientPaint gpaint = new GradientPaint(0,0, Color.decode(hex_one), 0, getHeight(), Color.decode(hex_two));
			g2d.setPaint(gpaint);
		}
		//Color component is set to what ever its component background is
		else {
			g2d.setColor(getBackground());
		}
		//draws a round edge rectangle for the component
		g2d.fillRoundRect(0,0, getWidth(), getHeight(), 15,15);
		
		//draws a flat edge rectangle on the specified location surface 
		switch(type) {
		case SOUTH:
			g2d.fillRect(0, getHeight() - 20, getWidth(), getHeight());
			break;
		case EAST:
			g2d.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
			break;
		case NONE:
			default:
				break;
		}
		super.paintComponent(g);
		super.paintChildren(g);
	}


	
	//Method to set the Flat
	public void setEdgeLocale(FlatEdgeLocale type) {
		this.type = type;
	}
	
	//Sets the color gradient of the component
	public void setGradient(String hex_one, String hex_two) {	
		this.hex_one = hex_one;
		this.hex_two = hex_two;
		hasGradient = true;
	}
	

	
	
}
