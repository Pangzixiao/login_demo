<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<head>
<body>
<form action="/company/newPosition" method="post">
    公司id <input type="text" name="company_id" value="${info.company_id}"><br>
    职位名称<input type="text" name="p_name"><br>
    职位类型1<select name=" p_type1" >
    <option value="技术">技术</option>
    <option value="">其他</option>
    </select>
    职位类型2<select name="p_type2" >
    <option value="前端">前端</option>
    <option value="后端">后端</option>
    <option value="">其他</option>
    </select><br>
    职位类型3<select name="p_type3" >
    <option value="java">java</option>
    <option value="python">python</option>
    <option value="python">全栈</option>
    <option value="">其他</option>
    </select><br>
    工作地点<select name="p_address" >
    <option value="北京">北京</option>
    <option value="上海">上海</option>
    <option value="郑州">郑州</option>
    <option value="">其他</option>
    </select><br>
    薪水<input type="text" name="salary"><br>
    工作经验<select name="required_work" >
    <option value="无要求">无要求</option>
    <option value="有经验">有经验</option>
    </select><br>
    职位描述<input type="text" name="p_descript"><br>
    工作要求<input type="text" name="p_request"><br>
    福利待遇<input type="text" name="treatment"><br>
    发布时间<input type="date" name="p_date"><br>
    <input type="submit" value="提交"/><br>
</form>
</body>
</head>
</html>