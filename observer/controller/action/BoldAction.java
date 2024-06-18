package controller.action;

import controller.AbstractRudokAction;
import view.dialog.EditTextSlotDialog;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BoldAction extends AbstractRudokAction {
    private JDialog dialog;
    public BoldAction(){
        //putValue(SMALL_ICON, loadIcon("images/delete.png"));
        putValue(NAME, "Bold");
        putValue(SHORT_DESCRIPTION, "Bold");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setBold(attributeSet,true);
        ((EditTextSlotDialog) dialog).getTextPane().setCharacterAttributes(attributeSet, true);

        /*Document doc = ((EditTextSlotDialog) dialog).getTextPane().getStyledDocument();

        try {
            doc.insertString(doc.getLength(), ((EditTextSlotDialog) dialog).getTextPane().getSelectedText(),attributeSet);
        }catch(BadLocationException u) {
            u.printStackTrace();
        }*/
    }

    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }
}
