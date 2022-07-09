package StructuralTest;

import Structural.Proxy.DynamicProxy.MetricsProxy;
import Structural.Proxy.IUserController;
import Structural.Proxy.StaticProxy.UserControllerStaticProxy;
import Structural.Proxy.UserController;
import Structural.Proxy.UserVo;
import org.junit.Test;

/**
 * @author lyd
 * @Description
 * @create 2022-07-08-20:26
 */
public class ProxyTest {

    @Test
    public void testStaticProxy() {
        UserController userController = new UserControllerStaticProxy();
        userController.login("13255398852", "123456");
        userController.register("13255398852", "123456");
    }

    @Test
    public void testDynamicProxy() {
        MetricsProxy metricsProxy = new MetricsProxy();
        IUserController userController = (IUserController) metricsProxy.createProxy(new UserController());
        UserVo login = userController.login("13255398852", "123456");
        UserVo register = userController.register("13255398852", "123456");
    }
}
