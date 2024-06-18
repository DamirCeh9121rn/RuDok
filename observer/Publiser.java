package observer;

public interface Publiser {
    void addSubscriber(Subscriber sub);
    void removeSubscriber(Subscriber sub);
    void notify(Object notification);
}
