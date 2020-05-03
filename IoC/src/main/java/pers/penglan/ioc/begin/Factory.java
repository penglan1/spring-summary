package pers.penglan.ioc.begin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.penglan.ioc.entity.begin.A;
import pers.penglan.ioc.entity.begin.B;

/**
 * @Author PENGL
 * 2020-03-02
 */
public class Factory {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pers/penglan/ioc/begin/config/factory.xml");
        A a = context.getBean("a", A.class);
        A a2 = context.getBean("a2", A.class);
        B b = context.getBean("b", B.class);
        B b2 = context.getBean("b2", B.class);
        System.out.println(a);
        System.out.println(a2);
        System.out.println(b);
        System.out.println(b2);
    }
}
