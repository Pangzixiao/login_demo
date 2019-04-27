<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<head>
<body>
<form action="/user/login" method="post">
    用户名：<input type="text" name="username" value=""/><br>
    密码：<input type="text" name="password"/><br>
    <input type="submit" value="提交"/><br>
</form>
</body>
</head>
</html>