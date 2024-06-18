package factory;

import model.Prezentacija;
import model.Projekat;
import model.RuNode;
import model.WorkSpace;

public class FactoryGenerator {

    private static ProjekatFactory projF = new ProjekatFactory();
    private static PrezentacijaFactory prezF = new PrezentacijaFactory();
    private static SlajdFactory slajdF = new SlajdFactory();

    public static NodeFactory returtnNodeFactory(RuNode node){
        if(node instanceof WorkSpace){
            return projF;
        }else if(node instanceof Projekat){
            return prezF;
        }else if(node instanceof Prezentacija){
            return slajdF;
        }else
            return null;
    }



}
