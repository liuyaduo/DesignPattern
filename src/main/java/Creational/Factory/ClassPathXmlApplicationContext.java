package Creational.Factory;


import Creational.Factory.ConfigParser.BeanConfigParser;
import Creational.Factory.ConfigParser.XmlBeanConfigParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lyd
 * @Description
 * @create 2022-07-08-9:52
 */
public class ClassPathXmlApplicationContext implements ApplicationContext{
    private BeanConfigParser beanConfigParser;
    private BeansFactory beansFactory;

    /**
     * beanConfigParser负责解析xml文件，并利用每个bean的配置，初始化beanDefinition
     * beanFactory ： bean的工厂对象，负责基于beanDefinition创建对应的bean对象
     * @param configLocation
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        this.beansFactory = new BeansFactory();
        this.beanConfigParser = new XmlBeanConfigParser();
        loadBeanDefinitions(configLocation);
    }

    private void loadBeanDefinitions(String configLocation) {
        InputStream in = null;


        try {
            in = this.getClass().getResourceAsStream("/" + configLocation);
            if (in == null) {
                throw new RuntimeException("Can not find config file:" + configLocation);
            }
            List<BeanDefinition> beanDefinitions = beanConfigParser.parse(in);
            beansFactory.addBeanDefinitions(beanDefinitions);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println(e.getStackTrace());
                }
            }
        }

    }

    @Override
    public Object getBean(String beanId) {
        return beansFactory.getBean(beanId);
    }
}
