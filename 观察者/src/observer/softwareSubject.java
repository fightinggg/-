package observer;

import java.util.ArrayList;
import java.util.List;

public class softwareSubject implements Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private int version;

    public void addObserver(Observer obj) {
        observers.add(obj);
    }

    public void deleteObserver(Observer obj) {
        if (observers.indexOf(obj) >= 0) observers.remove(obj);
    }

    public void notifyObserver() {
        for(Observer o:observers)o.update(version);
    }

    void publish() {
        this.version++;
        notifyObserver();
    }
}