package pers.penglan.ioc.entity.begin;

/**
 * @Author PENGL
 * 2020-03-02
 */
public class InstanceFactory {
    public B createB(String name) {
        B b = new B();
        b.setName(name);
        return b;
    }

    public B createB() {
        return new B();
    }
}
