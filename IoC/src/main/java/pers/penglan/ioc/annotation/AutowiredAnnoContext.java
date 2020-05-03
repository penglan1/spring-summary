package pers.penglan.ioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.penglan.ioc.entity.annotation.AutowiredAnno;
import pers.penglan.ioc.entity.annotation.RequiredAnnotation;

/**
 * @Author PENGL
 * 2020-03-07
 */
public class AutowiredAnnoContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pers/penglan/ioc/annotation/config/autowired.xml");
        AutowiredAnno autowiredAnno = context.getBean("autowiredAnno", AutowiredAnno.class);
        System.out.println(autowiredAnno);
    }
}
