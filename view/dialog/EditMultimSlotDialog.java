package view.dialog;

import view.MainFrame;
import view.SlotView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class EditMultimSlotDialog extends JDialog {

    private JFileChooser jFileChooser;
    private JButton btnUcitaj;
    private JButton btnSacuvaj;
    private JLabel lblSlika;
    private ImageIcon slika;
    private ImageIcon slika3;



    public EditMultimSlotDialog(SlotView slot){
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        setSize(new Dimension(250,200));
        lblSlika = new JLabel();

        jFileChooser = new JFileChooser();

        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png"));
        jFileChooser.setAcceptAllFileFilterUsed(false);

        btnSacuvaj = new JButton("Sacuvaj");
        btnUcitaj = new JButton("Ucitaj");
        btnUcitaj.addActionListener(e -> {
            jFileChooser.showOpenDialog(MainFrame.getInstance());
            slika = new ImageIcon(jFileChooser.getSelectedFile().getAbsolutePath());
            ImageIcon slika2 = new ImageIcon(slika.getImage().getScaledInstance(lblSlika.getWidth(), lblSlika.getHeight(), Image.SCALE_DEFAULT));
            lblSlika.setIcon(slika2);
        });

        btnSacuvaj.addActionListener(e -> {
            if(jFileChooser.getSelectedFile() != null){
                slot.getSlotHandler().setContent(jFileChooser.getSelectedFile().getAbsolutePath());
                 //slot.getSlot().setContent(jFileChooser.getSelectedFile().getAbsolutePath());
                //((PrezentacijaView) MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent()).updateUI();
            }
            this.setVisible(false);
        });

        JPanel dugmici = new JPanel(new FlowLayout());
        dugmici.add(btnUcitaj);
        dugmici.add( btnSacuvaj);

        this.add(lblSlika, BorderLayout.CENTER);
        this.add(dugmici, BorderLayout.SOUTH);


        if(slot.getSlot().getContent() != null){

            slika = new ImageIcon(slot.getSlot().getContent());
            slika3 = new ImageIcon(new ImageIcon(slot.getSlot().getContent()).getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT));
            lblSlika.setIcon(slika3);
        }
    }

}
