<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<head>
<body>

<table >

    <tr>
        <th>职位名</th>
        <th>公司名</th>
        <th>工作地区</th>
        <th>月薪</th>
        <th>申请</th>
        <th>查看公司其他职位</th>
    </tr>
    <tbody>
    <c:forEach var="m" items="${info.list}">
        <tr>
            <td><a href="/user/queryPositionById?position_id=${m.position_id}"> ${m.p_name}</a></td>
            <td><a href="/user/queryCompanyById?company_id=${m.company_id}">${m.p_cname}</a></td>
            <td>${m.p_address}</td>
            <td>${m.salary}</td>
            <td>
                <a href="/user/applyPositionById?position_id=${m.position_id}">申请</a>
            </td>
            ${m.company_id}
            <td><a href="/user/queryPositionsByCompanyId?company_id=${m.company_id} ">查看公司其他职位</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <a href="${pageContext.request.contextPath}/user/findPositionPage">首页</a>

    <c:if test="${info.pageNum <= 1}">
        <a href="javascript:void(0)">上一页</a>
    </c:if>

    <c:if test="${info.pageNum > 1}">
        <a href="${pageContext.request.contextPath}/user/findPositionPage?page=${info.pageNum -1}">上一页</a>
    </c:if>

    <c:if test="${info.pageNum >= info.pages}">
        <a href="javascript:void(0)">下一页</a>
    </c:if>

    <c:if test="${info.pageNum < info.pages}">
        <a href="${pageContext.request.contextPath}/user/findPositionPage?page=${info.pageNum +1}">下一页</a>
    </c:if>
    <a  href="${pageContext.request.contextPath}/user/findPositionPage?page=${info.pages}">尾页</a>
    当前是${info.pageNum}页
</div>
<a href="/u_findPosition">返回查询首页</a>

</body>
</head>
</html>