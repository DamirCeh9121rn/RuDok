package controller.action;

import controller.AbstractRudokAction;
import controller.action.FileFilter.ProjectFileFilter;
import error.MyError;
import error.MyErrorFactory;
import model.Projekat;
import view.MainFrame;
import view.treeMVC.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class SaveProjectAction extends AbstractRudokAction {
    public SaveProjectAction(){
        putValue(SMALL_ICON, loadIcon("images/save.png"));
        putValue(NAME, "Sacuvaj_projekat");
        putValue(SHORT_DESCRIPTION, "Sacuvaj_projekat");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new ProjectFileFilter());

        if(MainFrame.getInstance().getMyTree().getSelectionPath() == null){
            MyError error = new MyError(this, 1, "Morate selektovati projekat");
            MyErrorFactory.getInstance().generateError(error);
            return;
        }else if(!(((MyTreeNode) MainFrame.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode() instanceof Projekat )){
            MyError error = new MyError(this, 2, "Morate selektovati projekat");
            MyErrorFactory.getInstance().generateError(error);
            return;
        }

        MyTreeNode projekatNode = (MyTreeNode) MainFrame.getInstance().getMyTree().getSelectionPath().getLastPathComponent();

        Projekat projekat = (Projekat) projekatNode.getNode();

        File projekatFile = projekat.getFile();


//        if (!projekat.IsPromenjen()){
//            return;
//        }

        //if (projekat.getFile() == null){
            if(jFileChooser.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
                projekatFile = jFileChooser.getSelectedFile();

            }//else{
             //   return;
            //}
        //}

        ObjectOutputStream os;
        try {
            os = new ObjectOutputStream(new FileOutputStream(projekatFile));
            os.writeObject(projekat);
            projekat.setFile(projekatFile);
            projekat.setPromenjen(false);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
