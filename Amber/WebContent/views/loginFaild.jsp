<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
			response.setHeader("refresh","3;url=/Amber/main");  
		%>
		<div  style="text-align: center">
				<br><br><br><br><br><br><br><br>
				<span>用户名或密码错误，3秒后返回登录页面</span>
						
		</div>
</body>
</html>