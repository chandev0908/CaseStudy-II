package cs.controller;

import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.EventListener;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

import cs.components.CTable;
import cs.db.ConnectionDB;
import cs.model.StudentDataModel;

public class EditStudentController implements MouseInputListener {

    private JLabel editLbl = new JLabel();
    private CTable model;
    StudentDataModel sdm = new StudentDataModel();

    public EditStudentController(JLabel editLbl, CTable table) {
        super();
        this.editLbl = editLbl;
        this.model = table;
    }

    public String queryCondition(String query) {
        switch (model.getSelectedColumn()) {
            case 0:
                return "UPDATE students_dbs SET FIRSTNAME='" + query + "' WHERE STUDID= "
                        + sdm.getID(model.getSelectedRow());
            case 1:
                return "UPDATE students_dbs SET LASTNAME='" + query + "' WHERE STUDID= "
                        + sdm.getID(model.getSelectedRow());
            case 2:
                return "UPDATE students_dbs SET EMAIL='" + query + "' WHERE STUDID= "
                        + sdm.getID(model.getSelectedRow());
            case 3:
                return "UPDATE students_dbs SET COURSE='" + query + "' WHERE STUDID= "
                        + sdm.getID(model.getSelectedRow());
            case 4:
                return "UPDATE students_dbs SET SECTION='" + query + "' WHERE STUDID= "
                        + sdm.getID(model.getSelectedRow());
            case 5:
                return "UPDATE students_dbs SET `YEAR`='" + query + "' WHERE STUDID= "
                        + sdm.getID(model.getSelectedRow());
            default:
                return null;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        ConnectionDB db = new ConnectionDB();
        Connection cn = db.getConnection();
        System.out.println(model.getSelectedColumn());
        switch (model.getSelectedRow()) {
            case -1:
                JOptionPane.showMessageDialog(null, "You need to click what row you want to edit first!");
                break;
            default:
                // System.out.println(model.isCellEditable(model.getSelectedRow(),
                // model.getSelectedColumn()));
                if (model.getCellEditor() == null) {
                    model.editCellAt(model.getSelectedRow(), model.getSelectedColumn());
                } else {
                    model.getCellEditor().stopCellEditing();
                    try {
                        PreparedStatement st = cn.prepareStatement(queryCondition(
                                model.getValueAt(model.getSelectedRow(), model.getSelectedColumn()).toString()));
                        if (!st.execute()) {
                            JOptionPane.showMessageDialog(null, "Successfully Edited");
                        } else {
                            System.out.println("Error not edited!");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error editing: " + ex);
                    }
                }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
