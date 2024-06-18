package state;

public class StateManager {

    private State currState;
    private SlajdShow slajdShow;
    private ExitSlajdShow exitSlajdShow;

    public StateManager() {
        initStates();
    }

    private void initStates() {
        slajdShow = new SlajdShow();
        exitSlajdShow = new ExitSlajdShow();
        currState = exitSlajdShow;
    }

    public State getCurrState(){
        return currState;
    }

    public void setSlajdShow(){
        currState = slajdShow;
    }

    public void setExitSlajdShowSlajdShow(){
        currState = exitSlajdShow;
    }
}
