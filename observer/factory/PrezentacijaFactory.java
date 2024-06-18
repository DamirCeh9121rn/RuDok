package factory;

import model.Prezentacija;
import model.Projekat;
import model.RuNode;

public class PrezentacijaFactory extends NodeFactory{

    @Override
    public RuNode createNode(RuNode node) {
        if(node instanceof Projekat)
            return new Prezentacija();
        return null;
    }
}
