package controller.action;

import controller.AbstractRudokAction;
import view.MainFrame;
import view.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteSlotAction extends AbstractRudokAction {

    public DeleteSlotAction(){
        putValue(SMALL_ICON, loadIcon("images/delete.png"));
        putValue(NAME, "Delete_Slot");
        putValue(SHORT_DESCRIPTION, "Delete_Slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent() instanceof PrezentacijaView) {
            PrezentacijaView p = ((PrezentacijaView)MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent());
            p.deleteSlotState();

        }
    }
}
