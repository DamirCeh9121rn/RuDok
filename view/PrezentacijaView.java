package view;

import controller.MouseControler;
import model.Prezentacija;
import model.RuNode;
import model.Slajd;
import observer.Subscriber;
import slotState.SlotStateManager;
import state.StateManager;

import javax.swing.*;
import java.awt.*;


public class PrezentacijaView extends JPanel implements Subscriber {

    private Prezentacija model;
    private JScrollPane scrollPane;
    private JPanel panel;
    private JPanel navigator;
    private JScrollPane navigarorSPane;
    private JLabel lbAutor;
    private PrezentacijaToolbar prezentacijaToolbar;
    private JSplitPane splitPane;
    private JPanel slajdShowPanel;

    private SlajdView trenutni;
    private Point point;
    private Color color;

    private StateManager stateManager;
    private SlotStateManager slotStateManager;

    public PrezentacijaView(Prezentacija model){
        this.model = model;
        this.model.addSubscriber(this);

        stateManager = new StateManager();
        slotStateManager = new SlotStateManager();

        initialise();
    }

    private void initialise(){
        panel = new JPanel();
        panel.setBackground(Color.lightGray);


        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        slajdShowPanel = new JPanel();
        slajdShowPanel.setLayout(new CardLayout());

        navigator = new JPanel();
        navigator.setBackground(Color.DARK_GRAY);
        navigator.setLayout(new BoxLayout(navigator, BoxLayout.Y_AXIS));
        navigator.setMaximumSize(new Dimension(150,100000));

        prezentacijaToolbar = new PrezentacijaToolbar();

        lbAutor = new JLabel();
        if(model.getAutor() != null)
            lbAutor.setText(model.getAutor());

        scrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setMinimumSize(new Dimension(300,499));

        navigarorSPane = new JScrollPane(navigator,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        navigarorSPane.setMinimumSize(new Dimension(150,499));

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.EAST);
        this.add(prezentacijaToolbar, BorderLayout.PAGE_START);
        this.add(navigarorSPane, BorderLayout.WEST);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navigarorSPane,scrollPane);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerSize(1);
        add(splitPane, BorderLayout.CENTER);

        trenutni = new SlajdView(new Slajd());
        point = new Point();
        color = Color.BLACK;

        if(model.isRezim()){
            update(this);
            startSlajdShow();
            switc();
        }else{
            update(this);
        }
    }


    @Override
    public void update(Object notification) {
        panel.removeAll();
        navigator.removeAll();
        slajdShowPanel.removeAll();

        panel.add("North", lbAutor);
        lbAutor.setText(model.getAutor());
        lbAutor.setFont(new Font("Calibri", Font.ITALIC, 16));

        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //panel.add(Box.createVerticalStrut(10));

        navigator.setAlignmentX(Component.CENTER_ALIGNMENT);

        Integer i = 1;

            for (RuNode node: model.getRuNodeList()) {

                navigator.add(Box.createVerticalStrut(2));

                panel.add(Box.createVerticalStrut(10));

                SlajdView slajd = new SlajdView((Slajd) node);
                slajd.addMouseListener(new MouseControler());
                slajd.addMouseMotionListener(new MouseControler());
                SlajdView coppy = new SlajdView((Slajd) node);
                SlajdView slajd1 = new SlajdView((Slajd) node);

                ((Slajd) node).setBrojStrane(i);

                slajd.getStranicaBr().setText(((Slajd) node).getBrojStrane().toString());
                coppy.getStranicaBr().setText(((Slajd) node).getBrojStrane().toString());
                slajd1.getStranicaBr().setText(((Slajd) node).getBrojStrane().toString());

                if (model.getFileName() != null) {
                    if(model.getFileName().equals("images/default.png")) {
                        Image slika = getToolkit().getImage(getClass().getResource(model.getFileName()));
                        slajd.setImg(slika);
                        coppy.setImg(slika);
                        slajd1.setImg(slika);
                    }else{
                        ImageIcon slika = new ImageIcon(model.getFileName());
                        if(slika!=null){
                            slajd.setImgIco(slika);
                            coppy.setImgIco(slika);
                            slajd1.setImgIco(slika);
                        }
                    }


                }
                coppy.setPreferredSize(new Dimension(100,75));
                coppy.setMaximumSize(new Dimension(100,75));
                slajdShowPanel.add(slajd1);
                navigator.add(coppy);
                panel.add(slajd);
                i++;
            }
            updateUI();
    }

    public void  addSlotState(){
        this.slotStateManager.setAddSlotState();
    }
    public void selectSlotState(){
        this.slotStateManager.setSelectSlotState();
    }
    public void moveSlotState(){
        this.slotStateManager.setMoveSlotState();
    }
    public void deleteSlotState(){
        this.slotStateManager.setDeleteSlotState();
    }

    public void misKliknut(){
        this.slotStateManager.getCurrState().misKliknut(trenutni, point.x , point.y);
    }

    public void misPovucen(SlajdView slajdView ,Point point ){
        this.slotStateManager.getCurrState().misPovucen(slajdView, point.x , point.y);
    }

    public void misPusten(){
        this.slotStateManager.getCurrState().misPusten();
    }

    public void startSlajdShow(){ this.stateManager.setSlajdShow();}

    public void exitSlajdShow(){ this.stateManager.setExitSlajdShowSlajdShow();}

    public void switc(){
        this.stateManager.getCurrState().switc(this);
    }

    public Prezentacija getModel() {
        return model;
    }

    public JPanel getNavigator() {
        return navigator;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

    public JScrollPane getNavigarorSPane() {
        return navigarorSPane;
    }

    public PrezentacijaToolbar getPrezentacijaToolbar() {
        return prezentacijaToolbar;
    }

    public JPanel getSlajdShowPanel() {
        return slajdShowPanel;
    }

    public SlajdView getTrenutni() {
        return trenutni;
    }

    public void setTrenutni(SlajdView trenutni) {
        this.trenutni = trenutni;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    public Stroke getStroke(){
        if(prezentacijaToolbar.getBtn1().isSelected()){
            return new BasicStroke((Integer)prezentacijaToolbar.getDebljinaLinije().getSelectedItem());
        }else{
           return new BasicStroke((Integer)prezentacijaToolbar.getDebljinaLinije().getSelectedItem(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{15}, 0);
        }
    }

}
