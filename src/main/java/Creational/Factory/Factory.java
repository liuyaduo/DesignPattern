package Creational.Factory;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author lyd
 * @Description 工厂模式
 * @create 2022-07-07-18:44
 */
public class Factory {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        RateLimiter rateLimiter = (RateLimiter) applicationContext.getBean("rateLimiter");
        rateLimiter.test();

        RedisCounter redisCounter = (RedisCounter) applicationContext.getBean("redisCounter");
        redisCounter.test();

    }

}
