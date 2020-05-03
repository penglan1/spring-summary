package pers.penglan.ioc.dependencies;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Enumeration;
import java.util.Properties;

/**
 * 测试Properties
 *
 * @Author PENGL
 * 2020-03-03
 */
public class PropertiesContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pers/penglan/ioc/dependencies/config/properties.xml");
        /*Properties properties = (Properties) context.getBean("properties");
        Enumeration enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String name = (String) enumeration.nextElement();
            System.out.println(name + ":" + properties.getProperty(name));
        }*/
    }
}
