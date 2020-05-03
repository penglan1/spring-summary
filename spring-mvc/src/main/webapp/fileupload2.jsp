<%--
  @Author PENGL
  2020-03-09
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>File Upload</title>

    <link rel="stylesheet" href="/springmvc/lib/css/element-ui.css">
    <script src="/springmvc/lib/js/vue.js"></script>
    <script src="/springmvc/lib/js/myAjax.js"></script>
    <script src="/springmvc/lib/js/element-ui.js"></script>

    <base href="http://localhost/springmvc/">

</head>
<body>
<form action="multipart/fileupload2" method="POST" enctype="multipart/form-data">
    文件：<input type="file" name="items"><br/>
    文件：<input type="file" name="items"><br/>
    文件：<input type="file" name="items"><br/>
    <%--年龄：<input type="text" name="age"><br/>--%>
    <%--年级：<input type="text" name="grade"><br/>--%>
    <input type="submit" value="提交">
</form>

</body>
</html>