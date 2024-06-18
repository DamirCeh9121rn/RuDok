package view.dialog;

import javax.swing.*;
import java.awt.*;

public class InfoDialog extends JDialog {

    public InfoDialog(String fileName) {
        setSize(350, 200);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setUndecorated(false);
        setTitle("Info");
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel slikaPanel = new JPanel();

        Image slika = getToolkit().getImage(getClass().getResource(fileName));
        JLabel lbSlika = new JLabel(new ImageIcon(slika));

        slikaPanel.add(lbSlika, BorderLayout.CENTER);

        panel.add(slikaPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new FlowLayout());

        JLabel lbImePrezime = new JLabel("Ime i Prezime: Damir Čeh");
        rightPanel.add(lbImePrezime);

        JLabel lbIndeks = new JLabel("Indeks: RN 91/2021        ");
        rightPanel.add(lbIndeks);

        JButton btnZatvori = new JButton("Zatvori");
        btnZatvori.addActionListener(e -> InfoDialog.this.setVisible(false));
        rightPanel.add(btnZatvori);

        panel.add(rightPanel, BorderLayout.CENTER);

        getContentPane().add(panel);
    }
}
