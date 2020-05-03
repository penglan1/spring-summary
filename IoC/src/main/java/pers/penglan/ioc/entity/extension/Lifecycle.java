package pers.penglan.ioc.entity.extension;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author PENGL
 * 2020-03-03
 */
public class Lifecycle {
    private String name = null;

    public void init() {
        System.out.println(name + " init...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy...");
    }

    public void destroy() {
        System.out.println(name + " destroy...");
    }

    public Lifecycle() {
        System.out.println("构造...");
    }

    public Lifecycle(String name) {
        this.name = name;
        System.out.println(name + " 构造...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("setName调用");
    }

    @Override
    public String toString() {
        return "Lifecycle{" +
                "name='" + name + '\'' +
                '}';
    }
}
