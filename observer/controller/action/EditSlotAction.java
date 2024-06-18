package controller.action;

import controller.AbstractRudokAction;
import error.MyError;
import error.MyErrorFactory;
import model.Slot;
import view.MainFrame;
import view.PrezentacijaView;
import view.SlajdView;
import view.SlotView;
import view.dialog.EditMultimSlotDialog;
import view.dialog.EditTextSlotDialog;
import view.slotHadler.MultimSlotH;

import java.awt.event.ActionEvent;

public class EditSlotAction extends AbstractRudokAction {

    public EditSlotAction(){
        putValue(SMALL_ICON, loadIcon("images/edit.png"));
        putValue(NAME, "EditSlot");
        putValue(SHORT_DESCRIPTION, "EditSlot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView prez = (PrezentacijaView)MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent();

        SlajdView slajd = prez.getTrenutni();

        SlotView slot = slajd.getSelekvanSlot();

        if(slot == null){
            MyError error = new MyError(this, 1,"Morate selektovati slot");
            MyErrorFactory.getInstance().generateError(error);
            return;
        } else if(slot.getSlotHandler() instanceof MultimSlotH) {
            EditMultimSlotDialog editMultimSlotDialog = new EditMultimSlotDialog(slot);
            editMultimSlotDialog.setVisible(true);

        }else{
            EditTextSlotDialog editTextSlotDialog = new EditTextSlotDialog(slot);
            editTextSlotDialog.setVisible(true);
        }
    }
}
