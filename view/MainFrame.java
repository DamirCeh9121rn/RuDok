package view;

import commands.CommandManager;
import controller.ActionManager;
import error.MyErrorFactory;
import model.Projekat;
import model.RuNode;
import model.WorkSpace;
import observer.Subscriber;
import view.dialog.OpenOldWorkspace;
import view.treeMVC.model.MyTreeNode;
import view.treeMVC.model.WorkspaceModel;
import view.treeMVC.view.MyTree;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class MainFrame extends JFrame implements Subscriber {

    public static MainFrame instance = null;
    private RuNode workspace;
    private ActionManager actionManager;
        private MyMenuBar myMenuBar;
        private Toolbar toolbar;
        private JPanel rightPanel;
        private JSplitPane splitH;
        private JScrollPane leftScroll;

        private ProjekatView projekatView;

        private CommandManager commandManager;

        private WorkspaceModel workspaceModel;
        private MyTree myTree;
        private MyTreeNode workspaceNode;

        private OpenOldWorkspace openOldWorkspace;

        private MainFrame(){


        }

    private void initialise(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        //setSize(screenWidth / 2, screenHeight / 2);
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("RuDok");

        MyErrorFactory.getInstance().addSubscriber(this);

        actionManager= new ActionManager();
        commandManager = new CommandManager();

        myMenuBar = new MyMenuBar();
        setJMenuBar(myMenuBar);

        toolbar = new Toolbar(); 
        add(toolbar, BorderLayout.NORTH);

        workspace = new WorkSpace();
        myTree = new MyTree();

        workspaceNode = new MyTreeNode(workspace);
        workspaceModel = new WorkspaceModel(workspaceNode);
        myTree.setModel(workspaceModel);

        leftScroll = new JScrollPane(myTree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        leftScroll.setMinimumSize(new Dimension(120,100));
        add(leftScroll, BorderLayout.WEST);

        projekatView = new ProjekatView(new Projekat());
        add(projekatView, BorderLayout.EAST);
        //rightPanel = new JPanel(new BorderLayout());
        //rightPanel.setMinimumSize(new Dimension(350,200));
        //add(rightPanel, BorderLayout.EAST);
        //rightPanel.setBackground(Color.gray);


        splitH = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScroll,projekatView);
        splitH.setOneTouchExpandable(true);
        splitH.setDividerSize(7);
        add(splitH, BorderLayout.CENTER);

        openOldWorkspace = new OpenOldWorkspace();
        openOldWorkspace.setVisible(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static MainFrame getInstance(){
        if(instance==null){
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }

    @Override
    public void update(Object notification) {
        if (notification instanceof String) {
            JOptionPane.showMessageDialog(MainFrame.getInstance(), (String) notification);
        }
    }

    public RuNode getWorkspace() {
        return workspace;
    }

    public ProjekatView getProjekatView() {
        return projekatView;
    }

    public void setProjekatView(ProjekatView projekatView) {
        this.projekatView = projekatView;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public MyMenuBar getMyMenuBar() {
        return myMenuBar;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public WorkspaceModel getWorkspaceModel() {
        return workspaceModel;
    }

    public MyTree getMyTree() {
        return myTree;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public MyTreeNode getWorkspaceNode() {
        return workspaceNode;
    }
}
