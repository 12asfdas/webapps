<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%-- 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册界面</title>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="shortcut icon" href="static/images/favicon.ico"/>
<link rel="bookmark" href="static/images/favicon.ico"/>
<link rel="stylesheet" href="static/css/register.css">
<body>
<div class="xiao-container">
	<div class="xiao-register-box">
		<div class="xiao-title-box">
			<span>用户注册</span>
		</div>
		<form action="register" method="post">
			<div class="xiao-username-box">
				<span class="xiao-require">*</span>
				<label for="username">用户名</label>
				<div class="xiao-username-input">
					<input type="text" id="username" name="username" placeholder="请输入用户名 长度:6-12个字符" />
				</div>
			</div>

			<div class="xiao-userPassword-box">
				<span class="xiao-require">*</span>
				<label for="userPassword">密码</label>
				<div class="xiao-userPassword-input">
					<input type="password" id="userPassword" name="password" placeholder="请输入密码 长度:6-12个字符" />
				</div>
			</div>

			<div class="xiao-userRePassword-box">
			<span class="xiao-require">*</span>
					<label for="userRePassword">确认密码</label>
				<div class="xiao-userRePassword-input">
					<input type="password" id="userRePassword" name="confirm-password" placeholder="请重复输入密码" />
				</div>
			</div>

			<div class="xiao-userPhone-box">
				<span class="xiao-require">*</span>
				<label for="userPhone">手机号码</label>
				<div class="xiao-userPhone-input">
					<input type="text" id="userPhone" name="phonenum" placeholder="请输入您的手机号码，11位有效数字" />
				</div>
			</div>
			
			<div class="xiao-userEmail-box">
				<span class="xiao-require">*</span>
				<label for="userEmail">电子邮箱</label>
				<div class="xiao-userEmail-input">
					<input type="text" id="userEmail" name="email" placeholder="请输入您的邮箱地址，如：123@qq.com" />
				</div>
			</div>
	<!--  		
			<div class="xiao-userGender-box">
				<span class="xiao-require">*</span>
				<label for="userGender">性别</label>
				<div class="xiao-userGender-input">
					<input type="radio" id="userGender_01" name="userGender" value="0" checked="checked" />男   
					<input type="radio" id="userGender_02" name="userGender" value="1" />女
				</div>
			</div>
			-->
			<div class="xiao-submit-box">
				<input id = "xiao-submit-button" type="submit" value="注册">
			</div>
			
			<div class="xiao-goLogin-box">
				<a href="preLogin" style="text-decoration: none;">已有账号？去登录</a>
			</div>
		</form>
	</div>
</div>
</body>
</html>