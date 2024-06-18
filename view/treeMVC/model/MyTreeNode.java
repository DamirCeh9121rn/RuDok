package view.treeMVC.model;

import model.RuNode;
import model.RuNodeComposite;
import model.Slajd;


import javax.swing.tree.DefaultMutableTreeNode;

public class MyTreeNode extends DefaultMutableTreeNode {

    private RuNode node;


    public MyTreeNode(RuNode ruNode){
        this.node = ruNode;
    }

    @Override
    public String toString() {
        return node.toString();
    }

    public RuNode getNode() {
        return node;
    }


}

