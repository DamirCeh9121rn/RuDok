package state;

import model.Prezentacija;
import view.MainFrame;
import view.PrezentacijaView;

import javax.swing.*;


public class ExitSlajdShow extends State{

    @Override
    public void switc(JPanel p) {
        if(p instanceof PrezentacijaView){
            if(((PrezentacijaView) p).getModel() instanceof Prezentacija) {
                Prezentacija prez = ((PrezentacijaView) p).getModel();
                int i = MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedIndex();
                MainFrame.getInstance().getProjekatView().getTabbedPane().setComponentAt(i, new PrezentacijaView(prez));
            }
        }
    }
}
