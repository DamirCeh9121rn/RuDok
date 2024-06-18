package controller.action;

import controller.AbstractRudokAction;
import controller.action.FileFilter.ProjectFileFilter;
import model.Projekat;
import model.RuNode;
import model.RuNodeComposite;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveWorkspaceAction extends AbstractRudokAction {
    public SaveWorkspaceAction(){
        putValue(SMALL_ICON, loadIcon("images/save.png"));
        putValue(NAME, "Sacuvaj_workspace");
        putValue(SHORT_DESCRIPTION, "Sacuvaj_workspace");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<String> putanje = new ArrayList<>();

        for (RuNode node : ((RuNodeComposite)MainFrame.getInstance().getWorkspace()).getRuNodeList()) {
            if(((Projekat) node).getFile() != null)
                putanje.add(((Projekat) node).getFile().getAbsolutePath());
            else{
                String fileName = "RuDok/neSacuvaniProjekti/" +node.getName()+".rpf";
                ((Projekat) node).setFile( new File(fileName));

                ObjectOutputStream os;
                try {
                    os = new ObjectOutputStream(new FileOutputStream(((Projekat) node).getFile()));
                    os.writeObject(((Projekat) node));
                    ((Projekat) node).setFile(((Projekat) node).getFile());
                    ((Projekat) node).setPromenjen(false);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                putanje.add(((Projekat) node).getFile().getAbsolutePath());
            }
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("RuDok/src/controller/action/kontekts.txt"));

            for (String s : putanje){
                System.out.println(s);
                writer.write(s);
                writer.newLine();
                writer.flush();
            }

            writer.close();

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
