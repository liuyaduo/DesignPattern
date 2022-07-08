package CreationalTest;

import Creational.Singleton;
import org.junit.Test;

/**
 * @author lyd
 * @Description
 * @create 2022-07-07-14:36
 */
public class SingletonTest {

    @Test
    public void test1() {
        System.out.println("hello test");
    }

    @Test
    public void test2() {
        Singleton singleton1 = Singleton.getSingleton();
        singleton1.test();
        Singleton singleton2 = Singleton.getSingleton();
        System.out.println(singleton1 == singleton2);
    }

    @Test
    public void test3() {
//        Singleton singleton = new Singleton();
//        singleton.testEnum();
    }
}
