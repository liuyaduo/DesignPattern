package Behavioral.Observer.EventBus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;

/**
 * @author lyd
 * @Description
 * @create 2022-07-30-10:30
 */
public class UserController {

    private EventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    UserController() {
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
        //eventBus = new EventBus();
    }

    public void setRegObserver(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }

    }

    public long register(String phone, String password) {
        long userId = Long.parseLong(phone);
        System.out.println(String.format("%d = userService.register(%s, %s)", userId, phone, password));

        eventBus.post(userId);

        return userId;
    }

}
