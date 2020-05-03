package pers.penglan.springmvc.entity;

import java.io.Serializable;

/**
 * @Author PENGL
 * 2020-03-09
 */
public class Worker implements Serializable {
    private String name;
    private Integer age;
    private Person parent;

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", parent=" + parent +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person getParent() {
        return parent;
    }

    public void setParent(Person parent) {
        this.parent = parent;
    }
}
