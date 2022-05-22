package cs.pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cs.components.CScrollBar;
import cs.components.CTable;
import cs.components.ImageManager;
import cs.components.Page;
import cs.controller.DeleteStudentController;
import cs.controller.EditStudentController;
import cs.controller.ExportStudentController;
import cs.controller.InsertStudentController;
import cs.db.ConnectionDB;
import cs.model.StudentDataModel;

public class StudentData extends Page {
	private CTable table;
	StudentDataModel sdm = new StudentDataModel();

	@SuppressWarnings("serial")
	public StudentData() {
		ImageManager IM = new ImageManager();
		setOpaque(false);

		table = new CTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {

				},
				new String[] {
						"First Name", "Last Name", "Email", "Course", "Section", "Year", "Status"
				}) {
			boolean[] canEdit = new boolean[] {
					true, true, true, true, true, true, false
			};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		setTableData();
		table.setOpaque(false);

		scrollPane.setBounds(31, 203, 850, 335);
		scrollPane.setVerticalScrollBar(new CScrollBar());
		scrollPane.setHorizontalScrollBar(new CScrollBar());
		scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(new Color(0, 0, 0, 0));
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

		JLabel lblFName = new JLabel();
		lblFName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFName.setForeground(Color.WHITE);
		lblFName.setText("First Name");
		lblFName.setBounds(31, 11, 75, 35);
		scrollPanel.add(lblFName);

		JTextField txtFName = new JTextField();
		txtFName.setForeground(Color.WHITE);
		txtFName.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtFName.setColumns(10);
		txtFName.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtFName.setBackground(new Color(33, 45, 58));
		txtFName.setBounds(116, 19, 257, 24);
		scrollPanel.add(txtFName);

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
		lblYear.setBounds(405, 57, 75, 35);
		scrollPanel.add(lblYear);

		JTextField txtYear = new JTextField();
		txtYear.setForeground(Color.WHITE);
		txtYear.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtYear.setColumns(10);
		txtYear.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtYear.setBackground(new Color(33, 45, 58));
		txtYear.setBounds(490, 65, 257, 24);
		scrollPanel.add(txtYear);

		JLabel lblEmail = new JLabel();
		lblEmail.setText("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(405, 100, 75, 35);
		scrollPanel.add(lblEmail);

		JTextField txtEmail = new JTextField();
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtEmail.setBackground(new Color(33, 45, 58));
		txtEmail.setBounds(490, 108, 257, 24);
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

		JLabel lblCourse = new JLabel();
		lblCourse.setText("Course:");
		lblCourse.setForeground(Color.WHITE);
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCourse.setBounds(31, 100, 75, 35);
		scrollPanel.add(lblCourse);

		JTextField txtCourse = new JTextField();
		txtCourse.setForeground(Color.WHITE);
		txtCourse.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtCourse.setColumns(10);
		txtCourse.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCourse.setBackground(new Color(33, 45, 58));
		txtCourse.setBounds(116, 108, 257, 24);
		scrollPanel.add(txtCourse);

		JTextField txtLName = new JTextField();
		txtLName.setForeground(Color.WHITE);
		txtLName.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtLName.setColumns(10);
		txtLName.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtLName.setBackground(new Color(33, 45, 58));
		txtLName.setBounds(490, 19, 257, 24);
		scrollPanel.add(txtLName);

		JLabel lblName = new JLabel();
		lblName.setText("Last Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(405, 11, 75, 35);
		scrollPanel.add(lblName);
		InsertStudentController insertController = new InsertStudentController(lblInsert, txtFName, txtLName,
				txtSection, txtCourse, txtYear, txtEmail, table);
		lblInsert.addMouseListener(insertController);
		DeleteStudentController deleteController = new DeleteStudentController(lblDelete, table);
		lblDelete.addMouseListener(deleteController);
		EditStudentController editController = new EditStudentController(lblEdit, table);
		lblEdit.addMouseListener(editController);
		ExportStudentController exportController = new ExportStudentController(lblExport, table);
		lblExport.addMouseListener(exportController);
	}

	private void setTableData() {
		ConnectionDB db = new ConnectionDB();
		try {
			Connection cn = db.getConnection();
			String query = "SELECT * FROM students_dbs";
			PreparedStatement st = cn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			int count = 0;
			while (rs.next()) {
				count++;
				sdm.addID(rs.getInt("studid"));
				System.out.println("array: " + rs.getInt("studid"));
				table.addRow(new Object[] { rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"),
						rs.getString("course"), rs.getString("section"), rs.getString("year"),
						CTable.StatusType.PENDING });
			}
		} catch (Exception err) {
			System.out.println(err);
		}
	}
}
