<%--
  @Author PENGL
  2020-03-09
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Success</title>
</head>
<body>
    <h1>Success</h1>
    <h1>${message}</h1>
    <%--此处主要是验证ImplicitModel最终会保存到Request域中--%>
    <%--<h1><%=request.getAttribute("student")%></h1>--%>

    <h1>${sessionScope.a}</h1>

</body>
</html>