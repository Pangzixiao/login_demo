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
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/user/addIntroduce" method="post">
        <input type="text" name="user_id" value=${id}><br>
        基本信息<br>
        现居住地:<input type="text" name="u_address"><br>
        民族:<input type="text" name="nation"><br>
        最高学历:<select name="degree">
        <option value="大专及以下">大专及以下</option>
        <option value="本科">本科</option>
        <option value="硕士">硕士</option>
        <option value="博士">博士</option>
        <option value="博士以上">博士以上</option>
        </select><br>
        毕业院校: <input type="text" name="school"><br>
        专业:<input type="text" name="major"><br>
        毕业日期:<input type="date" name="graduate_date"><br>

        教育经历:<input type="text" name= "study_exprience" ><br>
        工作经历:<input type="text" name= "work_exprience" ><br>
        自我描述:<input type="text" name= "u_describe" ><br>
        求职意向<br>
        期望职位:<input type="text" name="job_want"><br>
        最低薪水:<input type="text"  name="min_wage"><br>
        最高薪水:<input type="text" name="max_wage"><br>
        期望城市:<input type="text" name="city_want"><br>
        现在的状态:<select name="now_state">
        <option value="积极找工作">积极找工作</option>
        <option value="上学">上学</option>
        <option value="工作">工作</option>
        </select><br>
        上传附件<br>
        <input type="submit" value="提交"><br>
    </form>

</body>
</html>
