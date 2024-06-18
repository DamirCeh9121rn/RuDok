package controller.action;

import controller.AbstractRudokAction;
import view.MainFrame;
import view.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ExitSlajdShowAction extends AbstractRudokAction {

    public ExitSlajdShowAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F5, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/dizajn.png"));
        putValue(NAME, "Edit view");
        putValue(SHORT_DESCRIPTION, "Edit view");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if( MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent() instanceof PrezentacijaView) {
            PrezentacijaView p = ((PrezentacijaView)MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent());
            p.getModel().setRezim(false);
            p.exitSlajdShow();
            p.switc();
        }
    }
}
