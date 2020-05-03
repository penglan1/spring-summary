package pers.penglan.ioc.entity.dependencies;

import pers.penglan.ioc.entity.begin.A;

/**
 * @Author PENGL
 * 2020-03-03
 */
public class LookUpMethod {
    private A a = null;

    public LookUpMethod() {
    }

    public LookUpMethod(A a) {
        this.a = a;
    }

    /*这个方法如果通过lookup method的方式被拦截重写，则这里即使返回null也不会对子类有影响*/
    /*If the method is abstract, the dynamically-generated subclass implements the method. Otherwise,
    the dynamically-generated subclass overrides the concrete method defined in the original class.*/
    public A getA() {
        return null;
    }

    public void setA(A a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "LookUpMethod{" +
                "a=" + a +
                '}';
    }

}
