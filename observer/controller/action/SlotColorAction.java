package controller.action;

import controller.AbstractRudokAction;
import view.MainFrame;
import view.PrezentacijaView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SlotColorAction extends AbstractRudokAction {
    private JColorChooser colorChooser;
    private JDialog dialog;
    private JButton sacuvaj;


    public SlotColorAction(){
        putValue(SMALL_ICON, loadIcon("images/color.png"));
        putValue(NAME, "Color_slot");
        putValue(SHORT_DESCRIPTION, "Color_Slot");
        colorChooser = new JColorChooser();
        dialog = new JDialog();
        dialog.setMinimumSize(new Dimension(600,400));
        dialog.setLocationRelativeTo(null);
        dialog.add(colorChooser, BorderLayout.CENTER);
        sacuvaj = new JButton("Sacuvaj boju");
        dialog.add(sacuvaj, BorderLayout.PAGE_END);
        sacuvaj.addActionListener(e -> {
            PrezentacijaView prezentacijaView = (PrezentacijaView) MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent();
            prezentacijaView.setColor(colorChooser.getColor());
            dialog.setVisible(false);
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.setVisible(true);
    }
}
