package pers.penglan.ioc.extension.beanfactorypostprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.penglan.ioc.entity.extension.MyDataSoure;

/**
 * @Author PENGL
 * 2020-03-05
 */
public class BeanFactoryPostProcessorContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pers/penglan/ioc/extension/config/beanfactorypostprocessor.xml");
        MyDataSoure myDataSoure = context.getBean("myDataSource", MyDataSoure.class);
        System.out.println(myDataSoure);
    }
}
