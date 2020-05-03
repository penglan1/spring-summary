package pers.penglan.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author PENGL
 * 2020-03-09
 */
@Controller
public class HelloController {

    /**
     * 入门案例
     * @return
     */
    @RequestMapping(path = "/hello",
            method = {RequestMethod.PUT, RequestMethod.GET})
    public String sayHello() {
        System.out.println("Hello, Spring MVC");
        return "success";
    }

    @RequestMapping(path = "/lib/js/myAjax.js",
            method = {RequestMethod.PUT, RequestMethod.GET})
    public String staticResources() {
        System.out.println("这个覆盖了静态资源");
        return "success";
    }

}
