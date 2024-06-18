package slotState;

import model.Slot;
import view.MainFrame;
import view.PrezentacijaView;
import view.SlajdView;


public class AddSlotState extends SlotState{

    @Override
    public void misKliknut(SlajdView slajd, int x, int y) {
        PrezentacijaView prezentacijaView = (PrezentacijaView) MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent();


        Slot slot = new Slot(x,y,100,50, prezentacijaView.getColor(), (String)prezentacijaView.getPrezentacijaToolbar().getTipSlota().getSelectedItem());
        slot.setStroke1(prezentacijaView.getStroke());
        slajd.getModel().addSlot(slot);
    }

    @Override
    public void misPovucen(SlajdView slajd, int x, int y) {

    }

}
