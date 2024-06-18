package controller.action;

import controller.AbstractRudokAction;
import error.MyError;
import error.MyErrorFactory;
import model.*;
import view.MainFrame;
import view.treeMVC.model.MyTreeNode;


import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewAciton extends AbstractRudokAction {

    private MyError error;

    public NewAciton(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/new.png"));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TreePath path = ((JTree)MainFrame.getInstance().getMyTree()).getSelectionPath();

        if(path == null){
            error = new MyError(this,1,"Morate selektovati model");
            MyErrorFactory.getInstance().generateError(error);
            return;
        }

        MyTreeNode myTreeNode = (MyTreeNode)path.getLastPathComponent();



        if(myTreeNode.getNode() instanceof WorkSpace){
            Projekat projekat = new Projekat();
            projekat.setName("Projekat - " + (((WorkSpace) myTreeNode.getNode()).getRuNodeList().size()+1));
            ((WorkSpace) myTreeNode.getNode()).addNode(projekat);


            myTreeNode.add(new MyTreeNode(projekat));
            MainFrame.getInstance().getMyTree().expandPath(path);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }else if(myTreeNode.getNode() instanceof Projekat){
            Prezentacija prezentacija = new Prezentacija();
            prezentacija.setName("Prezentacija - "+ (((Projekat) myTreeNode.getNode()).getRuNodeList().size()+1));
            ((Projekat) myTreeNode.getNode()).addNode(prezentacija);


            myTreeNode.add(new MyTreeNode(prezentacija));
            MainFrame.getInstance().getMyTree().expandPath(path);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }else if(myTreeNode.getNode() instanceof Prezentacija){
            Slajd slajd = new Slajd();
            slajd.setName("Slajd - " + (((Prezentacija) myTreeNode.getNode()).getRuNodeList().size()+1));
            ((Prezentacija) myTreeNode.getNode()).addNode(slajd);

            myTreeNode.add(new MyTreeNode(slajd));
            MainFrame.getInstance().getMyTree().expandPath(path);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }else if(myTreeNode.getNode() instanceof Slajd){
            error = new MyError(this,2,"Nije moguce dodati potomke slajdu");
            MyErrorFactory.getInstance().generateError(error);
        }

    }
}
