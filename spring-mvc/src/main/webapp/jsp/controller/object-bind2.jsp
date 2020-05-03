<%--
  @Author PENGL
  2020-03-09
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Object Bind2</title>

    <base href="http://localhost/springmvc/"/>
</head>
<body>
    <form action="parambind/object2?flag=param" method="POST" enctype="application/x-www-form-urlencoded">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age"><br/>
        父母姓名：<input type="text" name="parent.name"><br/>
        父母性别：<input type="text" name="parent.gender"><br/>
        <input type="submit" value="提交">
    </form>

</body>
</html>