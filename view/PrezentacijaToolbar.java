package view;

import javax.swing.*;
import java.awt.*;

public class PrezentacijaToolbar extends JToolBar {

    private JRadioButton btn1;
    private JRadioButton btn2;
    private ButtonGroup group;
    private JComboBox<Integer> debljinaLinije;
    private JComboBox<String> tipSlota;

    public PrezentacijaToolbar(){
        super(HORIZONTAL);
        setFloatable(false);
        btn1 = new JRadioButton("Puna linija");
        btn2 = new JRadioButton("Isprekidana linija");

        group = new ButtonGroup();
        group.add(btn1);
        group.add(btn2);

        debljinaLinije = new JComboBox<>();
        debljinaLinije.addItem(1);
        debljinaLinije.addItem(2);
        debljinaLinije.addItem(3);
        debljinaLinije.addItem(4);
        debljinaLinije.addItem(5);
        debljinaLinije.addItem(6);
        debljinaLinije.addItem(7);
        debljinaLinije.addItem(8);
        debljinaLinije.addItem(9);

        tipSlota = new JComboBox<>();
        tipSlota.addItem("Tekstualni");
        tipSlota.addItem("Multimedijalni");


        add(MainFrame.getInstance().getActionManager().getPrezentacijaViewAction());
        add(MainFrame.getInstance().getActionManager().getNewSlotAction());
        add(MainFrame.getInstance().getActionManager().getSelectSlotAction());
        add(MainFrame.getInstance().getActionManager().getMoveSlotAction());
        add(MainFrame.getInstance().getActionManager().getDeleteSlotAction());
        add(MainFrame.getInstance().getActionManager().getEditSlotAction());

        addSeparator(new Dimension(270,10));
        add(tipSlota);
        add(btn1);
        btn1.setSelected(true);
        add(btn2);
        add(MainFrame.getInstance().getActionManager().getSlotColorAction());
        add(debljinaLinije);

    }

    public JComboBox<String> getTipSlota() {
        return tipSlota;
    }

    public JRadioButton getBtn1() {
        return btn1;
    }

    public JRadioButton getBtn2() {
        return btn2;
    }

    public JComboBox<Integer> getDebljinaLinije() {
        return debljinaLinije;
    }
}
