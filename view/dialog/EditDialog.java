package view.dialog;

import model.Prezentacija;
import view.MainFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class EditDialog extends JDialog {

    JLabel lblAutor;
    JTextField tfAutor;
    JLabel lblUrl;
    JTextField tfUrl;
    JButton btnSacuvaj;

    JFileChooser fileChooser;

    public EditDialog(Prezentacija prezentacija){
        setSize(250, 130);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setTitle("Edit");
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout());

        lblAutor = new JLabel("Unesi autora:     ");
        tfAutor = new JTextField();
        tfAutor.setText("");
        tfAutor.setColumns(10);

        lblUrl = new JLabel("Lokacija slike: ");
        tfUrl = new JTextField();
        tfUrl.setEditable(false);
        tfUrl.setColumns(10);

        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png"));
        fileChooser.setAcceptAllFileFilterUsed(false);

        btnSacuvaj = new JButton("Sacuvaj");
        btnSacuvaj.addActionListener(e -> {
            if(!tfAutor.getText().equals(""))
                prezentacija.setAutor(tfAutor.getText());
            if(!tfUrl.getText().equals("")) {
                prezentacija.setFileName(tfUrl.getText());
            }
            this.setVisible(false);
        });

        JButton btnZatvoti = new JButton("Izaberite sliku");
        btnZatvoti.addActionListener(e -> {
            fileChooser.showOpenDialog(MainFrame.getInstance());
            tfUrl.setText(fileChooser.getSelectedFile().getAbsolutePath());
        });

        panel.add(lblAutor);
        panel.add(tfAutor);
        panel.add(lblUrl);
        panel.add(tfUrl);
        panel.add(btnSacuvaj);
        panel.add(btnZatvoti);

        this.add(panel);
    }

    public JTextField getTfAutor() {
        return tfAutor;
    }

    public JTextField getTfUrl() {
        return tfUrl;
    }

    public JButton getBtnSacuvaj() {
        return btnSacuvaj;
    }
}
