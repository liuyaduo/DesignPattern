package Behavioral.Observer.EventBus;

import com.google.common.eventbus.Subscribe;

/**
 * @author lyd
 * @Description
 * @create 2022-07-30-10:56
 */
public class RegNotificationObserver {

    @Subscribe
    public void handleRegSuccess(Long userId) {
        System.out.println(String.format("正在给%d发送邮件", userId));
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送邮件结束");
    }
}
