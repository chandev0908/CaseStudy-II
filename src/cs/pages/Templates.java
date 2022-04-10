package cs.pages;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import cs.components.CScrollBar;
import cs.components.Page;
import cs.components.SquircleComponent;

public class Templates extends Page {

	/**
	 * Create the panel.
	 */
	public Templates() {

		SquircleComponent[] TemplateCard = new SquircleComponent[3];
		
		TemplateCard[0] = new SquircleComponent();
		TemplateCard[0].setGradient("#FB1497", "#EB8C12");
		TemplateCard[0].setBounds(47, 27, 250, 250);
		
		TemplateCard[1] = new SquircleComponent();
		TemplateCard[1].setGradient("#FB1497", "#EB8C12");
		TemplateCard[1].setBounds(352, 27, 250, 250);
		
		TemplateCard[2] = new SquircleComponent();
		TemplateCard[2].setGradient("#FB1497", "#EB8C12");
		TemplateCard[2].setBounds(645, 27, 250, 250);
		
		
		scrollPane.setBounds(191,303,734,240);
		scrollPane.setVerticalScrollBar(new CScrollBar());
		scrollPane.setHorizontalScrollBar(new CScrollBar());
		scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(new Color(0,0,0,0));
		scrollPanel.setLayout(null);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPanel.add(scrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		editorPane.setForeground(Color.WHITE);
		editorPane.setBackground(Color.decode("#212d3a"));
		
		JLabel lblUpdate = new JLabel();
		lblUpdate.setText("Update\r\n");
		lblUpdate.setForeground(Color.WHITE);
		lblUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUpdate.setBounds(52, 306, 75, 35);
		scrollPanel.add(lblUpdate);
		
		JLabel lblDelete = new JLabel();
		lblDelete.setText("Delete");
		lblDelete.setForeground(Color.WHITE);
		lblDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDelete.setBounds(52, 352, 75, 35);
		scrollPanel.add(lblDelete);
		
		JLabel lblView = new JLabel();
		lblView.setText("View");
		lblView.setForeground(Color.WHITE);
		lblView.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblView.setBounds(52, 398, 75, 35);
		scrollPanel.add(lblView);
		
		
		
		scrollPanel.add(TemplateCard[0]);
		scrollPanel.add(TemplateCard[1]);
		scrollPanel.add(TemplateCard[2]);
		
	}

}
