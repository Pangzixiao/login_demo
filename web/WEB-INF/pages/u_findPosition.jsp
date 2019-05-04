<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<head>
<body>

<form action="/user/findPosition" method="post">
    职位名称：<input type="text" name="p_name" value=""/><br>
    类型1<select name="p_type1">
    <option value="">不限</option>
    <option value="技术">技术</option>
    <option value="产品">产品</option>
    <option value="设计">设计</option>
    <option value="运营">运营</option>
    <option value="销售">销售</option>
    <option value="职能">职能</option>
    <option value="其他">其他</option>
    </select>
    类型2<select name="p_type2" >
    <option value="">不限</option>
    <option value="前端">前端</option>
    <option value="后端">后端</option>
    <option value="DBA">DBA</option>
    <option value="人工智能">人工智能</option>
    <option value="测试">测试</option>
    <option value="运维">运维</option>
    <option value="高端管理">高端管理</option>
    <option value="硬件">硬件</option>
    <option value="其他">其他</option>
    </select>
    类型3<select name="p_type3" >
    <option value="">不限</option>
    <option value="java">java</option>
    <option value="python">python</option>
    <option value="全栈">全栈</option>
    <option value="web前端">web前端</option>
    <option value="html5">html5</option>
    <option value="flash">flash</option>
    <option value="其他">其他</option>
    </select><br>
    工作地点<select name="p_address" >
    <option value="">不限</option>
    <option value="北京">北京</option>
    <option value="上海">上海</option>
    <option value="郑州">郑州</option>
    <option value="其他">其他</option>
    </select>
    工作经验<select name="required_work" >
    <option value="">不限</option>
    <option value="无要求">无要求</option>
    <option value="有经验">有经验</option>
    </select>

    <input type="submit" value="提交"/><br>
</form>


</body>
</head>
</html>