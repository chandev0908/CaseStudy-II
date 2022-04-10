package cs.pages;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cs.components.CScrollBar;
import cs.components.CTable;
import cs.components.ImageManager;
import cs.components.Page;

import javax.swing.JPanel;

public class StudentData extends Page{
	private CTable table;
	
	@SuppressWarnings("serial")
	public StudentData() {
		ImageManager IM = new ImageManager();
		setOpaque(false);
		


		
		table = new CTable();
		table.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "Name", "Email", "Year", "Section", "Status"
	            }
	        ) {
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
		setTableData();
		table.setOpaque(false);
		
		
		scrollPane.setBounds(31, 203, 850, 335);
		scrollPane.setVerticalScrollBar(new CScrollBar());
		scrollPane.setHorizontalScrollBar(new CScrollBar());
		scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(new Color(0,0,0,0));
		scrollPanel.setLayout(null);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setViewportView(table);
		
		
		JTextField searchField = new JTextField();
		searchField.setForeground(Color.WHITE);
		searchField.setBackground(Color.decode("#212d3a"));
		searchField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		searchField.setColumns(10);
		searchField.setBorder(new EmptyBorder(0, 0, 0, 0));
		searchField.setBounds(55, 5, 257, 24);
		headerPane.add(searchField);
		
		JLabel searchImg = new JLabel();
		
		searchImg.setBounds(10, 0, 35, 35);
		searchImg.setIcon(IM.rescaleImage(25, 25, "Search"));
		headerPane.add(searchImg);
		
		JLabel lblName = new JLabel();
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setForeground(Color.WHITE);
		lblName.setText("Name:");
		lblName.setBounds(31, 11, 75, 35);
		scrollPanel.add(lblName);
		
		JTextField txtName = new JTextField();
		txtName.setForeground(Color.WHITE);
		txtName.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtName.setBackground(new Color(33, 45, 58));
		txtName.setBounds(116, 19, 257, 24);
		scrollPanel.add(txtName);
		
		JLabel lblSection = new JLabel();
		lblSection.setText("Section:");
		lblSection.setForeground(Color.WHITE);
		lblSection.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSection.setBounds(31, 54, 75, 35);
		scrollPanel.add(lblSection);
		
		JTextField txtSection = new JTextField();
		txtSection.setForeground(Color.WHITE);
		txtSection.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSection.setColumns(10);
		txtSection.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtSection.setBackground(new Color(33, 45, 58));
		txtSection.setBounds(116, 62, 257, 24);
		scrollPanel.add(txtSection);
		
		JLabel lblYear = new JLabel();
		lblYear.setText("Year:");
		lblYear.setForeground(Color.WHITE);
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYear.setBounds(419, 15, 75, 35);
		scrollPanel.add(lblYear);
		
		JTextField txtYear = new JTextField();
		txtYear.setForeground(Color.WHITE);
		txtYear.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtYear.setColumns(10);
		txtYear.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtYear.setBackground(new Color(33, 45, 58));
		txtYear.setBounds(504, 23, 257, 24);
		scrollPanel.add(txtYear);
		
		JLabel lblEmail = new JLabel();
		lblEmail.setText("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(419, 58, 75, 35);
		scrollPanel.add(lblEmail);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtEmail.setBackground(new Color(33, 45, 58));
		txtEmail.setBounds(504, 66, 257, 24);
		scrollPanel.add(txtEmail);
		
		JLabel lblDelete = new JLabel();
		lblDelete.setText("Delete");
		lblDelete.setForeground(Color.WHITE);
		lblDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDelete.setBounds(34, 143, 75, 35);
		scrollPanel.add(lblDelete);
		
		JLabel lblInsert = new JLabel();
		lblInsert.setText("Insert");
		lblInsert.setForeground(Color.WHITE);
		lblInsert.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInsert.setBounds(139, 143, 75, 35);
		scrollPanel.add(lblInsert);
		
		JLabel lblUpdate = new JLabel();
		lblUpdate.setText("Update");
		lblUpdate.setForeground(Color.WHITE);
		lblUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUpdate.setBounds(250, 143, 75, 35);
		scrollPanel.add(lblUpdate);
		
		JLabel lblSave = new JLabel();
		lblSave.setText("Save");
		lblSave.setForeground(Color.WHITE);
		lblSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSave.setBounds(372, 143, 75, 35);
		scrollPanel.add(lblSave);
		
		JLabel lblExport = new JLabel();
		lblExport.setText("Export");
		lblExport.setForeground(Color.WHITE);
		lblExport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExport.setBounds(485, 143, 75, 35);
		scrollPanel.add(lblExport);
		
		JLabel lblRefresh = new JLabel();
		lblRefresh.setText("Refresh");
		lblRefresh.setForeground(Color.WHITE);
		lblRefresh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRefresh.setBounds(709, 143, 75, 35);
		scrollPanel.add(lblRefresh);
		
		JLabel lblEdit = new JLabel();
		lblEdit.setText("Edit");
		lblEdit.setForeground(Color.WHITE);
		lblEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEdit.setBounds(825, 143, 75, 35);
		scrollPanel.add(lblEdit);
		
		JLabel lblImport = new JLabel();
		lblImport.setText("Import");
		lblImport.setForeground(Color.WHITE);
		lblImport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblImport.setBounds(600, 143, 75, 35);
		scrollPanel.add(lblImport);
		
		scrollPanel.add(scrollPane);
		
		}
	
	
	private void setTableData() {
        table.addRow(new Object[]{"Kawamoto Momo", "cuteloli@gmail.com", "2nd Year", "BSCS-2A", CTable.StatusType.SENT});
        table.addRow(new Object[]{"Tanya Degurechaff", "cuteloli@gmail.com", "2nd Year", "BSCS-2A", CTable.StatusType.SENT});
        table.addRow(new Object[]{"Sohma Kisa", "cuteloli@gmail.com", "2nd Year", "BSCS-2A", CTable.StatusType.SENT});
        table.addRow(new Object[]{"Inuzuka Tsumugi", "cuteloli@gmail.com", "2nd Year", "BSCS-2A", CTable.StatusType.SENT});
        table.addRow(new Object[]{"Miyauchi Renge", "cuteloli@gmail.com", "2nd Year", "BSCS-2A", CTable.StatusType.SENT});
        table.addRow(new Object[]{"Mihama Chiyo", "cuteloli@gmail.com", "2nd Year", "BSCS-2A", CTable.StatusType.SENT});
        table.addRow(new Object[]{"Suika", "cuteloli@gmail.com", "2nd Year", "BSCS-2A", CTable.StatusType.SENT});
        table.addRow(new Object[]{"Chaika Trabant", "cuteloli@gmail.com", "2nd Year", "BSCS-2A", CTable.StatusType.PENDING});
        table.addRow(new Object[]{"Kanna Kamui", "cuteloli@gmail.com", "2nd Year", "BSCS-2A", CTable.StatusType.PENDING});
        table.addRow(new Object[]{"Rory Mercury", "cuteloli@gmail.com", "2nd Year", "BSCS-2A", CTable.StatusType.PENDING});
        table.addRow(new Object[]{"Shinobu Oshino", "cuteloli@gmail.com", "2nd Year", "BSCS-2A", CTable.StatusType.PENDING});
        table.addRow(new Object[]{"Homura Akemi", "cuteloli@gmail.com", "2nd Year", "BSCS-2A", CTable.StatusType.FAILED});
        table.addRow(new Object[]{"Konata Izumi", "cuteloli@gmail.com", "2nd Year", "BSCS-2A", CTable.StatusType.FAILED});
        table.addRow(new Object[]{"Yui Hirasawa", "cuteloli@gmail.com", "2nd Year", "BSCS-2A", CTable.StatusType.FAILED});
	}

}


