package cs.components;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import cs.db.ConnectionDB;

public class PrintPdf {
    public static void exportThisPdf(String pdfFileName) {
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        j.setSelectedFile(new File(".pdf"));
        int x = j.showSaveDialog(j);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
        if (x == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Canceled");
            return;
        }
        Document docsx = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(docsx, new FileOutputStream("" + path + "\\" +
            pdfFileName + ".pdf"));
            docsx.open();

            PdfPTable tbl = new PdfPTable(6);
            tbl.setTotalWidth(PageSize.A4.getWidth());
            tbl.setLockedWidth(true);

            tbl.addCell("First Name");
            tbl.addCell("Last Name");
            tbl.addCell("Email");
            tbl.addCell("Course");
            tbl.addCell("Section");
            tbl.addCell("Year");

            ConnectionDB db = new ConnectionDB();
            try {
                Connection cn = db.getConnection();
                String query = "SELECT * FROM students_dbs";
                PreparedStatement st = cn.prepareStatement(query);
                ResultSet rs = st.executeQuery();
                int count = 0;
                while (rs.next()) {
                    count++;
                    tbl.addCell(rs.getString("firstname"));
                    tbl.addCell(rs.getString("lastname"));
                    tbl.addCell(rs.getString("email"));
                    tbl.addCell(rs.getString("course"));
                    tbl.addCell(rs.getString("section"));
                    tbl.addCell(rs.getString("year"));
                }
            } catch (Exception err) {
                System.out.println(err);
            }

            docsx.add(tbl);
            docsx.close();
            JOptionPane.showMessageDialog(null, "PDF File Created", "Sucess!", JOptionPane.PLAIN_MESSAGE);
        } catch (DocumentException asd) {
            JOptionPane.showMessageDialog(null, "Error: " + asd);
        } catch (ExceptionConverter sda) {
            JOptionPane.showMessageDialog(null, "Error: " + sda);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
