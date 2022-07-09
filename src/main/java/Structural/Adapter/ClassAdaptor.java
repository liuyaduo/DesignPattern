package Structural.Adapter;

/**
 * @author lyd
 * @Description 类适配器:基于继承
 * @create 2022-07-09-12:06
 */
public class ClassAdaptor extends Adaptee implements ITarget{

    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        //重新实现f2
        System.out.println("f2");
    }

    // fc直接接重用Adaptee的fc
}
