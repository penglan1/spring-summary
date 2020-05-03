package pers.penglan.ioc.dependencies;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.penglan.ioc.entity.dependencies.PAndCNamespace;

/**
 * @Author PENGL
 * 2020-03-03
 */
public class PAndCNamespaceContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pers/penglan/ioc/dependencies/config/p-c-namespace.xml");
        PAndCNamespace pAndCNamespace = context.getBean("pAndCNamespace", PAndCNamespace.class);
        PAndCNamespace pAndCNamespace2 = context.getBean("pAndCNamespace2", PAndCNamespace.class);
        System.out.println(pAndCNamespace);
        System.out.println(pAndCNamespace2);

    }
}
