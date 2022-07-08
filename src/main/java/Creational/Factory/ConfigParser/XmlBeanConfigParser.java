package Creational.Factory.ConfigParser;

import Creational.Factory.BeanDefinition;
import com.sun.jmx.snmp.SnmpString;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lyd
 * @Description
 * @create 2022-07-08-10:09
 */
public class XmlBeanConfigParser implements BeanConfigParser{
    private SAXReader reader;

    public XmlBeanConfigParser() {
        reader = new SAXReader();
    }

    @Override
    public List<BeanDefinition> parse(InputStream inputStream) {
        String content = null;

//            InputStreamReader reader = new InputStreamReader(inputStream);
//            BufferedReader bufferedReader = new BufferedReader(reader);
//            StringBuilder stringBuilder = new StringBuilder();
//            String line = null;
//            while ((line = bufferedReader.readLine()) != null) {
//                stringBuilder.append(line);
//            }
//            content = stringBuilder.toString();
//            System.out.println(content);
        try {
            Document document = reader.read(inputStream);
            Element rootElement = document.getRootElement();
            List<Element> rootSubElements = rootElement.elements();
            List<BeanDefinition> beanDefinitions = new ArrayList<>(rootSubElements.size());

            for (Element rootSubElement : rootSubElements) {
                // 获得所有属性
                BeanDefinition beanDefinition = new BeanDefinition();
                String id = rootSubElement.attributeValue("id");
                String className = rootSubElement.attributeValue("class");
                beanDefinition.setId(id);
                beanDefinition.setClassName(className);
                String scope = rootSubElement.attributeValue("scope");
                if (scope != null) {
                    if (scope.equals("singleton")) {
                        beanDefinition.setScope(BeanDefinition.Scope.SINGLETON);
                    } else {
                        beanDefinition.setScope(BeanDefinition.Scope.PROTOTYPE);
                    }
                }
                String initString = rootSubElement.attributeValue("laze-init");
                if (initString != null) {
                    beanDefinition.setLazyInit(Boolean.parseBoolean(initString));
                }

                List<Element> SubElementList = rootSubElement.elements();
                for (Element subElement : SubElementList) {
                    BeanDefinition.ConstructorArg constructorArg = new BeanDefinition.ConstructorArg();

                    String ref = subElement.attributeValue("ref");
                    constructorArg.setRef(ref != null);
                    String typeName = subElement.attributeValue("type");
                    if (typeName != null) {
                        try {
                            Class type = ClassLoader.getSystemClassLoader().loadClass(typeName);
                            constructorArg.setType(type);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    Object value = subElement.attributeValue("value");
                    if (value != null) {
                        if (typeName.equals("java.lang.Integer") || typeName.equals("int")) {
                            value = Integer.parseInt((String) value);
                        }
                        constructorArg.setArg(value);
                    } else {
                        constructorArg.setArg(ref);
                    }
                    beanDefinition.getConstructorArgs().add(constructorArg);
                }
                beanDefinitions.add(beanDefinition);
            }

            return beanDefinitions;

        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return null;
    }

}
