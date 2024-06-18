package controller.action;

import controller.AbstractRudokAction;
import view.dialog.EditTextSlotDialog;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.event.ActionEvent;

public class ItalicAction extends AbstractRudokAction {
    JDialog dialog;

    public ItalicAction(){
        //putValue(SMALL_ICON, loadIcon("images/delete.png"));
        putValue(NAME, "Italic");
        putValue(SHORT_DESCRIPTION, "Italic");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setItalic(attributeSet,true);
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
