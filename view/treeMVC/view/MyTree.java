package view.treeMVC.view;

import view.treeMVC.controller.MyMouseListener;
import view.treeMVC.controller.MyTreeCellEditor;
import view.treeMVC.controller.MyTreeCellRenderer;
import view.treeMVC.controller.MyTreeSelectionListener;


import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;

public class MyTree extends JTree {

    public MyTree(){
        addTreeSelectionListener(new MyTreeSelectionListener());
        setCellEditor(new MyTreeCellEditor(this,new DefaultTreeCellRenderer()));
        setCellRenderer(new MyTreeCellRenderer());
        setEditable(true);
        addMouseListener(new MyMouseListener());
    }



}
