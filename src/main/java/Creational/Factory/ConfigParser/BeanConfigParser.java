package Creational.Factory.ConfigParser;

import Creational.Factory.BeanDefinition;

import java.io.InputStream;
import java.util.List;

/**
 * @author lyd
 * @Description
 * @create 2022-07-08-10:02
 */
public interface BeanConfigParser {
    List<BeanDefinition> parse(InputStream inputStream);
    //List<BeanDefinition> parse(String configContent);
}
