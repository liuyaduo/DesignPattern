package Structural.Adapter;

/**
 * @author lyd
 * @Description 不兼容，需要被适配
 * @create 2022-07-09-12:04
 */
public class Adaptee {

    public void fa() {
        System.out.println("fa");
    }

    public void fb() {
        System.out.println("fb");
    }

    public void fc(){
        System.out.println("fc");
    }
}
