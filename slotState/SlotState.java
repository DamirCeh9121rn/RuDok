package slotState;


import view.SlajdView;

public abstract class SlotState {

    public abstract void misKliknut(SlajdView slajd, int x, int y);

    public abstract void misPovucen(SlajdView slajd, int x, int y);

    public void misPusten(){

    }

}
