<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<head>
<body>
<form action="/company/c_login" method="post">
    用户名：<input type="text" name="company_name" value=""/><br>
    密码：<input type="text" name="c_password"/><br>
    <input type="submit" value="提交"/><br>
</form>
</body>
</head>
</html>