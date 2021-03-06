package cs.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CTable extends JTable {

	//Inner Status enum
	public enum StatusType {
		SENT("#05371D","#5EEB12"), 
		PENDING("#373305","#E2EB12"), 
		FAILED("#370510", "#EB1212");
		
		final String[] hexGradient = new String[2];
		
		StatusType(String hexOne, String hexTwo){
			hexGradient[0] = hexOne;
			hexGradient[1] = hexTwo;
		}
	}
	
	//Inner Component Class for Status 
	private class StatusPanel extends SquircleComponent{
		StatusPanel(StatusType status){
			setLayout(new BorderLayout());
			JLabel lblStatus = new JLabel(status.toString(),SwingConstants.CENTER);
			lblStatus.setFont(new Font("sansserif", 1, 12));
			lblStatus.setForeground(Color.WHITE);
			add(lblStatus, BorderLayout.CENTER);
			setGradient(status.hexGradient[0], status.hexGradient[1]);
		}
		
	}
	//Inner Component Class for TableHeader
	private class TableHeader extends JLabel {

		String hex_one = "#955982", hex_two = "#557e99";
		
	    public TableHeader(String text) {
	        super(text);
	        setOpaque(true);
	        setBackground(Color.WHITE);
	        setFont(new Font("sansserif", 1, 12));
	        setForeground(new Color(102, 102, 102));
	        setBorder(new EmptyBorder(10, 5, 10, 5));
	    }

	    @Override
	    protected void paintComponent(Graphics grphcs) {
	        super.paintComponent(grphcs);
	        GradientPaint paint = new GradientPaint(0, 0, Color.decode(hex_one), 0, getHeight(), Color.decode(hex_two));
	        grphcs.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
	    }
	}
	
	//Main Constructor
    public CTable() {
    	final DefaultTableCellRenderer ItemCellRenderer =	new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (column != 4) {
                    Component com = super.getTableCellRendererComponent(jtable, value, isSelected, hasFocus, row, column);
                    com.setBackground(Color.WHITE);
                    setBorder(noFocusBorder);
                    if (isSelected) {
                        com.setForeground(new Color(15, 89, 140));
                    } else {
                        com.setForeground(new Color(102, 102, 102));
                    }
                    return com;
                } else {
                    StatusType type = (StatusType) value;
                    StatusPanel status = new StatusPanel(type);
                    return status;
                }
            }
        };
        
        final DefaultTableCellRenderer HeaderCellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(value + "");
                //This eludes to the last 
                if (column == 4) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        };
    	
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(HeaderCellRenderer);
        setDefaultRenderer(Object.class, ItemCellRenderer);
        		
        		

    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
}
