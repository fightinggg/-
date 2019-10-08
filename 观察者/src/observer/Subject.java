package observer;

public interface Subject {
    //添加观察者
    void addObserver(Observer obj);

    //移除观察者
    void deleteObserver(Observer obj);

    //通知观察者
    void notifyObserver();
}