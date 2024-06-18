package commands;

import model.RuNode;
import view.MainFrame;
import view.treeMVC.model.MyTreeNode;

import javax.swing.*;

public class RenameNodeCommand extends AbstractCommand{

    private RuNode node;
    private MyTreeNode myTreeNode;
    private String ime;
    private String staroIme;

    public RenameNodeCommand(RuNode node, MyTreeNode myTreeNode, String ime){
        this.node = node;
        this.myTreeNode = myTreeNode;
        this.ime = ime;
    }

    @Override
    public void doCommand() {
        staroIme = node.getName();
        node.setName(ime);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }

    @Override
    public void undoCommand() {
        node.setName(staroIme);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }
}
