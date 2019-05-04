<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<head>
    <body>
        <form action="/company/c_regist" method="post">
            公司名称：<input type="text" name="company_name" value=""/><br>
            密码：<input type="text" name="c_password"/><br>
            确认密码<input type="password" name = "repass"/><br>
            电话:<input type="text" name = "c_phone"/><br>
            公司类型:
            <select name="c_type" >
                <option value="外资">外资</option>
                <option value="合资">合资</option>
                <option value="国企">国企</option>
                <option value="民营">民营</option>
                <option value="政府机关">政府机关</option>
                <option value="事业单位">事业单位</option>
                <option value="非盈利组织">非盈利组织</option>
                <option value="上市公司">上市公司</option>
                <option value="创业公司">创业公司</option>
        </select><br>
            公司规模
            <select name="c_scale">
                <option value="少于50">少于50</option>
                <option value="50-150">50-150</option>
                <option value="150-1000">150-1000</option>
                <option value="1000-5000">1000-5000</option>
                <option value="5000-10000">5000-10000</option>
                <option value="10000以上">10000以上</option>
            </select><br>
            地址：<input type="text" name="c_address"/><br>
            公司网址：<input type="text" name="c_websize"/><br>
            公司描述：<input type="text" name="c_describe"/><br>
            <input type="submit" value="提交"/><br>
        </form>
    </body>
</head>
</html>


<table width="98%" border="0" align="center" cellpadding="0" cellspacing="9">
      <tr>
        <td>公司名称：${info.company_name}</td>
        <td>企业性质：${info.c_type}</td>
        <td >公司规模：${info.c_scale}</td>
      </tr>
      <tr>
        <td>联系电话：${info.c_phone}</td>
        <td >公司官网：${info.websize}</td>
      </tr>
		<tr>

        <td >通讯地址：${info.c_address}</td>
        </tr>
		<tr>
        <td>&nbsp;</td>
		</tr>
    </table>