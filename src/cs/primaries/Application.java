package cs.primaries;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cs.components.Menu;
import cs.components.Page;
import cs.components.SquircleComponent;
import cs.controller.ComponentMovability;
import cs.pages.*;


import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Application extends JFrame {

	private SquircleComponent contentPane;
	private JPanel PagePane;
	
	private Dimension minSize = new Dimension(1175,625);
	private String ColorMode = "#0f1620";
	private Page[] Pages;
	private JTabbedPane tabbedPane;

	/**
	 * Create the frame.
	 */
	public Application() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(minSize);
		setUndecorated(true);
		setResizable(true);
		setLocationRelativeTo(null);
		setBackground(new Color(0,0,0,0));
		
		contentPane = new SquircleComponent();
		contentPane.setBackground(Color.decode(ColorMode));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		Pages = setReferencePages();

		
		PagePane = new JPanel(null);
		PagePane.setOpaque(false);
		
		
		contentPane.add(PagePane, BorderLayout.CENTER);
		

		UIManager.put("TabbedPane.contentOpaque", false);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setRequestFocusEnabled(false);
		tabbedPane.setFocusable(false);
		tabbedPane.setFocusTraversalKeysEnabled(false);
		tabbedPane.setEnabled(false);
		tabbedPane.setOpaque(false);
		tabbedPane.setBackground(new Color(0,0,0,0));
		tabbedPane.setBorder(new EmptyBorder(-3, -3, -3, -3));
	
		tabbedPane.setBounds(0, -30, 960, 655);
	
		PagePane.add(tabbedPane);
		
		Menu menu = new Menu(tabbedPane,this);
		contentPane.add(menu.getContentPane(), BorderLayout.WEST);
		addPages();
		
		pack();	
		//Set Frame to Movable
		ComponentMovability move = new ComponentMovability(Application.this, contentPane);
		move.setMovable(true);
	}
	
	private Page[] setReferencePages() {
		Page[] Reference = new Page[4];
		
		Reference[0] = new StudentData();
		Reference[1] = new Templates();
		Reference[2] = new Compose();
		Reference[3] = new Profile();
	
		return Reference;	
	
	}
	
	private <P extends Page> void addPages() {
		for(int i =0; i < Pages.length; i++) {
			Pages[i].setBounds(0,0, 960, 625);
			if(i!=1) {
				Pages[i].setVisible(false);
			}
			tabbedPane.add(Pages[i]);
		}
	}
	

}
