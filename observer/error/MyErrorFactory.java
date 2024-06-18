package error;

import controller.action.*;
import observer.Publiser;
import observer.Subscriber;
import view.treeMVC.controller.MyTreeCellEditor;

import java.util.ArrayList;
import java.util.List;

public class MyErrorFactory  implements Publiser {

    public static MyErrorFactory instance = null;
    private List<Subscriber> subscribers;

    private MyErrorFactory(){

    }

    public void generateError(MyError error){
        if(error.getO() instanceof NewAciton){
            if(error.getBroj() == 1){
                notify(error.getString());
            }else{
                notify(error.getString());
            }
        }else if(error.getO() instanceof EditAction){
            notify(error.getString());
        }else if(error.getO() instanceof DeleteAction){
            notify(error.getString());
        }else if(error.getO() instanceof MyTreeCellEditor){
            if(error.getBroj() == 1)
                notify(error.getString());
            else
                notify(error.getString());
        }else if(error.getO() instanceof EditSlotAction){
            notify(error.getString());
        }else if(error.getO() instanceof OpenPrezentacijaAction){
            notify(error.getString());
        }else if(error.getO() instanceof SavePrezentacijaAction){
            notify(error.getString());
        }else if(error.getO() instanceof SaveProjectAction){
            notify(error.getString());
        }
    }


    public static MyErrorFactory getInstance() {
        if(instance==null){
            instance = new MyErrorFactory();
        }
        return instance;
    }


    @Override
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
    }
}
