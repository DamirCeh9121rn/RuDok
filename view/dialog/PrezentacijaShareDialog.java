package view.dialog;

import model.*;
import view.MainFrame;
import view.treeMVC.model.MyTreeNode;

import javax.swing.*;
import java.awt.*;

public class PrezentacijaShareDialog extends JDialog {

    private WorkSpace workspace;
    private Prezentacija selektovanaPrez;
    private JLabel lblSelektovana;
    private JComboBox<RuNode> projekti;
    private JButton podeli;
    private MyTreeNode wokrspaceNode;

    public PrezentacijaShareDialog(RuNode prezentacija, MyTreeNode workspaceNode){
        setSize(new Dimension(250, 200));
        this.setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        this.wokrspaceNode = workspaceNode;

        workspace = (WorkSpace) MainFrame.getInstance().getWorkspace();
        selektovanaPrez = (Prezentacija) prezentacija;

        lblSelektovana = new JLabel("Selektovana prezentacija: " +selektovanaPrez.getName());

        projekti = new JComboBox<>();
        for (RuNode node: ((WorkSpace) workspace).getRuNodeList()) {
            if(!((Projekat)node).getRuNodeList().contains(selektovanaPrez)) {
                projekti.addItem(node);
            }
        }


        podeli = new JButton("Share");
        podeli.addActionListener(e -> {
            for(int i = 1; i< workspaceNode.getChildCount(); i++){
                MyTreeNode projekat = (MyTreeNode) workspaceNode.getChildAt(i);
                if(projekat.getNode().equals(projekti.getSelectedItem())){
                    selektovanaPrez.setName(selektovanaPrez.getName() +" " +"(Podeljena)");
                    selektovanaPrez.addProjekat(projekat.getNode());
                    MyTreeNode prezNode = new MyTreeNode(selektovanaPrez);
                    projekat.add(prezNode);
                    ((RuNodeComposite) projekat.getNode()).addNode(selektovanaPrez);
                    System.out.println(selektovanaPrez.getSerovane());
                    if(((RuNodeComposite)selektovanaPrez).getRuNodeList().size() !=0){
                        for (RuNode slajd:((RuNodeComposite)selektovanaPrez).getRuNodeList()) {
                            prezNode.add(new MyTreeNode(slajd));
                        }
                    }
                }
            }
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
            this.setVisible(false);
        });


        add(lblSelektovana, BorderLayout.NORTH);
        add(projekti, BorderLayout.CENTER);
        add(podeli, BorderLayout.SOUTH);
    }
}
