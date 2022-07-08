package CreationalTest;

import Creational.builder.ResourcePoolConfig;
import org.junit.Test;

/**
 * @author lyd
 * @Description
 * @create 2022-07-08-16:55
 */
public class BuilderTest {

    @Test
    public void test() {
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setName("config1")
                .setMaxTotal(10)
                .setMaxIdle(8)
                .setMinIdle(2)
                .build();
    }

    @Test
    public void test2() {
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setMaxTotal(10)
                .setMaxIdle(8)
                .setMinIdle(2)
                .build();
    }

    @Test
    public void test3() {
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setName("config1")
                .setMaxTotal(7)
                .setMaxIdle(8)
                .setMinIdle(2)
                .build();
    }
}
