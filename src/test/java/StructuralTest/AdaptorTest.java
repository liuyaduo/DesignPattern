package StructuralTest;

import Structural.Adapter.Adaptee;
import Structural.Adapter.ClassAdaptor;
import Structural.Adapter.ITarget;
import Structural.Adapter.ObjectAdaptor;
import org.junit.Test;

/**
 * @author lyd
 * @Description
 * @create 2022-07-09-12:28
 */
public class AdaptorTest {
    
    @Test
    public void testClassAdaptor() {
        ITarget classAdaptor = new ClassAdaptor();
        classAdaptor.f1();
        classAdaptor.f2();
        classAdaptor.fc();
    }

    @Test
    public void testObjectAdaptor() {
        ITarget objectAdaptor = new ObjectAdaptor(new Adaptee());
        objectAdaptor.f1();
        objectAdaptor.f2();
        objectAdaptor.fc();
    }
}
