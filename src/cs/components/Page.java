package cs.components;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class Page extends JPanel {
	Dimension minSize = new Dimension(1300,800);
	/**
	 * Create the panel.
	 */

	
	protected String foreground = "#0b1017";
	protected JPanel headerPane,  scrollPanel;
	protected JScrollPane scrollPane;





	public Page() {
		
		setBackground(new Color(0,0,0,0));
		setOpaque(false);
		setMinimumSize(minSize);
		
	
		headerPane = new JPanel();
		headerPane.setOpaque(false);
		

		scrollPane = new JScrollPane();
		scrollPanel =new JPanel();
		scrollPanel.setBackground(Color.decode(foreground));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(headerPane, GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
							.addGap(1))
						.addComponent(scrollPanel, GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE))
					.addGap(12))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(headerPane, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(scrollPanel, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
					.addGap(10))
		);
		
		
		scrollPane.setBounds(58, 170,840,373);
		scrollPane.setVerticalScrollBar(new CScrollBar());
		scrollPane.setHorizontalScrollBar(new CScrollBar());
		scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(new Color(0,0,0,0));
		scrollPanel.setLayout(null);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		headerPane.setLayout(null);
		
		
		
		

		
		
		setLayout(groupLayout);
		
		

	}
}
	

