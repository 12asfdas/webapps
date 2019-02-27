<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录界面</title>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="shortcut icon" href="static/images/favicon.ico"/>
<link rel="bookmark" href="static/images/favicon.ico"/>
<link rel="stylesheet" href="static/css/login.css">
<body>
<div class="main">
    <div class="title">
        <span>密码登录</span>
    </div>
 
    <div class="title-msg">
        <span>请输入登录账户和密码</span>
    </div>
 
    <form class="login-form" method="post" action="login" novalidate >
        <!--输入框-->
        <div class="input-content">
            <!--autoFocus-->
            <div>
                <input type="text" autocomplete="off"
                       placeholder="用户名" name="username" required/>
            </div>
 
            <div style="margin-top: 16px">
                <input type="password"
                       autocomplete="off" placeholder="登录密码" name="password" required maxlength="32"/>
            </div>
        </div>
 
        <!--登入按钮-->
        <div style="text-align: center">
            <button type="submit" class="enter-btn" >登录</button>
        </div>
 
        <div class="foor">
            <div class="left"><span>忘记密码 ?</span></div>
 
            <div class="right"><span><a href="preRegister">注册账户</a></span></div>
        </div>
    </form>
 
</div>
<script type="text/javascript">
function smsLongin(){
	window.open('views/smsLogin.jsp','_blank','width=600,height=400,top=200,left=500');
}
</script>
</body>
</html>