package controller.action;

import commands.DeleteNodeCommand;
import controller.AbstractRudokAction;
import error.MyError;
import error.MyErrorFactory;
import model.RuNodeComposite;
import model.WorkSpace;
import view.MainFrame;
import view.treeMVC.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends AbstractRudokAction {

    MyError error;

    public DeleteAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TreePath path = ((JTree) MainFrame.getInstance().getMyTree()).getSelectionPath();

        MyTreeNode myTreeNode = (MyTreeNode)path.getLastPathComponent();

        if(myTreeNode.getNode() instanceof WorkSpace){
           error = new MyError(this, 1, "Nije moguce obrisati Worspace");
            MyErrorFactory.getInstance().generateError(error);
        }else{
            MainFrame.getInstance().getCommandManager().addCommand(new DeleteNodeCommand(myTreeNode, path, myTreeNode.getNode()));

            /*if(myTreeNode.getNode() instanceof RuNodeComposite){

                TreeNode p = myTreeNode.getParent();
                MyTreeNode parent;
                if(p instanceof MyTreeNode) {
                    parent = (MyTreeNode) p;
                    if(((RuNodeComposite) parent.getNode()).getRuNodeList().contains(myTreeNode.getNode())){
                        ((RuNodeComposite) parent.getNode()).removeNode(myTreeNode.getNode());
                    }
                }

                ((RuNodeComposite) myTreeNode.getNode()).getRuNodeList().clear();
                myTreeNode.removeFromParent();


                MainFrame.getInstance().getMyTree().expandPath(path);
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
            }else{
                TreeNode p = myTreeNode.getParent();
                MyTreeNode parent;
                if(p instanceof MyTreeNode) {
                    parent = (MyTreeNode) p;
                    if(((RuNodeComposite) parent.getNode()).getRuNodeList().contains(myTreeNode.getNode())){
                        ((RuNodeComposite) parent.getNode()).removeNode(myTreeNode.getNode());
                    }
                }

                myTreeNode.removeFromParent();

                MainFrame.getInstance().getMyTree().expandPath(path);
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
            }*/
        }


    }
}
