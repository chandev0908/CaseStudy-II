package cs.controller;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;

import cs.components.CTable;
import cs.components.PrintPdf;

public class ExportStudentController implements MouseInputListener{
    private JLabel exportLbl;
    private CTable model;
    public String pdfFileName = "";
    PrintPdf exprtPdf = new PrintPdf();
    public ExportStudentController(JLabel exportLbl, CTable table) {
        super();
        this.exportLbl = exportLbl;
        this.model = table;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        if (pdfFileName.equals("")) {
            pdfFileName = JOptionPane.showInputDialog(null, "Input the pdf file name",
                    "INPUT THE FILE NAME FIRST!", JOptionPane.WARNING_MESSAGE);
            if (pdfFileName == null) {
                pdfFileName = "";
            }
        } else {
            exprtPdf.exportThisPdf(pdfFileName);
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
