package factory;

import model.RuNode;
import model.RuNodeComposite;

public abstract class NodeFactory {

    public RuNode getNewNode(RuNode node){
        RuNode n = createNode(node);
        n.setParent(node);
        if(node instanceof RuNodeComposite) {
            Integer i =((RuNodeComposite) node).getRuNodeList().size()+1;
            n.setName(n.getName() + "_" + i.toString());
            ((RuNodeComposite) node).addNode(n);

        }
        return n;
    }

    public abstract RuNode createNode(RuNode node);
}
