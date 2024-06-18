package controller.action;

import controller.AbstractRudokAction;
import view.MainFrame;
import view.PrezentacijaView;


import java.awt.event.ActionEvent;


public class SelectSlotAction extends AbstractRudokAction {

    public SelectSlotAction(){
        putValue(SMALL_ICON, loadIcon("images/select.png"));
        putValue(NAME, "Select_slot");
        putValue(SHORT_DESCRIPTION, "Select_Slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent() instanceof PrezentacijaView) {
            PrezentacijaView p = ((PrezentacijaView)MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent());
            p.selectSlotState();
        }
    }
}
