<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2019/4/21
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/company/updateCompanyInfo" method="post">

    <input type="text" name="company_id" value="${info.company_id}"/><br>
    公司名称：<input type="text" name="company_name" value="${info.company_name}"/><br>
    电话:<input type="text" name = "c_phone" value="${info.c_phone}"/><br>
    公司类型:
    <select name="c_type" >
        <option value="外资">外资</option>
        <option value="合资">合资</option>
        <option value="国企">国企</option>
        <option value="民营">民营</option>
        <option value="政府机关">政府机关</option>
        <option value="事业单位">事业单位</option>
        <option value="非盈利组织">非盈利组织</option>
        <option value="上市公司">上市公司</option>
        <option value="创业公司">创业公司</option>
    </select><br>
    公司规模
    <select name="c_scale">
        <option value="少于50">少于50</option>
        <option value="50-150">50-150</option>
        <option value="150-1000">150-1000</option>
        <option value="1000-5000">1000-5000</option>
        <option value="5000-10000">5000-10000</option>
        <option value="10000以上">10000以上</option>
    </select><br>
    地址：<input type="text" name="c_address" value="${info.c_address}"/><br>
    公司网址：<input type="text" name="c_websize" value="${info.c_websize}"/><br>
    公司描述：<input type="text" name="c_describe" value="${info.c_describe}"/><br>
    <input type="submit" value="提交"/><br>
</form>
</body>
</html>
