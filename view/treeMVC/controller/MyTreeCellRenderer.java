package view.treeMVC.controller;

import model.Prezentacija;
import model.Projekat;
import model.Slajd;
import model.WorkSpace;
import view.treeMVC.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;

import java.awt.*;
import java.net.URL;

public class MyTreeCellRenderer extends DefaultTreeCellRenderer{

    public MyTreeCellRenderer(){

    }

    public Component getTreeCellRendererComponent(
            JTree tree,
            Object value,
            boolean sel,
            boolean expanded,
            boolean leaf,
            int row,
            boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);

        if(value instanceof MyTreeNode) {
            if (((MyTreeNode) value).getNode() instanceof Prezentacija) {
                URL imageURL = getClass().getResource("images/prezentacija.png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);

            } else if (((MyTreeNode) value).getNode() instanceof Projekat) {
                URL imageURL = getClass().getResource("images/projekat.png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);

            } else if (((MyTreeNode) value).getNode() instanceof Slajd) {
                URL imageURL = getClass().getResource("images/slajd.png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);
            } else if (((MyTreeNode) value).getNode() instanceof WorkSpace) {
                URL imageURL = getClass().getResource("images/workspace.png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);
            }
        }

        return this;
    }

}
