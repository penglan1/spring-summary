package pers.penglan.ioc.begin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.penglan.ioc.entity.begin.A;

/**
 * Alias测试
 * @Author PENGL
 * 2020-03-02
 */
public class AliasContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pers/penglan/ioc/begin/config/alias.xml");
        A a = context.getBean("a", A.class);
        A a2 = context.getBean("a2", A.class);
        A a3 = context.getBean("a3", A.class);
        /*在单例模式下，以下会输出 true*/
        System.out.println((a == a2 && a2 == a3));
    }
}
