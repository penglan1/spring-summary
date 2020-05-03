package pers.penglan.ioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.penglan.ioc.entity.extension.Lifecycle;

/**
 * @Author PENGL
 * 2020-03-07
 */
public class PrePostAnnoContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pers/penglan/ioc/annotation/config/pre-post-annoation.xml");
        Lifecycle lifecycle = context.getBean("lifecycle", Lifecycle.class);
        System.out.println(lifecycle);

    }
}
