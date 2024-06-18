package state;

import view.MainFrame;
import view.PrezentacijaView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlajdShow extends State{

    private JToolBar toolBar;
    private JPanel slajdovi;
    private JPanel dugmici;
    private JButton btn1;
    private JButton btn2;

    public SlajdShow(){
        this.toolBar = new JToolBar();
        this.slajdovi = new JPanel();
        this.dugmici = new JPanel();

        toolBar.add(MainFrame.getInstance().getActionManager().getExitSlajdShowAction());
        toolBar.setFloatable(false);

        ControlActionListenter cal = new ControlActionListenter();

        btn1 = new JButton("Next");
        btn1.setActionCommand("NEXT");
        btn1.addActionListener(cal);

        btn2 = new JButton("Previous");
        btn2.setActionCommand("PREVIOUS");
        btn2.addActionListener(cal);


        dugmici.add(btn2);
        dugmici.add(btn1);
    }

    @Override
    public void switc(JPanel p) {
        if(p instanceof PrezentacijaView){
            slajdovi = ((PrezentacijaView) p).getSlajdShowPanel();
            p.repaint();
            p.removeAll();

            p.add(toolBar, BorderLayout.NORTH);
            p.add(slajdovi, BorderLayout.CENTER);
            p.add(dugmici, BorderLayout.PAGE_END);
            p.updateUI();
        }
    }

    class ControlActionListenter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) (slajdovi.getLayout());
            String cmd = e.getActionCommand();
            if (cmd.equals("NEXT")) {
                cl.next(slajdovi);
            } else if (cmd.equals("PREVIOUS")) {
                cl.previous(slajdovi);
            }
        }
    }
}

