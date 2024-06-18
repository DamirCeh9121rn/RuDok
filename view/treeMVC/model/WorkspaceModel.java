package view.treeMVC.model;



import model.Projekat;
import model.WorkSpace;
import view.MainFrame;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class WorkspaceModel extends DefaultTreeModel {

    public WorkspaceModel(TreeNode root) {
        super(MainFrame.getInstance().getWorkspaceNode());
    }


}
