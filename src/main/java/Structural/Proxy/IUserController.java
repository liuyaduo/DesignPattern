package Structural.Proxy;

/**
 * @author lyd
 * @Description
 * @create 2022-07-08-20:06
 */
public interface IUserController {
    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);
}
