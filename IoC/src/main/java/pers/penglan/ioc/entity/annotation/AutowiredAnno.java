package pers.penglan.ioc.entity.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import pers.penglan.ioc.entity.begin.A;

/**
 * @Author PENGL
 * 2020-03-07
 */
public class AutowiredAnno {
    @Autowired
    private String name;
    @Autowired
    private int age;
    /*@Autowired*/
    private A a;

    /*使用这个注解时，必须要在spring配置文件中注册RequiredAnnotationBeanPostProcessor处理器，否则不起作用。
    * 标签<context:annotation-config/>的使用并不负责对此注解的处理*/
    @Required
    public void setA(A a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "AutowiredAnno{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", a=" + a +
                '}';
    }
}
