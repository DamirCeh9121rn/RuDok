package view.treeMVC.controller;

import model.Projekat;
import model.RuNode;
import view.MainFrame;
import view.treeMVC.model.MyTreeNode;

import javax.swing.tree.TreePath;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            TreePath path = MainFrame.getInstance().getMyTree().getSelectionPath();
            MyTreeNode selected = (MyTreeNode) path.getLastPathComponent();
            RuNode comp = selected.getNode();

            if(comp instanceof Projekat){

                MainFrame.getInstance().getProjekatView().setModel(comp);
            }else {
                MainFrame.getInstance().repaint();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
