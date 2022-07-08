package Creational.Factory;

/**
 * @author lyd
 * @Description
 * @create 2022-07-08-9:02
 */
public class RateLimiter {
    private RedisCounter redisCounter;
    public RateLimiter(RedisCounter redisCounter) {
        this.redisCounter = redisCounter;
    }
    public void test() {
        System.out.println("hello RateLimiter");
        System.out.println(redisCounter);
    }
    //...
}
