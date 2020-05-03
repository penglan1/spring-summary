package pers.penglan.springmvc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author PENGL
 * 2020-03-09
 */
public class A implements Serializable {
    private String name;
    private Integer age;
    private Date birthday;
    private Person parent;

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", parent=" + parent +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setParent(Person parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Person getParent() {
        return parent;
    }
}
