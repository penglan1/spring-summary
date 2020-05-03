package pers.penglan.springmvc.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.penglan.springmvc.entity.A;
import pers.penglan.springmvc.entity.Student;
import pers.penglan.springmvc.entity.Worker;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author PENGL
 * 2020-03-09
 */
@Controller
@RequestMapping(path = "/parambind", params = {"flag=param"})
public class ParamBind {

    /**
     * 字符参数绑定
     *
     * @param username
     * @return
     */
    @RequestMapping(path = "/username")
    public String username(String username) {
        System.out.println("usrename: " + username);
        return "success";
    }

    /**
     * 对象参数绑定
     *
     * @param s
     * @return
     */
    @RequestMapping(path = "/object")
    public String objectBind(Student s) {
        if (s != null) {
            System.out.println(s);
        }
        return "success";
    }

    /**
     * 嵌套式对象参数绑定
     *
     * @param w
     * @return
     */
    @RequestMapping(path = "/object2")
    public String objectBind(Worker w) {
        if (w != null) {
            System.out.println(w);
        }
        return "success";
    }

    /**
     * 需要使用到类型转换器的参数绑定
     *
     * 由于参数A类型中涉及到String转换为Date的操作，所以必须要在springmvc.xml配置文件中将自定义的
     * 类型转换器注册到spring的上下文中
     * @param a
     * @return
     */
    @RequestMapping(path = "/object3")
    public String objectBind(A a) {
        if (a != null) {
            System.out.println(a);
        }
        return "success";
    }

    /**
     * 使用servlet api中的参数进行绑定
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(path = "/servletapi")
    public String objectBind(HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = request.getServletContext();
        ApplicationContext applicationContext = (ApplicationContext) context.getAttribute("ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE");
        System.out.println(applicationContext);
        request.setAttribute("message", "如果没有使用spring和spring mvc进行整合，后台输出的应该是null");
        return "success";
    }
}
