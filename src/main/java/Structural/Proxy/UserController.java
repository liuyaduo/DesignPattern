package Structural.Proxy;

/**
 * @author lyd
 * @Description
 * @create 2022-07-08-20:06
 */
public class UserController implements IUserController{


    public UserVo login(String telephone, String password) {
        UserVo userVo = new UserVo("login...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userVo;
    }

    public UserVo register(String telephone, String password) {
        UserVo userVo = new UserVo("register");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userVo;
    }

    public UserVo updateHeader(String telephone) {
        UserVo userVo = new UserVo("updateHeader");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userVo;
    }

}
