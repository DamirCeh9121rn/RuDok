package controller;

import view.MainFrame;
import view.PrezentacijaView;
import view.SlajdView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseControler extends MouseAdapter {
    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        if(MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent() instanceof PrezentacijaView){
            PrezentacijaView p = (PrezentacijaView) MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent();
            p.misPovucen((SlajdView) e.getSource(), e.getPoint());

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        if(MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent() instanceof PrezentacijaView){
            PrezentacijaView p = (PrezentacijaView) MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent();
            p.setTrenutni((SlajdView) e.getSource());
            p.setPoint(e.getPoint());
            p.misKliknut();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);

        if(MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent() instanceof PrezentacijaView){
            PrezentacijaView p = (PrezentacijaView) MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent();
            p.misPusten();
        }
    }
}
