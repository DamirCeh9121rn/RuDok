package factory;

import model.Projekat;
import model.RuNode;
import model.WorkSpace;

public class ProjekatFactory extends NodeFactory{
    @Override
    public RuNode createNode(RuNode node) {
        if(node instanceof WorkSpace)
            return new Projekat();
        return null;
    }
}
