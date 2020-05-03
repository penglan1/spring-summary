package pers.penglan.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author PENGL
 * 2020-03-10
 */
@Controller
@RequestMapping("/anno2")
@SessionAttributes({"a"})
public class Annotations2 {
    /**
     * 使用Model或者ModelMap存入属性，个人认为，他们的实际类型至少是ImplicitModel或者其子类
     *
     * Model或ModelMap中的属性最终会加入到request域中，或者是session中（如果在Handler中使用
     * 了@SessionAttributes注解）
     *
     * @param model
     * @return
     */
    @RequestMapping(path = "/model")
    public String modelAttribute(Model model, HttpServletRequest request) {
        model.addAttribute("message", "存入进了request域中");
        model.addAttribute("a", "我在session域中");
        HttpSession session = request.getSession();
        /*和model加入到request域中类相似，时机都是一样的，所以第一次这里获取不到a的值*/
        System.out.println("a: " + session.getAttribute("a"));
        return "success";
    }

    /**
     * 将session中的内容清楚
     *
     * @param status
     * @param model
     * @return
     */
    @RequestMapping(path = "/clear")
    public String modelAttribute(SessionStatus status, Model model, HttpServletRequest request) {
        model.addAttribute("message", "清空了内容");
        status.setComplete();
        HttpSession session = request.getSession();
        /*和加入时的机是类似的，所以第一次这里能够获取到a的值*/
        System.out.println("a: " + session.getAttribute("a"));
        /*这里也可以暂时的获取到*/
        System.out.println(((ModelMap) model).get("a"));
        return "success";
    }
}
