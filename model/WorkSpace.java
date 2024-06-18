package model;


public class WorkSpace extends RuNodeComposite {



    public WorkSpace(){
        this.setName("Workspace");
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void addNode(RuNode node) {
        if(node instanceof Projekat){
            this.getRuNodeList().add(node);
        }else{
            return;
        }
    }

    @Override
    public void removeNode(RuNode node) {
        if(node instanceof Projekat){
            if(getRuNodeList().contains((Projekat)node)){
                getRuNodeList().remove((Projekat)node);
            }
        }
    }



}
