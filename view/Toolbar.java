package view;

import javax.swing.*;

public class Toolbar extends JToolBar {

    public Toolbar(){
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getNewNodeAction());
        //add(MainFrame.getInstance().getActionManager().getNewAciton());
        add(MainFrame.getInstance().getActionManager().getEditAction());
        add(MainFrame.getInstance().getActionManager().getDeleteAction());

        add(MainFrame.getInstance().getActionManager().getUndoAction());
        add(MainFrame.getInstance().getActionManager().getRedoAction());

        add(MainFrame.getInstance().getActionManager().getSharePrezentacijaAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getSaveProjectAction());
        add(MainFrame.getInstance().getActionManager().getOpenProjectAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getSavePrezentacijaAction());
        add(MainFrame.getInstance().getActionManager().getOpenPrezentacijaAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getSaveWorkspaceAction());
        add(MainFrame.getInstance().getActionManager().getInfoAction());




    }

}
