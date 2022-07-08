package CreationalTest;

import Creational.Factory.ApplicationContext;
import Creational.Factory.ClassPathXmlApplicationContext;
import Creational.Factory.RateLimiter;
import Creational.Factory.RedisCounter;
import org.junit.Test;

/**
 * @author lyd
 * @Description
 * @create 2022-07-08-9:19
 */
public class FactoryTest {

    @Test
    public void test() {
        System.out.println(RedisCounter.class.getClassLoader().getResource("").getPath());
    }

    @Test
    public void test2() {
        System.out.println(RateLimiter.class);
        System.out.println(RedisCounter.class);
    }

    @Test
    public void test3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        RateLimiter rateLimiter = (RateLimiter) applicationContext.getBean("rateLimiter");
        rateLimiter.test();

        RedisCounter redisCounter = (RedisCounter) applicationContext.getBean("redisCounter");
        redisCounter.test();
    }
}
