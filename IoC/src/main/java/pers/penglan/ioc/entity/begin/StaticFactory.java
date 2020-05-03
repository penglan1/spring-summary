package pers.penglan.ioc.entity.begin;

/**
 * @Author PENGL
 * 2020-03-02
 */
public class StaticFactory {
    public static A createA(String name) {
        A a = new A();
        a.setName(name);
        return a;
    }

    public static A createA() {
        return new A();
    }
}
