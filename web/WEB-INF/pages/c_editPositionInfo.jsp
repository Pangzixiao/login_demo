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
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/dist/css/layui.css"  media="all">
</head>
<body>
<a href="/company/addPosition">添加</a>
<table >

    <tr>
        <th>职位id</th>
        <th>职位名称</th>
        <th>工作地址</th>
        <th>薪水</th>
        <th>工作经验</th>
        <th>职位描述</th>
        <th>工作要求</th>
        <th>福利待遇</th>
        <th>修改</th>
        <th>删除</th>
        <th>查看申请</th>
        <th>失效</th>
    </tr>
    <tbody>
    <c:forEach var="m" items="${info.list}">
        <tr>
            <td>${m.position_id}</td>
            <td>${m.p_name}</td>
            <td>${m.p_address}</td>
            <td>${m.salary}</td>
            <td>${m.required_work}</td>
            <td>${m.p_descript}</td>
            <td>${m.p_request}</td>
            <td>${m.treatment}</td>
            <td>
                <a href="/company/queryPositionById?position_id=${m.position_id}">修改</a>
            </td>
            <td><a href="/company/delPositionById?position_id=${m.position_id}">删除</a></td>
            <td><a href="">查看申请</a></td>
            <td><a href="">失效</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
