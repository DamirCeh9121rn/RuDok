package model;

import observer.Publiser;
import observer.Subscriber;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Projekat extends RuNodeComposite implements Publiser {

    private File file;
    private boolean promenjen;
   // private List<Subscriber> subscribers;

    public Projekat() {
        this.setName("Projekat");
    }

    @Override
    public void addNode(RuNode node) {
        if(node instanceof Prezentacija){
                this.getRuNodeList().add(node);
                notify(node);
        }else{
            return;
        }

    }

    @Override
    public void removeNode(RuNode node) {
        if(node instanceof Prezentacija){
            if(getRuNodeList().contains((Prezentacija)node)){
                getRuNodeList().remove((Prezentacija)node);
                notify(node);
            }
        }
    }

    @Override
    public String toString() {
        return getName();
    }


    /*@Override
    public void addSubscriber(Subscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(Subscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notify(Object notification) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for(Subscriber listener : subscribers){
            listener.update(notification);
        }
    }*/

    @Override
    public void setName(String name) {
        super.setName(name);
        notify(this);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setPromenjen(boolean promenjen){
        if(this.promenjen != promenjen){
            this.promenjen = promenjen;
        }
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }
}
