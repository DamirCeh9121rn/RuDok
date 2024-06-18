package commands;

import model.RuNode;
import model.RuNodeComposite;
import view.MainFrame;
import view.treeMVC.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;

public class DeleteNodeCommand extends AbstractCommand{

    private MyTreeNode myTreeNode;
    private TreePath path;
    private RuNode ruNode;
    private MyTreeNode peretnTreeNode;
    private RuNode peretn;

    private List<RuNode> kopije;

    public DeleteNodeCommand(MyTreeNode myTreeNode, TreePath path, RuNode ruNode){
        this.myTreeNode = myTreeNode;
        this.path = path;
        this.ruNode = ruNode;
        this.peretn = ruNode.getParent();
        this.peretnTreeNode = (MyTreeNode) myTreeNode.getParent();
        kopije = new ArrayList<>();
    }

    @Override
    public void doCommand() {
        if(ruNode instanceof RuNodeComposite){
            kopije.addAll(((RuNodeComposite) ruNode).getRuNodeList());

            myTreeNode.removeFromParent();
            ((RuNodeComposite) peretn).removeNode(ruNode);
            ((RuNodeComposite) ruNode).getRuNodeList().clear();

            MainFrame.getInstance().getMyTree().expandPath(path);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }else{
            myTreeNode.removeFromParent();
            ((RuNodeComposite) peretn).removeNode(ruNode);

            MainFrame.getInstance().getMyTree().expandPath(path);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }
    }

    @Override
    public void undoCommand() {
        ((RuNodeComposite) peretn).addNode(ruNode);
        peretnTreeNode.add(myTreeNode);

        if(ruNode instanceof RuNodeComposite){
            for (RuNode r: kopije) {
                ((RuNodeComposite) ruNode).addNode(r);
            }
        }

        MainFrame.getInstance().repaint();
        MainFrame.getInstance().getMyTree().expandPath(path);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }
}
