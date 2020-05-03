package pers.penglan.ioc.entity.dependencies;

import pers.penglan.ioc.entity.begin.A;

/**
 * @Author PENGL
 * 2020-03-03
 */
public class Ref {
    private String id = null;
    private String display = null;
    private A a = null;

    public Ref() {
    }

    public Ref(String id, String display, A a) {
        this.id = id;
        this.display = display;
        this.a = a;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Ref{" +
                "id='" + id + '\'' +
                ", display='" + display + '\'' +
                ", a=" + a +
                '}';
    }
}
