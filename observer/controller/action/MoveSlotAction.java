package controller.action;

import controller.AbstractRudokAction;
import view.MainFrame;
import view.PrezentacijaView;

import java.awt.event.ActionEvent;

public class MoveSlotAction extends AbstractRudokAction {

    public MoveSlotAction(){
        putValue(SMALL_ICON, loadIcon("images/move.png"));
        putValue(NAME, "Move_slot");
        putValue(SHORT_DESCRIPTION, "Move_Slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent() instanceof PrezentacijaView) {
            PrezentacijaView p = ((PrezentacijaView)MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent());
            p.moveSlotState();
        }
    }
}
