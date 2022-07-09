package Structural.Proxy.DynamicProxy;

import Structural.Proxy.UserController;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lyd
 * @Description
 * @create 2022-07-08-20:35
 */
public class MetricsProxy {

    public Object createProxy(Object proxiedObject) {
        // 被代理类实现的所有接口
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, dynamicProxyHandler);
    }

    private class DynamicProxyHandler implements InvocationHandler {

        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            long startTimeStamp = System.currentTimeMillis();
            Object result = method.invoke(proxiedObject, args);
            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimeStamp;
            System.out.println(proxiedObject.getClass().getName() + "'s " + method.getName() + " method cost " + responseTime);
            return result;

        }
    }

}
