package pers.penglan.ioc.begin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.penglan.ioc.entity.begin.A;

/**
 * Application Context
 *
 * @Author PENGL
 * 2020-03-02
 */
public class AContext {
    public static void main(String[] args) {
        /*configLocation无论是否在开头加斜杠都可以*/
        ApplicationContext context = new ClassPathXmlApplicationContext("pers/penglan/ioc/begin/config/a.xml");
        A a = (A) context.getBean("a");
        System.out.println(a);
    }
}
