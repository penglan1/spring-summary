package pers.penglan.ioc.dependencies;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.penglan.ioc.entity.dependencies.Ref;

/**
 * 测试配置文件中的ref和idref引用属性
 *
 * @Author PENGL
 * 2020-03-03
 */
public class RefContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pers/penglan/ioc/dependencies/config/ref.xml");
        Ref ref = (Ref) context.getBean("ref");
        System.out.println(ref);
    }
}
