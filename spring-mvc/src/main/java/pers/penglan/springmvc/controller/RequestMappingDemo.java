package pers.penglan.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author PENGL
 * 2020-03-09
 */
@Controller
/*使用类级别的requestMapping*/
@RequestMapping(path = "/start")
public class RequestMappingDemo {

    /**
     * 路径：/start/rmp
     *
     * 带有指定键值对时才会执行该方法
     * @return
     */
    @RequestMapping(path = "/rmp", params = {"flag=1"})
    public String testRequestMapping() {
        System.out.println("测试RequestMapping注解......");
        return "success";
    }



}
