package controller.action;

import controller.AbstractRudokAction;
import error.MyError;
import error.MyErrorFactory;
import model.Prezentacija;
import view.dialog.EditDialog;
import view.MainFrame;
import view.treeMVC.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditAction extends AbstractRudokAction {

    private EditDialog editDialog;
    MyError error;

    public EditAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/edit.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object o = MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();

        if(o == null || !(((MyTreeNode) o).getNode() instanceof Prezentacija)){
            error = new MyError(this, 1, "Morate selektovati prezentaciju");
            MyErrorFactory.getInstance().generateError(error);
            return;
        }

        MyTreeNode myTreeNode = null;

        if(o instanceof MyTreeNode)
            myTreeNode = (MyTreeNode) o;

        if(myTreeNode.getNode() instanceof Prezentacija){
            editDialog = new EditDialog((Prezentacija) myTreeNode.getNode());
            editDialog.setVisible(true);
        }


    }
}
