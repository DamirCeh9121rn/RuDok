package slotState;

import view.SlajdView;
import view.SlotView;

public class DeleteSlotState extends SlotState{

    @Override
    public void misKliknut(SlajdView slajd, int x, int y) {
        for (SlotView s: slajd.getSlotovi()) {
            if(s.elenemtAt(x,y)){
                slajd.getModel().removeSlot(s.getSlot());
                break;
            }
        }
    }

    @Override
    public void misPovucen(SlajdView slajd, int x, int y) {

    }
}
