package view;

import javax.swing.*;

public class MyMenuBar extends JMenuBar {

    public MyMenuBar(){
        JMenu fileMenu = new JMenu("File");
        //fileMenu.add(MainFrame.getInstance().getActionManager().getNewAciton());
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewNodeAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getDeleteAction());

        JMenu editManu = new JMenu("Edit");
        editManu.add(MainFrame.getInstance().getActionManager().getEditAction());
        editManu.add(MainFrame.getInstance().getActionManager().getUndoAction());
        editManu.add(MainFrame.getInstance().getActionManager().getRedoAction());

        JMenu helpMenu = new JMenu("Help");
        helpMenu.add(MainFrame.getInstance().getActionManager().getInfoAction());

        this.add(fileMenu);
        this.add(editManu);
        this.add(helpMenu);
    }

}
