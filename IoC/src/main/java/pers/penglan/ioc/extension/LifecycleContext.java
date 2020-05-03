package pers.penglan.ioc.extension;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.penglan.ioc.entity.extension.Lifecycle;

/**
 * @Author PENGL
 * 2020-03-03
 */
public class LifecycleContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pers/penglan/ioc/extension/config/lefecycle.xml");
        Lifecycle lifecycle = context.getBean("lifecycle", Lifecycle.class);
        System.out.println(lifecycle);
        Lifecycle lifecycle2 = context.getBean("lifecycle2", Lifecycle.class);
        System.out.println(lifecycle2);
    }
}
