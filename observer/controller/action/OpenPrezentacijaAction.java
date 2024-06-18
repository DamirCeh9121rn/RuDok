package controller.action;

import controller.AbstractRudokAction;
import controller.action.FileFilter.PresFileFilter;
import error.MyError;
import error.MyErrorFactory;
import model.*;
import view.MainFrame;
import view.treeMVC.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenPrezentacijaAction extends AbstractRudokAction {

    public OpenPrezentacijaAction(){
        putValue(SMALL_ICON, loadIcon("images/open.png"));
        putValue(NAME, "Otvori_prezentaciju");
        putValue(SHORT_DESCRIPTION, "Otvori_prezentaciju");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new PresFileFilter());

        if(((MyTreeNode)MainFrame.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode() instanceof Projekat){
            if (jFileChooser.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                try {
                    ObjectInputStream os = new ObjectInputStream(new FileInputStream(jFileChooser.getSelectedFile()));

                    Prezentacija prezentacija = null;
                    try {
                        prezentacija = (Prezentacija) os.readObject();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }

                    MyTreeNode parent = ((MyTreeNode)MainFrame.getInstance().getMyTree().getSelectionPath().getLastPathComponent());
                    RuNode node = parent.getNode();

                    ((Projekat)node).addNode(prezentacija);
                    MyTreeNode prezentacijaNode = new MyTreeNode(prezentacija);
                    parent.add(prezentacijaNode);

                    for (RuNode slajd:((RuNodeComposite) prezentacija).getRuNodeList()) {
                        prezentacijaNode.add(new MyTreeNode(slajd));
                    }


                    SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }else{
            MyError error = new MyError(this, 1, "Morate selektovati prezentaciju");
            MyErrorFactory.getInstance().generateError(error);
            return;
        }
    }
}
