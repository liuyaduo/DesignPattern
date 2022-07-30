package Behavioral.Observer.SynchronizationObserver;

/**
 * @author lyd
 * @Description
 * @create 2022-07-30-9:53
 */
public interface Subject {
    void register(Observer observer);
    void remove(Observer observer);
    void notifyAll(Message message);
}
