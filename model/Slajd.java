package model;

import observer.Publiser;
import observer.Subscriber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Slajd extends RuNode implements Publiser {
    private Integer brojStrane;

    private List<Slot> slotovi;

    //List<Subscriber> subscribers;

    public Slajd(){
        this.setName("Slajd");
        this.slotovi = new ArrayList<>();
    }

    public Integer getBrojStrane() {
        return brojStrane;
    }

    public void setBrojStrane(Integer brojStrane) {
        this.brojStrane = brojStrane;
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

    public void addSlot(Slot slot){
        this.slotovi.add(slot);
        notify(slot);
    }

    public void removeSlot(Slot slot){
        this.slotovi.remove(slot);
        notify(slot);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public List<Slot> getSlotovi() {
        return slotovi;
    }

    @Override
    public String toString() {
        return getName();
    }
}
