package pers.penglan.springmvc.controller;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.penglan.springmvc.entity.A;
import pers.penglan.springmvc.entity.Person;
import pers.penglan.springmvc.entity.Worker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

/**
 * @Author PENGL
 * 2020-03-10
 */
@Controller
@RequestMapping(path = "/ajax")
public class Ajax {
    /**
     * spring mvc可以利用jackson将传输过来的json数据疯转称为指定的对象
     * @param worker
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/header")
    @ResponseBody/*总报错，找不出来哪里错了。用Gson吧*/ /*因为我打开了字符流，但是json后面又使用字节流，所以报错了*/
    public Object header(@RequestBody Worker worker, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(worker);
        //request.setCharacterEncoding("UTF-8");
        //response.setContentType("application/json; charset=UTF-8");

        /*这里不能使用LinkedHashMap, 否则转换为数组之后被gson解析时会
        报错java.lang.StackOverflowError，使用HashMap时却不会，我怀疑
        有可能是因为LinkedHashMap.entrySet().toArray()返回的数组与
        HashMap.entrySet().toArray()返回的数组内部数据结构是不一样的。
        */
        List<Object> list = new ArrayList<>();

        //response.getOutputStream();

        Collection<String> collection = response.getHeaderNames();
        for (String name : collection) {
            Map<String, String> map = new HashMap<>();
            map.put("key", name);
            map.put("value", response.getHeader(name));
            list.add(map);
        }

        System.out.println("执行结束...");
        //response.getWriter().write(new Gson().toJson(arr));
        return list;
    }

    @RequestMapping(value = "/json")
    @ResponseBody
    public Worker retJson(HttpServletResponse response) {
        Worker worker = new Worker();
        worker.setName("杜甫");
        worker.setParent(new Person());
        response.setCharacterEncoding("GBK");
        return worker;
    }
}
