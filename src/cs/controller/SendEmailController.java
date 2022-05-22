package cs.controller;

import java.awt.event.MouseEvent;

import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;

import com.itextpdf.text.pdf.qrcode.Mode;

import cs.components.CTable;
import cs.templates.FirstTemplate;

public class SendEmailController implements MouseInputListener {
    private JEditorPane txtCompose;
    private JTextField txtSubj, txtRecipient;

    public SendEmailController(JEditorPane txtCompose, JTextField txtSubj, JTextField txtRecipient) {
        super();
        this.txtCompose = txtCompose;
        this.txtSubj = txtSubj;
        this.txtRecipient = txtRecipient;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        FirstTemplate ft = new FirstTemplate();
        ft.sendMail(txtSubj.getText().toString(), txtCompose.getText().toString(), txtRecipient.getText().toString());
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
