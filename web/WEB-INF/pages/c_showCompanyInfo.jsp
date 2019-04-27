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

<div>公司名称:${info.company_name}</div>
<div>公司类型:${info.c_type}</div>
<div>公司规模:${info.c_scale}</div>
<div>公司地址:${info.c_address}</div>
<div>联系方式:${info.c_phone}</div>
<div>公司官网:${info.c_websize}</div>
<div>公司描述:${info.c_describe}</div>
<div>注册时间:${info.regist_date}</div>
</body>
</html>
