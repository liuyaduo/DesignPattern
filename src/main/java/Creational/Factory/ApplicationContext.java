package Creational.Factory;

/**
 * @author lyd
 * @Description
 * @create 2022-07-08-9:45
 */
public interface ApplicationContext {

    Object getBean(String beanId);

}
