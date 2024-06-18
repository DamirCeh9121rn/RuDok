package factory;

import model.Prezentacija;
import model.RuNode;
import model.Slajd;

public class SlajdFactory extends NodeFactory{


    @Override
    public RuNode createNode(RuNode node) {
        if(node instanceof Prezentacija)
            return new Slajd();
        return null;
    }
}
