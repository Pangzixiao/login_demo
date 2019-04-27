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
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css"  media="all">
</head>
<body>

    <form action="mutiQueryCompany" method="post">
        公司名：<input type="text" name="company_name" value=""/>
        <select name="check_type">
            <option value="未审批">未审批</option>
            <option value="已审批">已审批</option>
            <option value="">所有</option>
        </select>
        <input type="submit" value="查询"/>
    </form>
    每页大小：${info.pageSize}
    多少数据:${info.total}
    当前页：${info.pageNum}
    当前页数量:${info.size}
    <table >

        <tr>
            <th>公司id</th>
            <th>公司名称</th>
            <th>公司类型</th>
            <th>注册时间</th>
            <th>删除</th>
            <th>查看详细信息</th>
            <th>通过审核</th>
        </tr>
        <tbody>
            <c:forEach var="m" items="${info.list}">
                <tr>
                    <td>${m.company_id}</td>
                    <td>${m.company_name}</td>
                    <td>${m.c_type}</td>
                    <td>${m.regist_date}</td>
                    <td>
                        <a href="/adm/deleteCompanyById?id=${m.company_id}">删除</a>
                    </td>
                    <td><a href="/adm/queryCompanyById?id=${m.company_id}">查看详细信息</a></td>
                    <td><a href="/adm/checkCompanyById?id=${m.company_id}">通过审核</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="panigation">
        <a href="${pageContext.request.contextPath}/adm/queryCompanys">首页</a>

        <c:if test="${info.pageNum <= 1}">
            <a href="javascript:void(0)">上一页</a>
        </c:if>

        <c:if test="${info.pageNum > 1}">
            <a href="${pageContext.request.contextPath}/adm/queryCompanys?page=${info.pageNum -1}">上一页</a>
        </c:if>

        <c:if test="${info.pageNum >= info.pages}">
            <a href="javascript:void(0)">下一页</a>
        </c:if>

        <c:if test="${info.pageNum < info.pages}">
            <a href="${pageContext.request.contextPath}/adm/queryCompanys?page=${info.pageNum +1}">下一页</a>
        </c:if>
        <a  href="${pageContext.request.contextPath}/adm/queryCompanys?page=${info.size}">尾页</a>
        当前是${info.pageNum}页
    </div>
    <div id="demo7"></div>
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script>
        layui.use('laypage', function(){
            var laypage = layui.laypage;

            //执行一个laypage实例
            laypage.render({
                elem: 'demo7'
                ,count: ${info.total}
                ,limit:${info.pageSize}
                ,layout: [ 'prev', 'page', 'next']
            });
        });
    </script>

</body>
</html>
