package view.slotHadler;

import model.Slot;
import view.MainFrame;
import view.PrezentacijaView;

import javax.swing.*;
import java.awt.*;


public class MultimSlotH extends SlotHandler{

    private ImageIcon slika;
    public MultimSlotH(Slot slot) {
        super(slot);
        slika = new ImageIcon(slot.getContent());
    }

    @Override
    public void formatSlot() {

    }

    @Override
    public void setContent(String str) {
        slot.setContent(str);
        ((PrezentacijaView) MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent()).validate();
        ((PrezentacijaView) MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent()).repaint();
    }

    @Override
    public String getContent() {
        return slot.getContent();
    }

    @Override
    public void paintSlot(Graphics2D g) {
        g.setColor(slot.getColor());
        g.setStroke(slot.getStroke1());
        g.drawRect(slot.getX(), slot.getY(), slot.getW(), slot.getH());

        if(slot.getContent()!=null)
            g.drawImage(slika.getImage(), slot.getX()+1, slot.getY()+1,slot.getW()-1,slot.getH()-1,((PrezentacijaView) MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent()).getTrenutni());
    }
}
