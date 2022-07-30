package Behavioral.Observer.SynchronizationObserver;

/**
 * @author lyd
 * @Description
 * @create 2022-07-30-10:01
 */
public class ConcreteObserverTwo implements Observer{
    @Override
    public void update(Message message) {
        System.out.println(message.getMessage());
        System.out.println("ConcreteObserverTwo doing...");
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ConcreteObserverTwo done");
    }
}
