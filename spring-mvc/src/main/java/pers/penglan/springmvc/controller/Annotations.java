package pers.penglan.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pers.penglan.springmvc.entity.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author PENGL
 * 2020-03-09
 */
@Controller
@RequestMapping(path = "/anno")
public class Annotations {

    /**
     * 给请求中的username参数名起别名，即uName参数可以被该方法识别并获取到
     *
     * @param username
     * @return
     */
    @RequestMapping(path = "/username")
    public String username(@RequestParam(name = "uName", required = false) String username, HttpServletRequest request) {
        System.out.println(username);
        request.setAttribute("message", "uName=" + username);
        return "success";
    }

    /**
     * 将body参数绑定到请求体
     * 如果请求体中含有中文字符串，将会得到原生的未解码的字符串，因此需要手动的对其进行解码
     *
     * 常用于Json的数据交换
     * @param body
     * @param request
     * @return
     */
    @RequestMapping(path = "/body")
    public String body(@RequestBody String body, HttpServletRequest request) {
        request.setAttribute("message", body);
        System.out.println("request body: " + body);
        return "success";
    }

    /**
     * 带有占位符的路径，用于支持Restful风格
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(path = "/restful/{id}")
    public String restful(@PathVariable String id, HttpServletRequest request) {
        request.setAttribute("message", id);
        System.out.println("{id}: " + id);
        return "success";
    }

    /**
     * 获取请求头的信息，将其绑定到参数中
     *
     * @param header
     * @param request
     * @return
     */
    @RequestMapping(path = "/header")
    public String header(@RequestHeader(name = "accept") String header, HttpServletRequest request) {
        request.setAttribute("message", header);
        System.out.println("accept: " + header);
        return "success";
    }

    /**
     * 获取到cookie的值
     *
     * @param cookieValue
     * @param request
     * @return
     */
    @RequestMapping(path = "/cookie")
    public String cookie(@CookieValue(name = "JSESSIONID") String cookieValue, HttpServletRequest request) {
        request.setAttribute("message", cookieValue);
        System.out.println("cookieValue: " + cookieValue);
        return "success";
    }

    @RequestMapping(path = "/modelAttribute")
    public String modelAttribute(@ModelAttribute("student") Student student, HttpServletRequest request, Model model) {
        request.setAttribute("message", request.getAttribute("message") + "Model Attribute执行...1<br/>" + student);
        System.out.println(student);
        System.out.println(model.getAttribute("student"));
        //在执行view时（即JSP），才会将ImplicitModel保存到Request域中，所以现在暂时获取不到值
        System.out.println(request.getAttribute("student"));
        return "success";
    }

    /**
     * 这个方法会先执行
     * 具体解释，看note.md
     *
     * 使用场景：例如，用于完善表单数据，或者对数据预先处理
     * @param request
     * @return Student
     */
    @ModelAttribute(name = "student")
    public Student modifyStudent(String name, HttpServletRequest request) {
        request.setAttribute("message", request.getAttribute("message") + "Model Attribute执行...2<br/>");

        Student s = new Student();
        if (s.getName() == null) {
            s.setName("黎明");
        }
        if (s.getAge() == null)
            s.setAge(25);
        if (s.getGrade() == null)
            s.setGrade(9);
        System.out.println(s);
        return s;
    }





}
