package controller.action;

import controller.AbstractRudokAction;
import controller.action.FileFilter.PresFileFilter;
import controller.action.FileFilter.ProjectFileFilter;
import error.MyError;
import error.MyErrorFactory;
import model.Prezentacija;
import model.Projekat;
import view.MainFrame;
import view.treeMVC.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class SavePrezentacijaAction extends AbstractRudokAction {
    public SavePrezentacijaAction(){
        putValue(SMALL_ICON, loadIcon("images/save.png"));
        putValue(NAME, "Sacuvaj_prezentaciju");
        putValue(SHORT_DESCRIPTION, "Sacuvaj_prezentaciju");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new PresFileFilter());

        if(MainFrame.getInstance().getMyTree().getSelectionPath() == null){
            MyError error = new MyError(this, 1, "Morate selektovati prezentaciju");
            MyErrorFactory.getInstance().generateError(error);
            return;
        }else if(!(((MyTreeNode) MainFrame.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode() instanceof Prezentacija )){
            MyError error = new MyError(this, 2, "Morate selektovati prezentaciju");
            MyErrorFactory.getInstance().generateError(error);
            return;
        }

        MyTreeNode preszentacijaNode = (MyTreeNode) MainFrame.getInstance().getMyTree().getSelectionPath().getLastPathComponent();

        Prezentacija prezentacija = (Prezentacija) preszentacijaNode.getNode();

        File projekatFile = prezentacija.getFile();


//        if (!projekat.IsPromenjen()){
//            return;
//        }

        if (prezentacija.getFile() == null){
            if(jFileChooser.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
                projekatFile = jFileChooser.getSelectedFile();

            }else{
                return;
            }
        }

        ObjectOutputStream os;
        try {
            os = new ObjectOutputStream(new FileOutputStream(projekatFile));
            os.writeObject(prezentacija);
            prezentacija.setFile(projekatFile);
            //prezentacija.setPromenjen(false);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
