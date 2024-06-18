package controller.action;

import controller.AbstractRudokAction;
import view.MainFrame;
import view.PrezentacijaView;

import java.awt.event.ActionEvent;

public class NewSlotAction extends AbstractRudokAction {

    public NewSlotAction(){
        putValue(SMALL_ICON, loadIcon("images/newSlot.png"));
        putValue(NAME, "New_slot");
        putValue(SHORT_DESCRIPTION, "New_Slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent() instanceof PrezentacijaView) {
            PrezentacijaView p = ((PrezentacijaView)MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent());
            p.addSlotState();
        }
    }
}
