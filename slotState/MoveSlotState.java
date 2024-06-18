package slotState;


import view.MainFrame;
import view.SlajdView;


public class MoveSlotState extends SlotState{

    public boolean jeste = false;
    @Override
    public void misKliknut(SlajdView slajd, int x, int y) {
        if(slajd.getSelekvanSlot() != null) {
            if (slajd.getSelekvanSlot().elenemtAt(x, y)) {
                jeste = true;
            }
        }
    }

    @Override
    public void misPovucen(SlajdView slajd, int x, int y) {
        if(jeste) {
            if (slajd.getSelekvanSlot() != null) {
                slajd.getSelekvanSlot().getSlot().setX(x);
                slajd.getSelekvanSlot().getSlot().setY(y);
                MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent().repaint();
            } else {
                System.out.println("Nije selektovan slot");
            }
        }
    }

    @Override
    public void misPusten() {
        super.misPusten();
        jeste = false;
    }
}
