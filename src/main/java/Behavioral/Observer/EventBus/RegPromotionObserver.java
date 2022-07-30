package Behavioral.Observer.EventBus;

import com.google.common.eventbus.Subscribe;

/**
 * @author lyd
 * @Description
 * @create 2022-07-30-10:54
 */
public class RegPromotionObserver {

    @Subscribe
    public void handleRegSuccess(Long userId) {
        System.out.println(String.format("正在给%d发送优惠券", userId));
        try {
            Thread.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送优惠券结束");
    }

}
