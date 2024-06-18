package view;

import model.Slot;
import view.slotHadler.SlotHandler;

import java.awt.*;

public class SlotView {
    private Slot slot;
    private SlotHandler slotHandler;

    public SlotView(Slot slot, SlotHandler slotHandler){
        this.slot = slot;
        this.slotHandler = slotHandler;
    }

    public void paint(Graphics2D g){
        g.setColor(slot.getColor());
        g.setStroke(slot.getStroke1());
        g.drawRect(slot.getX(), slot.getY(), slot.getW(), slot.getH());
    }

    public boolean elenemtAt(int cursorX, int cursorY){
        int slotX = slot.getX();
        int slotY = slot.getY();

        if((cursorX < slotX + slot.getW() && cursorX > slotX) && cursorY < slotY + slot.getH() && cursorY > slotY) return true;
        return false;

    }

    public Slot getSlot() {
        return slot;
    }

    public SlotHandler getSlotHandler() {
        return slotHandler;
    }

    public void setSlotHandler(SlotHandler slotHandler) {
        this.slotHandler = slotHandler;
    }

}
