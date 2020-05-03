package pers.penglan.ioc.dependencies;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.penglan.ioc.entity.dependencies.MyCollections;

/**
 * @Author PENGL
 * 2020-03-03
 */
public class MyCollectionsContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pers/penglan/ioc/dependencies/config/mycollections.xml");
        MyCollections myCollections = (MyCollections) context.getBean("myCollections");
        System.out.println(myCollections);
        System.out.println("--------------------");
        MyCollections collectionsMerging = (MyCollections) context.getBean("collectionsMerging");
        System.out.println(collectionsMerging);
    }
}
