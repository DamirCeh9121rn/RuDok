package slotState;

public class SlotStateManager {

    private SlotState currState;
    private AddSlotState addSlotState;
    private SelectSlotState selectSlotState;
    private MoveSlotState moveSlotState;
    private DeleteSlotState deleteSlotState;

    public SlotStateManager(){ initStates();}

    private void initStates() {
        addSlotState = new AddSlotState();
        selectSlotState = new SelectSlotState();
        moveSlotState = new MoveSlotState();
        deleteSlotState = new DeleteSlotState();
        currState = addSlotState;
    }

    public SlotState getCurrState() {
        return currState;
    }

    public void setAddSlotState() {
        currState = addSlotState;
    }

    public void setDeleteSlotState() {
        currState = deleteSlotState;
    }

    public void setMoveSlotState() {
        currState = moveSlotState;
    }

    public void setSelectSlotState() {
        currState = selectSlotState;
    }
}
