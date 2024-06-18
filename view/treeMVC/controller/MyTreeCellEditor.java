package view.treeMVC.controller;

import commands.RenameNodeCommand;
import error.MyError;
import error.MyErrorFactory;
import model.Prezentacija;
import model.Projekat;
import model.Slajd;
import view.MainFrame;
import view.treeMVC.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class MyTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object stavka=null;
    private JTextField edit=null;
    private MyError error;

    public MyTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
        super.getTreeCellEditorComponent(arg0,arg1,arg2,arg3,arg4,arg5);
        stavka=arg1;

        edit=new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }



    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent)
            if (((MouseEvent)arg0).getClickCount()==3){
                return true;
            }
        return false;
    }



    public void actionPerformed(ActionEvent e){

        if(e.getActionCommand().equals("")){
            error = new MyError(this, 1, "Nije moguce ostaviti prazno ime");
            MyErrorFactory.getInstance().generateError(error);
            return;
        }

       if(stavka instanceof MyTreeNode)
            if (((MyTreeNode)stavka).getNode() instanceof Prezentacija){
                    //((MyTreeNode)stavka).getNode().setName(e.getActionCommand());
                MainFrame.getInstance().getCommandManager().addCommand(new RenameNodeCommand(((MyTreeNode)stavka).getNode(),(MyTreeNode)stavka ,e.getActionCommand()));

            }else if(((MyTreeNode)stavka).getNode() instanceof Projekat){
                MainFrame.getInstance().getCommandManager().addCommand(new RenameNodeCommand(((MyTreeNode)stavka).getNode(),(MyTreeNode)stavka ,e.getActionCommand()));
            }else if(((MyTreeNode)stavka).getNode() instanceof Slajd){
                MainFrame.getInstance().getCommandManager().addCommand(new RenameNodeCommand(((MyTreeNode)stavka).getNode(),(MyTreeNode)stavka ,e.getActionCommand()));
            }else{
                error = new MyError(this, 2, "Nije moguce izmeniti ime Workspace-a");
                MyErrorFactory.getInstance().generateError(error);
            }

    }
}
