package Behavioral.Observer.SynchronizationObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyd
 * @Description
 * @create 2022-07-30-9:59
 */
public class ConcreteSubject implements Subject{
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAll(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
