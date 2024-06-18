package controller.action;

import controller.AbstractRudokAction;
import controller.action.FileFilter.ProjectFileFilter;
import model.Projekat;
import model.RuNode;
import model.RuNodeComposite;
import model.WorkSpace;
import view.MainFrame;
import view.treeMVC.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenProjectAction extends AbstractRudokAction {

    public OpenProjectAction(){
        putValue(SMALL_ICON, loadIcon("images/open.png"));
        putValue(NAME, "Otvori_projekat");
        putValue(SHORT_DESCRIPTION, "Otvori_projekat");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new ProjectFileFilter());


        if (jFileChooser.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            try {
                ObjectInputStream os = new ObjectInputStream(new FileInputStream(jFileChooser.getSelectedFile()));

                Projekat projekat = null;
                try {
                    projekat = (Projekat) os.readObject();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }

                MyTreeNode parent = MainFrame.getInstance().getWorkspaceNode();
                RuNode node = parent.getNode();

                ((WorkSpace)node).addNode(projekat);
                System.out.println(((WorkSpace)node).getRuNodeList());
                MyTreeNode projekatNode = new MyTreeNode(projekat);
                parent.add(projekatNode);

                if(projekat.getRuNodeList().size() != 0){
                    for (RuNode prezentacija:  projekat.getRuNodeList()) {
                        MyTreeNode prezentacijaNode = new MyTreeNode(prezentacija);
                        projekatNode.add(prezentacijaNode);
                        if(((RuNodeComposite) prezentacija).getRuNodeList().size() !=0){
                            for (RuNode slajd:((RuNodeComposite) prezentacija).getRuNodeList()) {
                                prezentacijaNode.add(new MyTreeNode(slajd));
                            }
                        }
                    }
                }



                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
