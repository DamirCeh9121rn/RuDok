package view.dialog;

import model.Projekat;
import model.RuNode;
import model.RuNodeComposite;
import model.WorkSpace;
import view.MainFrame;
import view.treeMVC.model.MyTreeNode;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class OpenOldWorkspace extends JDialog {
    private JLabel poruka;
    private JButton btnNe;
    private JButton btnDa;
    private JPanel dugimici;


    public OpenOldWorkspace(){

        this.setAlwaysOnTop(true);

        setLayout(new BorderLayout());
        setSize(new Dimension(300,100));
        setLocationRelativeTo(null);

        poruka = new JLabel("Da li zelite da ucitate stari kontent?");

        btnDa = new JButton("Da");
        btnDa.addActionListener(e -> {
            try{
                BufferedReader br = new BufferedReader(new FileReader(new File("RuDok/src/controller/action/kontekts.txt")));
                while(br.ready()){
                    //System.out.println(br.readLine());

                    try {
                        File file = new File(br.readLine());
                        ObjectInputStream os = new ObjectInputStream(new FileInputStream(file));

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
                        System.out.println("qdsadfsdaf");
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        System.out.println("sad2q2143r");
                        e1.printStackTrace();
                    }


                }
            }catch (Exception f){
                System.out.println("oveee");
                f.printStackTrace();
            }
            this.setVisible(false);
        });

        btnNe = new JButton("Ne");
        btnNe.addActionListener(e -> {
            setVisible(false);
        });

        dugimici = new JPanel();
        dugimici.add(btnDa);
        dugimici.add(btnNe);

        add(poruka, BorderLayout.CENTER);
        add(dugimici, BorderLayout.SOUTH);
    }
}
