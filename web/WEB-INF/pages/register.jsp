<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<head>
    <body>
        <form action="/user/regist" method="post">
            用户名：<input type="text" name="username" value=""/><<br>
            密码：<input type="text" name="password"/><br>
            电话:<input type="text" name = "tel"/><br>
            性别：<input type="text" name="sex"><br>
            <input type="submit" value="提交"/><br>
        </form>
    </body>
</head>
</html>