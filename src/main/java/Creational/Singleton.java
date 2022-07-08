package Creational;

import java.io.Serializable;
import java.sql.SQLOutput;

/**
 * @author lyd
 * @Description 单例模式
 * @create 2022-07-07-14:30
 */
public class Singleton implements Serializable {
    /**
     * 1.饿汉式
     * static static方法只能调用static属性
     * final 修饰成员变量必须在定义时或者构造器中初始化；修饰局部变量可以稍后初始化
     * final避免引用被反射改变
     */
//    private static final Singleton singleton = new Singleton();
//
//    private Singleton() {}
//
//    public static Singleton getSingleton() {
//        System.out.println("饿汉式单例模式！");
//        return singleton;
//    }
//    //防止反序列化得到单例
//    public Object readSolve() {
//        return singleton;
//    }


    /**
     * 2. 懒汉式（双重检测）
     */
    // volatile : singleton = new Singleton()不是原子操作，分3步：1.分配空间2.初始化对象3.将引用指向地址空降；可能发生132的重排序导致在3时，另一个线程判断非空，得到一个空对象
//    private volatile static Singleton singleton = null;
//
//    private Singleton() {}
//
//    public static Singleton getSingleton() {
//        // 提高并发度
//        // 如果没有第一个判断，相当于在方法上加锁，每次获取实例都会阻塞
//        if (singleton == null) {
//
//            // 静态方法内部加类级别的锁
//            synchronized (Singleton.class) {
//
//                // 保证线程安全
//                // 如果没有第二个判断，两个线程同时进入第一个判断获取锁，会导致创建两个实例
//                if (singleton == null) {
//
//                    System.out.println("懒汉式单例模式！");
//                    singleton = new Singleton();
//
//                }
//            }
//
//        }
//        return singleton;
//
//    }


    //3.枚举单例
//    public Singleton() {}
//
//    EnumSingleton singleton = EnumSingleton.Instance;
//
//    public void testEnum() {
//        System.out.println(singleton);
//    }

    //4.静态内部类单例
    private Singleton() {}

    // 静态内部类是懒惰初始化，只有调用的时候才初始化
    // 静态实例保证只初始化一次
    // 声明为private防止在外部调用
    private static class Instance {
        static final Singleton singleton = new Singleton();
    }

    public static Singleton getSingleton() {
        return Instance.singleton;
    }

    public void test() {
        System.out.println("hello world");
    }



}

/**
 * 3.枚举单例
 * 由于美誉不可以new，也不可反射，故只需保证枚举类里面只有一个实例，就可以保证单例
 */
enum EnumSingleton {
    Instance("hello world", 1);

    private String name;
    private int age;
    EnumSingleton(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(Enum.class.getSuperclass());
        System.out.println(name + ' ' + age);
    }

    @Override
    public String toString() {
        return name + ' ' + age;
    }
}
