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


<div >基本信息</div><br>
<div >现居住地:${info.u_address}</div><br>
<div >民族:${info.nation}</div><br>
<div >最高学历:${info.degree}</div><br>
<div >毕业院校: ${info.school}</div><br>
<div >专业:${info.major}</div><br>
<div >毕业日期:${info.graduate_date}</div><br>
<div >教育经历:${info.study_exprience}</div><br>
<div >工作经历:${info.work_exprience}</div><br>
<div >自我描述:${info.u_describe}</div><br>
<div >求职意向</div><br>
<div >期望职位:${info.job_want}</div><br>
<div >最低薪水:${info.min_wage}</div><br>
<div >最高薪水:${info.max_wage}</div><br>
<div >期望城市:${info.city_want}</div><br>
<div >现在的状态:${info.now_state}</div><br>
        上传附件

</body>
</html>
