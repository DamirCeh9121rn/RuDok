package view.dialog;

import view.MainFrame;

import javax.swing.*;

public class TextToolbar extends JToolBar {
    JDialog dialog;
    public TextToolbar(JDialog dialog){
        this.setFloatable(false);
        this.dialog = dialog;

        add(MainFrame.getInstance().getActionManager().getBoldAction());
        MainFrame.getInstance().getActionManager().getBoldAction().setDialog(dialog);
        add(MainFrame.getInstance().getActionManager().getItalicAction());
        MainFrame.getInstance().getActionManager().getItalicAction().setDialog(dialog);
        add(MainFrame.getInstance().getActionManager().getUnderlineAction());
        MainFrame.getInstance().getActionManager().getUnderlineAction().setDialog(dialog);
    }

    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }
}
