package Behavioral.Observer.SynchronizationObserver;

/**
 * @author lyd
 * @Description
 * 实现同步阻塞的观察者模式(发布/订阅模式)
 * 给每个观察者发消息是同步阻塞的，可以通过线程或者消息队列改为异步非阻塞
 * 观察者模式：在对象之间定义一对多的依赖，当一个对象状态改变的时候，所有依赖的对象都会收到通知。
 * @create 2022-07-30-9:48
 */
public class Demo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.register(new ConcreteObserverOne());
        subject.register(new ConcreteObserverTwo());
        subject.notifyAll(new Message("subject changed some thing"));
    }
}
