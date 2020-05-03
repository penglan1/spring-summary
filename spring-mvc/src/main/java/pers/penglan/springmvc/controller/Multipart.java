package pers.penglan.springmvc.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * 文件上传
 *
 * @Author PENGL
 * 2020-03-10
 */
@Controller
@RequestMapping(path = "multipart")
public class Multipart {

    /**
     * 使用fileupload组件来完成文件上传
     * @return
     */
    @RequestMapping("/fileupload")
    public String fileupload(HttpServletRequest request, Model model) throws Exception {
        String path = request.getServletContext().getRealPath("/uploads/");
        File directory = new File(path);
        if (!directory.exists())
            directory.mkdirs();

        //解析request对象，获取文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            if (item.isFormField()) { /*判断此item是否为普通表单域*/
                System.out.println(item.getString());
            } else {
                String filename = item.getName();
                //解决文件名重复
                /*String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;*/
                filename = System.currentTimeMillis() + "_" + filename;
                item.write(new File(directory, filename));
                item.delete();
            }
        }

        model.addAttribute("message", "文件上传成功");
        return "success";
    }

    /**
     * 使用spring mvc的文件解析器来实现文件的上传
     * 注意：需要先在spring配置文件中配置文件解析器
     *
     */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile[] items, Model model) throws Exception {
        String path = request.getServletContext().getRealPath("/uploads/");
        File directory = new File(path);
        if (!directory.exists())
            directory.mkdirs();

        for (MultipartFile item : items) {
            String filename = item.getOriginalFilename();
            //解决文件名重复
                /*String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;*/
            filename = System.currentTimeMillis() + "_" + filename;
            item.transferTo(new File(directory, filename));
            System.out.println("文件 " + filename + "上传成功！！！");
            model.addAttribute("message",
                    (model.getAttribute("message") == null ? "" : model.getAttribute("message"))
                    + filename + "上传成功！！！<br/>");
        }
        return "success";
    }
}
