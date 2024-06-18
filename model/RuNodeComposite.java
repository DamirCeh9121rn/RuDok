package model;

import java.util.LinkedList;
import java.util.List;

public abstract class RuNodeComposite extends RuNode{
    private List<RuNode> ruNodeList;

    public RuNodeComposite(){
        ruNodeList = new LinkedList<RuNode>();
    }

    public abstract void addNode(RuNode node);

    public abstract void removeNode(RuNode node);

    public List<RuNode> getRuNodeList() {
        return ruNodeList;
    }

    public void setRuNodeList(List<RuNode> ruNodeList) {
        this.ruNodeList = ruNodeList;
    }
}
