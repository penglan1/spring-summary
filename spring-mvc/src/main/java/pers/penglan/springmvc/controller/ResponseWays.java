package pers.penglan.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author PENGL
 * 2020-03-10
 */
@Controller
@RequestMapping(path = "/resWays")
public class ResponseWays {

    /**
     * void返回类型的跳转
     *
     * 默认会在方法执行之后跳转到/springmvc/resWays/way1页面
     */
    @RequestMapping(path = "/way1")
    public void way1() {
        System.out.println("way1执行了");
    }

    /**
     * 使用servletAPI的方法进行调度
     *
     * @param request
     * @param response
     */
    @RequestMapping(path = "/way2")
    public void way2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("way2行了");
        request.getRequestDispatcher("/resWays/way3").forward(request, response);
    }

    /**
     * 使用return的方式进行跳转
     * 此方式需要视图解析器的帮忙
     *
     * @return
     */
    @RequestMapping(path = "/way3")
    public String way3(Model model) {
        model.addAttribute("message", "我经过了way3方法");
        System.out.println("way3执行了");
        return "success";
    }

    /**
     * void的方式，直接返回内容
     *
     * @param response
     * @throws Exception
     */
    @RequestMapping(path = "/way4")
    public void way4(HttpServletResponse response) throws Exception {
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write("你好");
        System.out.println("way4执行了");
    }

    /**
     * 使用关键字的方式来进行转发或者重定向
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/way5")
    public String way4() throws Exception {
        //使用重定向时，可以不需要加项目名，spring会为你自动添加
        //return "redirect:/index.jsp";
        return "forward:/WEB-INF/viewpages/jsp/success.jsp";
    }



}
