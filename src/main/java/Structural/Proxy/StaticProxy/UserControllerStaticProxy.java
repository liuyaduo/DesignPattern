package Structural.Proxy.StaticProxy;

import Structural.Proxy.UserController;
import Structural.Proxy.UserVo;

/**
 * @author lyd
 * @Description
 * 1. UserController的静态代理类
 * 计算服务的响应时间
 * 2. 缺点：
 * 2.1 每个类都需要创建一个代理类，如果要添加功能的原始类很多，则项目中类的个数成倍增加，增加维护成本
 * 2.2 每个方法都要附加相同的代码逻辑，
 * @create 2022-07-08-20:14
 */
public class UserControllerStaticProxy extends UserController {

    @Override
    public UserVo login(String telephone, String password) {
        long startTimeStamp = System.currentTimeMillis();

        UserVo userVo = super.login(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimeStamp;
        System.out.println("login" + " cost: " + responseTime);

        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTimeStamp = System.currentTimeMillis();

        UserVo userVo = super.register(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimeStamp;
        System.out.println("register" + " cost: " + responseTime);

        return userVo;
    }
}
