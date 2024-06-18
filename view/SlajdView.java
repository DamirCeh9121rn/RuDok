package view;

import model.Slajd;
import model.Slot;
import observer.Subscriber;
import state.SlajdShow;
import view.slotHadler.MultimSlotH;
import view.slotHadler.TextSlotH;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SlajdView extends JPanel implements Subscriber {

    private Slajd model;
    private Image img;
    private ImageIcon imgIco;

    private List<SlotView> slotovi;

    private SlotView selekvanSlot;

    private JLabel stranicaBr;

    public SlajdView(Slajd model){
        this.model = model;
        this.model.addSubscriber(this);

        this.slotovi = new ArrayList<>();

        initialise();
    }

    private void initialise(){
        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(100,50));
        this.setPreferredSize(new Dimension(450,300));
        this.setMaximumSize(new Dimension(500,350));

        stranicaBr = new JLabel();
        this.stranicaBr.setFont(new Font("Calibri", Font.CENTER_BASELINE, 16));
        this.setLayout(new BorderLayout());

        this.add(stranicaBr, BorderLayout.SOUTH);

        update(new String("Lista"));

    }

    @Override
    protected void paintComponent(Graphics g) {
        if(imgIco== null)
            g.drawImage(img, 0, 0,getWidth(),getHeight(), this);
        else
            g.drawImage(imgIco.getImage(), 0, 0,getWidth(),getHeight(), this);

        Graphics2D g2 = (Graphics2D) g;

        for (SlotView sV: slotovi) {
            if(((PrezentacijaView) MainFrame.getInstance().getProjekatView().getTabbedPane().getSelectedComponent()).getStateManager().getCurrState() instanceof SlajdShow)
                sV.getSlotHandler().paintSlot(g2);
            else
                sV.paint(g2);
        }

    }

    @Override
    public void update(Object notification) {

        if(notification instanceof String) {
            for (Slot s: model.getSlotovi()) {
                if(s.getTip().equalsIgnoreCase("Tekstualni")) {
                    s.setColor(s.getNeSelektovanBoja());
                    slotovi.add(new SlotView(s, new TextSlotH(s)));
                }else{
                    s.setColor(s.getNeSelektovanBoja());
                    slotovi.add(new SlotView(s, new MultimSlotH(s)));
                }
            }
        }
        if(notification instanceof Slot){
            Slot s = (Slot)notification;
            boolean dodaj = true;
            for (SlotView sV:slotovi) {
                if(sV.getSlot().equals(s)){
                    slotovi.remove(sV);
                    dodaj = false;
                    break;
                }
            }
            if(dodaj){
                if(s.getTip().equalsIgnoreCase("Tekstualni")) {
                    slotovi.add(new SlotView(s, new TextSlotH(s)));
                }else{
                    slotovi.add(new SlotView(s, new MultimSlotH(s)));
                }
            }
        }


        validate();
        repaint();
    }

    public Slajd getModel() {
        return model;
    }

    public JLabel getStranicaBr() {
        return stranicaBr;
    }

    public void setStranicaBr(JLabel stranicaBr) {

        this.stranicaBr = stranicaBr;
    }

    public List<SlotView> getSlotovi() {
        return slotovi;
    }

    public void setImgIco(ImageIcon imgIco) {
        this.imgIco = imgIco;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void setSelekvanSlot(SlotView selekvanSlot) {
        this.selekvanSlot = selekvanSlot;
    }

    public SlotView getSelekvanSlot() {
        return selekvanSlot;
    }
}
