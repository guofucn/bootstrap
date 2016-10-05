<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>" />
<title>登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/login/reset.css">
<link rel="stylesheet" type="text/css" href="style/login/structure.css">
</head>
<body>
	<form class="box login" action="manage/user/login" method="POST">
		<fieldset class="boxBody">
			<label>用户名</label> <input name="userName" type="text" tabindex="1"
				placeholder="请输入用户名" required> <label>密码</label> <input
				name="password" type="password" tabindex="2" placeholder="请输入密码"
				required>
		</fieldset>
		<footer>
			<label style="color: red;">${errMsg}</label> 
			<input type="submit" class="btnLogin" value="登录" tabindex="4">
		</footer>
	</form>
</body>
</html>
