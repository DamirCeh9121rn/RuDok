package view.treeMVC.controller;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class MyTreeSelectionListener implements TreeSelectionListener {

    public void valueChanged(TreeSelectionEvent e) {

        TreePath path = e.getPath();

    }
}
