package slotState;

import view.MainFrame;
import view.SlajdView;
import view.SlotView;

public class SelectSlotState extends SlotState{

    @Override
    public void misKliknut(SlajdView slajd, int x, int y) {
        for(SlotView sV : slajd.getSlotovi()){
            if(sV.elenemtAt(x,y)) {
                if (slajd.getSelekvanSlot() == null) {
                    slajd.setSelekvanSlot(sV);
                    sV.getSlot().setColor(sV.getSlot().getSelektovanColor());

                } else if(slajd.getSelekvanSlot().equals(sV)){
                    SlotView slot = slajd.getSelekvanSlot();
                    slot.getSlot().setColor(slot.getSlot().getNeSelektovanBoja());
                    slajd.setSelekvanSlot(null);

                }else{
                    SlotView slot = slajd.getSelekvanSlot();
                    slot.getSlot().setColor(slot.getSlot().getNeSelektovanBoja());
                    slajd.setSelekvanSlot(sV);
                    sV.getSlot().setColor(sV.getSlot().getSelektovanColor());

                }
                slajd.repaint();
                MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent().repaint();
            }
        }
    }

    @Override
    public void misPovucen(SlajdView slajd, int x, int y) {

    }
}
