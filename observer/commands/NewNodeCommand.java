package commands;

import factory.FactoryGenerator;
import factory.NodeFactory;
import model.*;
import view.MainFrame;
import view.treeMVC.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.util.List;

public class NewNodeCommand extends AbstractCommand{

    private RuNode peretn;
    private MyTreeNode peretnTree;
    private TreePath path;
    private RuNode novi;
    private MyTreeNode noviTree;
    private List<RuNode> podeljeni;

   public NewNodeCommand(MyTreeNode peretnTree,TreePath path, RuNode peretn){
       this.peretn = peretn;
       this.peretnTree = peretnTree;
       this.path = path;

   }

    @Override
    public void doCommand() {
        if(noviTree == null) {
            FactoryGenerator factoryGenerator = new FactoryGenerator();
            NodeFactory nodeFactory = factoryGenerator.returtnNodeFactory(peretn);
            novi = nodeFactory.getNewNode(peretn);
            noviTree = new MyTreeNode(novi);
        }else{
            ((RuNodeComposite) peretn).addNode(noviTree.getNode());

        }



        peretnTree.add(noviTree);
        MainFrame.getInstance().getMyTree().expandPath(path);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }

    @Override
    public void undoCommand() {
        if(novi instanceof RuNodeComposite){
            noviTree.removeFromParent();
            ((RuNodeComposite) peretn).removeNode(novi);
            ((RuNodeComposite) novi).getRuNodeList().clear();

            MainFrame.getInstance().getMyTree().expandPath(path);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }else{
            noviTree.removeFromParent();
            ((RuNodeComposite) peretn).removeNode(novi);


            MainFrame.getInstance().getMyTree().expandPath(path);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }
    }
}
