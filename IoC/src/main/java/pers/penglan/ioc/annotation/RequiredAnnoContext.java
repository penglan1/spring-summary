package pers.penglan.ioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.penglan.ioc.entity.annotation.RequiredAnnotation;

/**
 * @Author PENGL
 * 2020-03-03
 */
public class RequiredAnnoContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pers/penglan/ioc/annotation/config/requiredannotation.xml");
        RequiredAnnotation requiredAnnotation = context.getBean("requiredAnnotion", RequiredAnnotation.class);
        System.out.println(requiredAnnotation);
    }
}
