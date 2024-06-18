package controller.action;

import commands.NewNodeCommand;
import controller.AbstractRudokAction;
import error.MyError;
import error.MyErrorFactory;
import factory.FactoryGenerator;
import factory.NodeFactory;
import model.RuNode;
import view.MainFrame;
import view.treeMVC.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewNodeAction extends AbstractRudokAction {

    private MyError error;

    public NewNodeAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/new.png"));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TreePath path = ((JTree) MainFrame.getInstance().getMyTree()).getSelectionPath();
        if(path == null){
            error = new MyError(this,1,"Morate selektovati model");
            MyErrorFactory.getInstance().generateError(error);
            return;
        }

        MyTreeNode myTreeNode = (MyTreeNode)path.getLastPathComponent();
        RuNode model = myTreeNode.getNode();

        MainFrame.getInstance().getCommandManager().addCommand(new NewNodeCommand(myTreeNode,path,model));
        /*FactoryGenerator factoryGenerator = new FactoryGenerator();
        NodeFactory nodeFactory = factoryGenerator.returtnNodeFactory(model);
        RuNode newNode = nodeFactory.getNewNode(model);

        myTreeNode.add(new MyTreeNode(newNode));
        MainFrame.getInstance().getMyTree().expandPath(path);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());*/
    }
}
