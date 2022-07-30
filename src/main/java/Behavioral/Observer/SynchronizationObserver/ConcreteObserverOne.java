package Behavioral.Observer.SynchronizationObserver;

/**
 * @author lyd
 * @Description
 * @create 2022-07-30-10:01
 */
public class ConcreteObserverOne implements Observer{
    @Override
    public void update(Message message) {
        System.out.println(message.getMessage());
        System.out.println("ConcreteObserverOne doing...");
        try {
            Thread.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ConcreteObserverOne done");
    }
}
