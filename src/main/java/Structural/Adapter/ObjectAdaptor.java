package Structural.Adapter;

/**
 * @author lyd
 * @Description 对象适配器：基于组合
 * @create 2022-07-09-12:06
 */
public class ObjectAdaptor implements ITarget{
    private Adaptee adaptee;

    public ObjectAdaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        this.adaptee.fa();
    }

    @Override
    public void f2() {
        //重新实现
        System.out.println("f2");
    }

    @Override
    //相比ClassAdaptor：不能复用父类的接口
    public void fc() {
        this.adaptee.fc();
    }
}
