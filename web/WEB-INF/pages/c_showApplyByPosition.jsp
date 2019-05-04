<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<head>
<body>

<table >

    <tr>
        <th>职位名称</th>
        <th>所属企业</th>
        <th>工作地点</th>
        <th>月薪</th>
        <th>申请状态</th>
        <th>职位状态</th>
    </tr>
    <tbody>
    <c:forEach var="m" items="${info.list}">
        <tr>
            <td>${m.p_name}</td>
            <td>${m.p_cname}</td>
            <td>${m.p_address}</td>
            <td>${m.salary}</td>
            <td>${m.apply_status}</td>
            <td>${m.position_status}</td>
            </tr>
    </c:forEach>
    </tbody>
</table>
<div class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <a href="${pageContext.request.contextPath}/company/queryApplyByPositionId?position_id=${position_id}">首页</a>

    <c:if test="${info.pageNum <= 1}">
        <a href="javascript:void(0)">上一页</a>
    </c:if>

    <c:if test="${info.pageNum > 1}">
        <a href="${pageContext.request.contextPath}/company/queryApplyByPositionId?position_id=${position_id}&page=${info.pageNum -1}">上一页</a>
    </c:if>

    <c:if test="${info.pageNum >= info.pages}">
        <a href="javascript:void(0)">下一页</a>
    </c:if>

    <c:if test="${info.pageNum < info.pages}">
        <a href="${pageContext.request.contextPath}/company/queryApplyByPositionId?position_id=${position_id}&page=${info.pageNum +1}">下一页</a>
    </c:if>
    <a  href="${pageContext.request.contextPath}/company/queryApplyByPositionId?position_id=${position_id}&page=${info.pages}">尾页</a>
    当前是${info.pageNum}页
</div>
<a href="/companyMain">返回查询首页</a>

</body>
</head>
</html>