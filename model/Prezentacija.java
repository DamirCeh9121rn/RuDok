package model;


import observer.Publiser;
import observer.Subscriber;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Prezentacija extends RuNodeComposite implements Publiser {

    private String autor;
    private String fileName = "images/default.png";

    private boolean rezim = false;

    private File file;
    private List<RuNode> serovane;

   // List<Subscriber> subscribers;

    public Prezentacija(){
        this.setName("Prezentacija");
    }


    @Override
    public void addNode(RuNode node) {
        if(node instanceof Slajd){
            this.getRuNodeList().add(node);
            notify(this);
        }else{
            return;
        }
    }

    @Override
    public void removeNode(RuNode node) {
        if(node instanceof Slajd){
            if(getRuNodeList().contains((Slajd)node)){
                getRuNodeList().remove((Slajd)node);
                notify(this);
            }
        }
    }

    public void addProjekat(RuNode projekat){
        if(serovane == null)
            serovane = new ArrayList<>();
        serovane.add(projekat);
    }


    @Override
    public void setName(String name) {
        super.setName(name);
        notify(this);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
        notify(this);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        notify(this);
    }

    public boolean isRezim() {
        return rezim;
    }

    public void setRezim(boolean rezim) {
        this.rezim = rezim;
    }

    public List<RuNode> getSerovane() {
        return serovane;
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

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return getName();
    }
}
