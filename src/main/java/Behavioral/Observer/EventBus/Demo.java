package Behavioral.Observer.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyd
 * @Description
 * @create 2022-07-30-10:59
 */
public class Demo {
    public static void main(String[] args) {
        UserController userController = new UserController();
        List<Object> observers = new ArrayList<>();
        observers.add(new RegPromotionObserver());
        observers.add(new RegNotificationObserver());
        userController.setRegObserver(observers);
        long userId = userController.register("13211002145", "123456");
        System.out.println("注册用户ID：" + userId);
    }
}
