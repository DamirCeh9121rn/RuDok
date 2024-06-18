package view.dialog;

import view.SlotView;

import javax.swing.*;
import java.awt.*;

public class EditTextSlotDialog extends JDialog {
    private JTextPane textPane;
    private JButton btnSacuvaj;

    private TextToolbar toolbar;

    public EditTextSlotDialog(SlotView slot){
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        setSize(new Dimension(250,200));

        textPane = new JTextPane();

        if(slot.getSlotHandler().getContent() !=null){
            textPane.setText(slot.getSlotHandler().getContent());
        }

        toolbar = new TextToolbar(this);

        btnSacuvaj = new JButton("Sacuvaj");
        btnSacuvaj.addActionListener(e -> {
            slot.getSlotHandler().setContent(textPane.getText());
            this.setVisible(false);
        });


        toolbar.addSeparator();
        toolbar.add(btnSacuvaj);

        this.add(toolbar, BorderLayout.NORTH);
        this.add(textPane,BorderLayout.CENTER);

    }

    public JTextPane getTextPane() {
        return textPane;
    }
}
