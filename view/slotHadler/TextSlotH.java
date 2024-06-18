package view.slotHadler;

import model.Slot;
import view.MainFrame;
import view.PrezentacijaView;

import java.awt.*;

public class TextSlotH extends SlotHandler{

    public TextSlotH(Slot slot) {
        super(slot);
    }

    @Override
    public void formatSlot() {
    }

    @Override
    public void setContent(String str) {
        slot.setContent(str);
        ((PrezentacijaView)MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent()).repaint();
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

        if(slot.getContent() != null) {
            g.setColor(Color.black);
            g.drawString(slot.getContent(), slot.getX() + 10, slot.getY() + 10);
        }
    }
}
