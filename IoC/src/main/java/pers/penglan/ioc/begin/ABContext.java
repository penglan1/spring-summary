package pers.penglan.ioc.begin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.penglan.ioc.entity.begin.A;
import pers.penglan.ioc.entity.begin.B;

/**
 * Application Context
 *
 * @Author PENGL
 * 2020-03-02
 */
public class ABContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pers/penglan/ioc/begin/config/a.xml", "pers/penglan/ioc/begin/config/b.xml");
        A a = (A) context.getBean("a");
        B b = (B) context.getBean("b");
        System.out.println(a);
        System.out.println(b);
        System.out.println("-----------------------------");
        context = null;
        context = new ClassPathXmlApplicationContext("classpath:pers/penglan/ioc/begin/config/ab.xml");
        /*Using the method T getBean(String name, Class<T> requiredType) you can retrieve instances
        of your beans.*/
        a = context.getBean("a", A.class);
        b = context.getBean("b", B.class);
        System.out.println(a);
        System.out.println(b);
    }
}
