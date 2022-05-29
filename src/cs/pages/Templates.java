package cs.pages;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import cs.components.CScrollBar;
import cs.components.ImageManager;
import cs.components.Page;
import cs.components.SquircleComponent;

public class Templates extends Page {

	ImageManager IM = new ImageManager();
	public Templates() {

		SquircleComponent[] TemplateCard = new SquircleComponent[3];
		JLabel[] CardState = new JLabel[3];
		
		
		TemplateCard[0] = new SquircleComponent();
		TemplateCard[0].setGradient("#FB1497", "#EB8C12");
		TemplateCard[0].setBounds(47, 125, 250, 250);
		
		TemplateCard[1] = new SquircleComponent();
		TemplateCard[1].setGradient("#FB1497", "#EB8C12");
		TemplateCard[1].setBounds(352, 125, 250, 250);
		
		TemplateCard[2] = new SquircleComponent();
		TemplateCard[2].setGradient("#FB1497", "#EB8C12");
		TemplateCard[2].setBounds(645, 125, 250, 250);
		
		CardState[0] = new JLabel();
		CardState[0].setBounds(TemplateCard[0].getBounds());
		CardState[0].setIcon(null);
		CardState[0].setHorizontalAlignment(SwingConstants.CENTER);
		
		CardState[1] = new JLabel();
		CardState[1].setBounds(TemplateCard[1].getBounds());
		CardState[1].setIcon(IM.rescaleImage(50, 50, "Add"));
		CardState[1].setHorizontalAlignment(SwingConstants.CENTER);
		
		CardState[2] = new JLabel();
		CardState[2].setBounds(TemplateCard[2].getBounds());
		CardState[2].setIcon(IM.rescaleImage(50, 50, "Add"));
		CardState[2].setHorizontalAlignment(SwingConstants.CENTER);
		
		
		scrollPane.setBounds(191,303,734,240);
		scrollPane.setVerticalScrollBar(new CScrollBar());
		scrollPane.setHorizontalScrollBar(new CScrollBar());
		scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(new Color(0,0,0,0));
		scrollPanel.setLayout(null);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPanel.add(scrollPane);
		
		
		
		scrollPanel.add(CardState[0]); scrollPanel.add(TemplateCard[0]); 
		scrollPanel.add(CardState[1]); scrollPanel.add(TemplateCard[1]); 
		scrollPanel.add(CardState[2]); scrollPanel.add(TemplateCard[2]); 
		

		TemplateCard[0].addMouseListener(new TemplateAction());
		TemplateCard[1].addMouseListener(new TemplateAction());
		TemplateCard[2].addMouseListener(new TemplateAction());

	}
	
	 private class TemplateAction extends MouseAdapter {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, 
				"This Feature is not yet implemented", "Unimplemented",
				JOptionPane.WARNING_MESSAGE);
			}
	}

}
