package Creational.Factory;

import javax.management.RuntimeMBeanException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lyd
 * @Description
 * @create 2022-07-08-10:45
 */
public class BeansFactory {
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>();

    public void addBeanDefinitions(List<BeanDefinition> beanDefinitionList) {
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            this.beanDefinitions.putIfAbsent(beanDefinition.getId(), beanDefinition);
        }

        for (BeanDefinition beanDefinition : beanDefinitionList) {
            // 不是懒惰初始化并且为单例，则现在创建bean
            if (!beanDefinition.isLazyInit() && beanDefinition.isSingleton()) {
                createBean(beanDefinition);
            }
        }
    }

    /**
     * 基于工厂类得到bean对象
     * @param beanId
     * @return
     */
    public Object getBean(String beanId) {
        BeanDefinition beanDefinition = beanDefinitions.get(beanId);
        if (beanDefinition == null) {
            throw new RuntimeException("Bean is not defined: " + beanId);
        }
        return createBean(beanDefinition);
    }

    /**
     * 核心方法：基于bean的配置类，创建对象
     * @param beanDefinition
     * @return
     */
    protected Object createBean(BeanDefinition beanDefinition) {
        if (beanDefinition.isSingleton() && singletonObjects.contains(beanDefinition.getId())) {
            return singletonObjects.get(beanDefinition.getId());
        }

        Object bean = null;

        try {
            // 反射
            Class beanClass = Class.forName(beanDefinition.getClassName());
            List<BeanDefinition.ConstructorArg> constructorArgs = beanDefinition.getConstructorArgs();
            if (constructorArgs.isEmpty()) {
                // 空参构造器
                bean = beanClass.newInstance();
            } else {
                // 有参构造器，需要根据参数类型getConstructor
                // 参数列表的反射Class数组
                Class[] argClasses = new Class[constructorArgs.size()];
                // 每个参数的对象数组
                Object[] args = new Object[constructorArgs.size()];
                for (int i = 0; i < constructorArgs.size(); i++) {
                    BeanDefinition.ConstructorArg constructorArg = constructorArgs.get(i);
                    if (!constructorArg.isRef()) {
                        // 不是引用类型可以直接赋值
                        argClasses[i] = constructorArg.getType();
                        args[i] = constructorArg.getArg();
                    } else {
                        // 是引用类型：需要！！递归！！创建对象
                        BeanDefinition refBeanDefinition = beanDefinitions.get(constructorArg.getArg());
                        if (refBeanDefinition == null) {
                            throw new RuntimeException("NO SUCH Bean Definition：" + args[i]);
                        }
                        argClasses[i] = Class.forName(refBeanDefinition.getClassName());
                        // 递归创建对象
                        args[i] = createBean(refBeanDefinition);
                    }
                }
                bean = beanClass.getConstructor(argClasses).newInstance(args);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        if (bean != null && beanDefinition.isSingleton()) {
            singletonObjects.putIfAbsent(beanDefinition.getId(), bean);
            return singletonObjects.get(beanDefinition.getId());
        }

        return bean;
    }
}
