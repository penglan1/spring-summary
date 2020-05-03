package pers.penglan.ioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.penglan.ioc.entity.annotation.MyComponent;
import pers.penglan.ioc.entity.extension.Lifecycle;

/**
 * @Author PENGL
 * 2020-03-07
 */
public class MyComponentContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pers/penglan/ioc/annotation/config/component.xml");
        MyComponent myComponent = context.getBean("PENGL", MyComponent.class);
        System.out.println(myComponent);

    }
}
