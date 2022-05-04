package cs.controller;

import java.awt.event.MouseEvent;
import java.sql.*;

import javax.swing.*;
import javax.swing.event.*;

import cs.components.CTable;
import cs.db.ConnectionDB;
import cs.model.StudentDataModel;

public class DeleteStudentController implements MouseInputListener {
    private JLabel deleteLbl = new JLabel();
    private CTable model;
    StudentDataModel sdm = new StudentDataModel();

    public DeleteStudentController(JLabel deleteLbl, CTable table) {
        super();
        this.deleteLbl = deleteLbl;
        this.model = table;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        // switch (model.getSelectedRow()) {
        //     case -1:
        //         JOptionPane.showMessageDialog(null, "You need to click what row you want to delete first!");
        //         break;
        //     default:
        //         ConnectionDB db = new ConnectionDB();
        //         Connection cn = db.getConnection();
        //         String query = "DELETE FROM students_dbs WHERE studid = ?;";
        //         try {
        //             PreparedStatement st = cn.prepareStatement(query);
        //             st.setInt(1, sdm.getID(model.getSelectedRow()));
        //             if (!st.execute()) {
        //                 System.out.println("Deleted!");
                        model.removeRow(model.getSelectedRow());
                //     } else {
                //         System.out.println("Error not deleted!");
                //     }
                // } catch (Exception ex) {
                //     JOptionPane.showMessageDialog(null, "Error: " + ex);
                // }
        // }
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
