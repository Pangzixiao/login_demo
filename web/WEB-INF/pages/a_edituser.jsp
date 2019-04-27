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
    <link rel="stylesheet" href="//res.layui.com/layui/dist/css/layui.css"  media="all">
</head>
<body>

    <form action="/adm/queryUsersByName" method="post">
        <input type="text" name="username" value="用户名查询"/>
        <input type="submit" value="查询"/>
    </form>

    <table >

        <tr>
            <th>用户id</th>
            <th>用户名</th>
            <th>性别</th>
            <th>联系方式</th>
            <th>删除</th>
            <th>查看简历</th>
        </tr>
        <tbody>
            <c:forEach var="m" items="${info.list}">
                <tr>
                    <td>${m.user_id}</td>
                    <td>${m.username}</td>
                    <td>${m.sex}</td>
                    <td>${m.tel}</td>
                    <td>
                        <a href="/adm/deleteUserById?id=${m.user_id}">删除</a>
                    </td>
                    <td><a href="/adm/showIntroduce?id=${m.user_id}">查看简历</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <a href="${pageContext.request.contextPath}/adm/queryUsers">首页</a>

        <c:if test="${info.pageNum <= 1}">
            <a href="javascript:void(0)">上一页</a>
        </c:if>

        <c:if test="${info.pageNum > 1}">
            <a href="${pageContext.request.contextPath}/adm/queryUsers?page=${info.pageNum -1}">上一页</a>
        </c:if>

        <c:if test="${info.pageNum >= info.pages}">
            <a href="javascript:void(0)">下一页</a>
        </c:if>

        <c:if test="${info.pageNum < info.pages}">
            <a href="${pageContext.request.contextPath}/adm/queryUsers?page=${info.pageNum +1}">下一页</a>
        </c:if>
        <a  href="${pageContext.request.contextPath}/adm/queryUsers?page=${info.pages}">尾页</a>
        当前是${info.pageNum}页
    </div>

</body>
</html>
