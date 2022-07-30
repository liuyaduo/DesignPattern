package Behavioral.Observer.SynchronizationObserver;

/**
 * @author lyd
 * @Description
 * @create 2022-07-30-9:54
 */
public class Message {
    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
