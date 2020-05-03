package pers.penglan.ioc.dependencies;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.penglan.ioc.entity.dependencies.ArgumentMatching;

/**
 * @Author PENGL
 * 2020-03-02
 */
public class ArgMatchingContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pers/penglan/ioc/dependencies/config/argument-matching.xml");
        ArgumentMatching argumentMatching1 = context.getBean("argumentMatching1", ArgumentMatching.class);
        ArgumentMatching argumentMatching2 = context.getBean("argumentMatching2", ArgumentMatching.class);
        ArgumentMatching argumentMatching3 = context.getBean("argumentMatching3", ArgumentMatching.class);
        ArgumentMatching argumentMatching4 = context.getBean("argumentMatching4", ArgumentMatching.class);
        System.out.println(argumentMatching1);
        System.out.println(argumentMatching2);
        System.out.println(argumentMatching3);
        System.out.println(argumentMatching4);

    }
}
