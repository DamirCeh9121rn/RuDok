package view.slotHadler;


import model.Slot;

import java.awt.*;

public abstract class SlotHandler {

    Slot slot;

    public SlotHandler(Slot slot){
        this.slot = slot;
    }

    public abstract void formatSlot();

    public abstract void setContent(String str);

    public abstract String getContent();

    public abstract void paintSlot(Graphics2D g);

}
