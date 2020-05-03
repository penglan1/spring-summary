package pers.penglan.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试拦截器
 *
 * @Author PENGL
 * 2020-03-10
 */
@Controller
@RequestMapping("/login")
public class Login {

    @RequestMapping("/login")
    public String login(Model model) {
        System.out.println("login 处理完成");
        model.addAttribute("message", "login 处理完成!!!");
        return "success";
    }

}
