package cs.components;

import javax.swing.JToggleButton;

import cs.model.Menu_Model;
import cs.model.Menu_Model.MenuType;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class MenuItem extends JToggleButton {

	/**
	 * Create the panel.
	 */
	
	private JLabel bufferSpacing,lblItem;

	
	public MenuType type;
	
	public MenuItem(Menu_Model Data) {
	

		setBackground(new Color(0, 0, 0, 0));
		setPreferredSize(new Dimension (210,50));
		setLayout(new BorderLayout());
		setOpaque(false);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setEnabled(false);
		setHorizontalAlignment(SwingConstants.LEFT);
		
		lblItem = new JLabel();
		lblItem.setHorizontalAlignment(SwingConstants.LEFT);
		lblItem.setText("Hello There");
		lblItem.setForeground(new Color(255, 255, 255));
		lblItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		
		
		this.type = Data.getType();
		if(Data.getType() == Menu_Model.MenuType.ITEM) {
			lblItem.setText("     "+Data.getName());
			lblItem.setIcon(Data.toImg());
			setEnabled(true);
			
			bufferSpacing = new JLabel("     ");
			add(bufferSpacing, BorderLayout.WEST);
			
		}
		else if(Data.getType() == Menu_Model.MenuType.TITLE) {
			lblItem.setText(Data.getName());
			lblItem.setHorizontalAlignment(SwingConstants.LEADING);
			lblItem.setFont(new Font("SansSerif", Font.BOLD, 12));

		}
		else {
			lblItem.setText("");
		}
		
		
		add(lblItem, BorderLayout.CENTER);
		

	}
	
    @Override
    protected void paintComponent(Graphics g) {
    	Graphics2D g2d = (Graphics2D) g;
        if (isSelected()) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.decode("#17222d"));
            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 5, 5);
        }
        else {
        	g2d.setColor(new Color(0, 0, 0, 0));
        }
        super.paintComponent(g);
    }
	
	
	
	

}
