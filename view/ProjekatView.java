package view;

import model.Prezentacija;
import model.Projekat;
import model.RuNode;
import observer.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class ProjekatView extends JPanel implements Subscriber {

    private Projekat model;

    JLabel lbProjIme;
    JPanel panel;
    JTabbedPane tabbedPane;
    List <PrezentacijaView> listaPrezentacija;


    public ProjekatView(Projekat model){
        this.model = model;

        initialise();
    }

    private void initialise(){
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(350,200));

        lbProjIme = new JLabel();
        add(lbProjIme, BorderLayout.NORTH);

        panel = new JPanel(new BorderLayout());
        add(panel, BorderLayout.CENTER);

        tabbedPane= new JTabbedPane();

        panel.add(tabbedPane, BorderLayout.CENTER);

         listaPrezentacija = new LinkedList<>();


    }

    @Override
    public void update(Object notification) {

        tabbedPane.removeAll();
        add(lbProjIme, BorderLayout.NORTH);
        lbProjIme.setText(model.getName());
        lbProjIme.setFont(new Font("Calibri", Font.ITALIC, 16));


       /* if(model.getRuNodeList().size() > listaPrezentacija.size()){
            if(notification instanceof RuNode){
                addTab((RuNode) notification);
            }
        }else if (model.getRuNodeList().size() < listaPrezentacija.size()){
            if(notification instanceof RuNode){
                removeTab((RuNode) notification);
            }
        }*/
       for (RuNode node: this.model.getRuNodeList()) {
            tabbedPane.add(node.getName(), new PrezentacijaView((Prezentacija) node));
       }
        //updateUI();
    }

    public void addTab(RuNode node){
        PrezentacijaView prezentacija = new PrezentacijaView((Prezentacija) node);
        listaPrezentacija.add(prezentacija);
        tabbedPane.add(node.getName(),prezentacija);
    }

    public void removeTab(RuNode node){
        for (PrezentacijaView p: listaPrezentacija) {
            if(p.getModel().equals((Prezentacija) node)){
                listaPrezentacija.remove(p);
                int tab = tabbedPane.indexOfComponent(p);
                tabbedPane.removeTabAt(tab);
            }
        }
    }

    public Projekat getModel() {
        return model;
    }

    public void setModel(RuNode model) {
        this.model = (Projekat) model;
        this.model.addSubscriber(this);

        update(this);
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }
}
