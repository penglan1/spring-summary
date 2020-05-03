package pers.penglan.ioc.dependencies;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.penglan.ioc.entity.begin.A;
import pers.penglan.ioc.entity.dependencies.LookUpMethod;

/**
 * 测试lookup method 拦截
 *
 * @Author PENGL
 * 2020-03-03
 */
public class LookUpMethodContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pers/penglan/ioc/dependencies/config/lookupmethod.xml");
        LookUpMethod lookUpMethod1 = (LookUpMethod) context.getBean("lookupMethod1");
        A a = lookUpMethod1.getA();
        System.out.println(a);
        LookUpMethod lookUpMethod2 = (LookUpMethod) context.getBean("lookupMethod2");
        A a2 = lookUpMethod2.getA();
        A a3 = lookUpMethod2.getA();
        System.out.println(a2);
        System.out.println(a3);
        System.out.println("a2 == a3 ? " + (a2 == a3));
    }
}
