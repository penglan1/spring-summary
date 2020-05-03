package pers.penglan.ioc.resource;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.*;

/**
 * 测试Spring中的资源Resource
 *
 * @Author PENGL
 * 2020-03-08
 */
public class ResourceTest {
    private final String tempDir = "temp-dir";

    /**
     * 测试UrlResource
     */
    @Test
    public void uelResourceTest() throws Exception {
        Resource resource = new UrlResource("https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html");
        InputStream inputStream = resource.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String filename = tempDir + "/" + "UrlResourceTest.html";
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));
        while(bufferedReader.ready()) {
            bufferedWriter.write(bufferedReader.readLine());
        }
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    /**
     * 测试ClassPathResource
     * @throws Exception
     */
    @Test
    public void classPathResourceTest() throws Exception {
        Resource resource = new ClassPathResource("pers/penglan/ioc/resource/ResourceTest.class");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "UTF-8"));
        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine() + "\n");
        }
    }

    @Test
    public void fileSystemResourceTest() {

    }

    @Test
    public void servletContextResourceTest() {

    }

    @Test
    public void inputStreamResourceTest() {

    }

    @Test
    public void byteArrayResourceTest() {

    }


    @Test
    public void newFileTest() {
        File file = new File(tempDir);
        file.mkdir();
    }

}

