package pers.penglan.ioc.entity.annotation;

import org.springframework.stereotype.Service;
import pers.penglan.ioc.entity.begin.A;
import pers.penglan.ioc.entity.begin.B;

import javax.annotation.Resource;

/**
 * @Author PENGL
 * 2020-03-07
 */

@Service(value = "PENGL")
public class MyComponent {
    @Resource(name = "a")
    private A a;

    @Resource(name = "b")
    private B b;

    @Override
    public String toString() {
        return "MyComponent{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
