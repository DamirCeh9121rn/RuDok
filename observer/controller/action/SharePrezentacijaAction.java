package controller.action;

import controller.AbstractRudokAction;
import model.Prezentacija;
import model.RuNode;
import view.MainFrame;
import view.dialog.PrezentacijaShareDialog;
import view.treeMVC.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SharePrezentacijaAction extends AbstractRudokAction {

    private RuNode selektovanaPrez;
    private MyTreeNode workspase;
    public SharePrezentacijaAction(){
        putValue(SMALL_ICON, loadIcon("images/share.png"));
        putValue(NAME, "Share_Prezentacija");
        putValue(SHORT_DESCRIPTION, "Share_Prezentacija");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(MainFrame.getInstance().getMyTree().getSelectionPath().getLastPathComponent() instanceof MyTreeNode){
            MyTreeNode node = (MyTreeNode) MainFrame.getInstance().getMyTree().getSelectionPath().getLastPathComponent();
            workspase = (MyTreeNode) node.getParent().getParent();
            if(node.getNode() instanceof Prezentacija){
                selektovanaPrez = node.getNode();
            }
        }

        PrezentacijaShareDialog prezentacijaShareDialog = new PrezentacijaShareDialog(selektovanaPrez, workspase);
        prezentacijaShareDialog.setVisible(true);
    }
}
