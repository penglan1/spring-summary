package pers.penglan.ioc.begin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.penglan.ioc.entity.begin.B;

/**
 * Application Context
 *
 * @Author PENGL
 * 2020-03-02
 */
public class BContext {
    public static void main(String[] args) {
        /*configLocation无论是否在开头加斜杠都可以*/
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:pers/penglan/ioc/begin/config/b.xml");
        B b = (B) context.getBean("b");
        System.out.println(b);
    }
}
