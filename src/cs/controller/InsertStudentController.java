package cs.controller;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;

import cs.components.CTable;
import cs.db.ConnectionDB;
import cs.model.StudentDataModel;

public class InsertStudentController implements MouseInputListener {
    private JLabel insertLbl = new JLabel();
    private JTextField txtFName = new JTextField();
    private JTextField txtLName = new JTextField();
    private JTextField txtSection = new JTextField();
    private JTextField txtCourse = new JTextField();
    private JTextField txtYear = new JTextField();
    private JTextField txtEmail = new JTextField();
    private CTable model;
    StudentDataModel sdm = new StudentDataModel();

    public InsertStudentController(JLabel insertLbl, JTextField txtFName, JTextField txtLName, JTextField txtSection,
            JTextField txtCourse,
            JTextField txtYear,
            JTextField txtEmail, CTable table) {
        super();
        this.txtFName = txtFName;
        this.txtLName = txtLName;
        this.txtSection = txtSection;
        this.txtCourse = txtCourse;
        this.txtYear = txtYear;
        this.txtEmail = txtEmail;
        this.insertLbl = insertLbl;
        this.model = table;
    }
    // For checking fields empty or not
    public boolean emptyFields() {
        if (txtFName.getText().isEmpty()) {
            return false;
        }
        if (txtLName.getText().isEmpty()) {
            return false;
        }
        if (txtSection.getText().isEmpty()) {
            return false;
        }
        if (txtCourse.getText().isEmpty()) {
            return false;
        }
        if (txtYear.getText().isEmpty()) {
            return false;
        }
        if (txtEmail.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        // Checking if fields is empty
        if (emptyFields()) {
            try {
                // Getting the text in fields
                sdm.setTxtFName(txtFName.getText());
                sdm.setTxtLName(txtLName.getText());
                sdm.setTxtEmail(txtEmail.getText());
                sdm.setTxtCourse(txtCourse.getText());
                sdm.setTxtSection(txtSection.getText());
                sdm.setTxtYear(txtYear.getText());
                // Getting connection to db and inserting data to database and table model
                ConnectionDB db = new ConnectionDB();
                Connection cn = db.getConnection();
                String query = "INSERT INTO STUDENTS_DBS VALUES (default, ?, ?, ?, ?, ?, ?)";
                PreparedStatement st = cn.prepareStatement(query);
                st.setString(1, sdm.getTxtFName());
                st.setString(2, sdm.getTxtLName());
                st.setString(3, sdm.gettxtEmail());
                st.setString(4, sdm.getTxtCourse());
                st.setString(5, sdm.getTxtSection());
                st.setString(6, sdm.getTxtYear());
                st.execute();
                model.addRow(new Object[] { sdm.getTxtFName(), sdm.getTxtLName(), sdm.gettxtEmail(), sdm.getTxtCourse(),
                        sdm.getTxtSection(), sdm.getTxtYear()});

                String query2 = "SELECT MAX(STUDID) FROM STUDENTS_DBS;";
                PreparedStatement st2 = cn.prepareStatement(query2);
                ResultSet rs2 = st2.executeQuery();
                if(rs2.next()){
                    sdm.addID(rs2.getInt(1));
                }
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Database error: " + err);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Empty Fields!");
        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
