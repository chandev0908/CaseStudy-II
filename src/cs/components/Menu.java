package cs.components;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import cs.components.SquircleComponent.FlatEdgeLocale;
import cs.model.Menu_Model;

import java.awt.Dimension;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu  {
	
	private JLabel buffer = new JLabel("");

	private String[] colorGradient = {"#080f17", "#00000"};
	
	private String LogoURL = "Logo";
//	private Font TitleFont = new Font("Dialog", Font.BOLD, 30);
	private final ImageManager IM;
	
	private SquircleComponent contentPane;
	
	private MenuItem[] mi = new MenuItem[11];	
	/**
	 * Create the panel.
	 */
	private JPanel LogoPanel,ItemPanel;
	private ButtonGroup GroupList;

	private JTabbedPane ReferencePage;
	public Menu(JTabbedPane ReferencePage) {
		this.ReferencePage = ReferencePage;
		
		
		contentPane = new SquircleComponent();
		contentPane.setGradient(colorGradient[0], colorGradient[1]);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setLayout(new BorderLayout());
		contentPane.setPreferredSize(new Dimension(215,625));
		contentPane.setEdgeLocale(FlatEdgeLocale.EAST);
		
		LogoPanel = new JPanel();
		LogoPanel.setLayout(new BorderLayout(0,0));
		LogoPanel.setOpaque(false);
		JLabel LogoImage = new JLabel(); 
		LogoImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		IM = new ImageManager();
		LogoImage.setIcon(IM.rescaleImage(250, 125, LogoURL));
		
		
		
		ItemPanel = new JPanel();
		ItemPanel.setOpaque(false);
		GroupList = new ButtonGroup();

		
		LogoPanel.add(buffer, BorderLayout.NORTH);
		LogoPanel.add(LogoImage, BorderLayout.CENTER);
		
		contentPane.add(LogoPanel, BorderLayout.NORTH);
		contentPane.add(ItemPanel, BorderLayout.CENTER);
		ItemPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		setItems();
		initItems();
		
	}
	


	private void initItems() {
		for(int i = 0, y = 0; i < mi.length; i++) {
			if(mi[i].type == Menu_Model.MenuType.ITEM) {
				GroupList.add(mi[i]);			

				y++;
			}
			ItemPanel.add(mi[i]);
			
		
		}
	}
   
	
	private void setItems() {
		mi[0] = new MenuItem(new Menu_Model("StudentData","Student Data", Menu_Model.MenuType.ITEM));
		mi[1] = new MenuItem(new Menu_Model("Template","Templates", Menu_Model.MenuType.ITEM));
		mi[2] = new MenuItem(new Menu_Model("Compose","Compose", Menu_Model.MenuType.ITEM));
		
		mi[3] = new MenuItem(new Menu_Model("","", Menu_Model.MenuType.BLANK));
		mi[4] = new MenuItem(new Menu_Model("","Settings", Menu_Model.MenuType.TITLE));
		
		mi[5] = new MenuItem(new Menu_Model("Profile","Profile", Menu_Model.MenuType.ITEM));
		mi[6] = new MenuItem(new Menu_Model("Settings","General", Menu_Model.MenuType.ITEM));
		mi[7] = new MenuItem(new Menu_Model("Logout","Logout", Menu_Model.MenuType.ITEM));
		
		mi[8] = new MenuItem(new Menu_Model("","", Menu_Model.MenuType.BLANK));
		mi[9] = new MenuItem(new Menu_Model("","", Menu_Model.MenuType.BLANK));
		mi[10] = new MenuItem(new Menu_Model("","", Menu_Model.MenuType.BLANK));
		
		setActionEvent(mi[0], 0);
		setActionEvent(mi[1], 1);
		setActionEvent(mi[2], 2);
		setActionEvent(mi[5], 3);
		setActionEvent(mi[6], 4);
		setActionEvent(mi[7], 5);
	}
	

	public SquircleComponent getContentPane() {
		return contentPane;
	}
	
	public JPanel getItemPanel() {
		return ItemPanel;
	}
	
	private void setActionEvent(MenuItem Item, int Index) {
	    Item.addActionListener(new ActionListener()  {
		@Override
		public void actionPerformed(ActionEvent e) {
			ReferencePage.setSelectedIndex(Index);
			
		}
	});
	}
}
