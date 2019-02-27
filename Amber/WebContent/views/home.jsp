<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>润文</title>
<script src="${ pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<script src="${ pageContext.request.contextPath }/js/signformchange.js"></script>
<link rel="stylesheet" href="https://necolas.github.io/normalize.css/8.0.1/normalize.css">

<link rel="shortcut icon" href="${ pageContext.request.contextPath }/static/images/favicon.ico"/>
<link rel="bookmark" href="${ pageContext.request.contextPath }/static/images/favicon.ico"/>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/static/css/sign.css" type="text/css">
<link rel="stylesheet" media="screen and (min-device-width:641px)" href="${ pageContext.request.contextPath }/static/css/home.css" type="text/css" />
<link rel="stylesheet" media="screen and (max-device-width:640px)" href="${ pageContext.request.contextPath }/static/css/phone.css" type="text/css"/>
<script type="text/javascript" src='${ pageContext.request.contextPath }js/home.js'></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }js/HZRecorder.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }js/listen.js"></script>

<script>

window.onload = function() {
	var fileInput = document.getElementById('fileInput');
	var fileDisplayArea = document.getElementById('write-text');

	fileInput.addEventListener('change', function(e) {
		var file = fileInput.files[0];
		var textType = /text.*/;

		if (file.type.match(textType)) {
			var reader = new FileReader();

			reader.onload = function(e) {
				fileDisplayArea.innerText = reader.result;
			}

			reader.readAsText(file);	
		} else {
			fileDisplayArea.innerText = "File not supported!"
		}
	});
}
</script>
</head>
<body>
<!-- 导航栏 -->
<header>
	<nav>
		<div class="logo"><a href="#">润文</a></div>
		<ul>
		<c:if test="${sessionScope.user.getUsername()!=null}">
			<li><a href="#" id="login-latter">${user.username}</a></li>
		</c:if>
		<c:if test="${sessionScope.user.getUsername()==null}">
			<li><button id="displaysign" onclick="start()">登录</button></li>
		</c:if>
		</ul>
	</nav>
	<!-- 功能栏 -->	
	<div class="open">
		<div>
			<input type="file" id="fileInput" class="fileInput">
		</div>
		<div class="output">
			<input type="button" value="文本导出">
		</div>
	</div>
</header>
<!-- 文本栏 -->
<div class="hr"></div>
<br>
<div class="text">
	<div class="write">
	<div class="function_write">
	<ul>
			<li><a href="#"><font>文章补全</font></a></li>
			<li><a><font>润色</font></a>
				<ul>
                 <li><a href="#"><font>全文润色</font></a></li>
                 <li><a href="#"><font>深度润色</font></a></li>
                </ul>
			</li>
			<li><a href="#"><font>矫正</font></a>
				<ul>
                 <li><a href="#"><font>错别字矫正</font></a></li>
                 <li><a href="#"><font>语义语法矫正</font></a></li>
                </ul>
			</li>
			<li><a href="#"><font>文风转换</font></a></li>
	</ul>
	</div>
	<div class="hr"></div>
	<div id="write-text"  onKeyDown="showLen(this)" onKeyUp="showLen();" contenteditable="true"  placeholder="请输入您想要润色的文本" ><c:if test="${hp!=null }"><c:out value="${hp.content}" /></c:if></div>
	<div class="bottom">
		<div class="listen">
			<a onclick="changeTu()" class="change"><img alt="语音输入" src="${ pageContext.request.contextPath }/static/images/demo.png"></a>
		</div>
		<div class="listen-stop">
		<a onclick="stopRecording()" class="change2" ><img src="${ pageContext.request.contextPath }/static/images/demo2.png" class="change2"></a>
		</div>
		<div class="listen-wenzi" >录音中。。。</div>
		<div class="show">
		<span id="show-result">0</span>
		/3000
		</div>
	</div>
	</div>
	<div class="read">
	<div class="function_read">
	<!-- 
	<ul>
			<li><a href="#">文章补全</a></li>
			<li><a href="#">深度润色</a></li>
			<li><a href="#">文风转换</a></li>
	</ul>
	 -->
	</div>
	<div class="hr"></div>
	<div id="read-text" contenteditable="true"></div>
	<div class="bottom">
		<div id="save" class="save">
			<a href="#" onclick="textSave()"></a>
		</div>
	</div>
	</div>
</div>


<!-- 登录界面 -->
<div class="signform" id="signform" style="display: none">
	
    <div class="signclose">
        <img src="${ pageContext.request.contextPath }/static/images/5.jpg" width="35px" height="35px" onclick="signclose()">
    </div>
    <form action="${ pageContext.request.contextPath }/login" method="post">
    <div class="userdiv">
    <div class="sign-login">密码登录</div>
    <input id="user" class="signinput" type="text" placeholder="用户名" name="username" >
    </div>
    <div class="pwddiv">
    <input id="pwd" class="signinput" type="password" placeholder="密码" name="password">
    </div>
    <div class="postdiv">
    <button type="submit">登录</button>
    </div>
    </form>
    <br>
    <div class="change" style="color: #4d4d4d">
        <p>还没有账号?赶快<a href="#" style="text-decoration: none;color: #43A047">注册</a>一个吧</p>
    </div>
</div>

<!-- 注册界面 -->
<div class="signform" id="registerform" style="display: none">
        <div class="signclose">
            <img src="${ pageContext.request.contextPath }/static/images/5.jpg" width="35px" height="35px" onclick="signclose()">
        </div>
        <form action="${ pageContext.request.contextPath }/register" method="post">
        <div class="userdiv">
        	<div class="sign-login">用户注册</div>
            <input  id="registeruser" class="signinput" onblur="loading()" type="text" placeholder="用户名" name="username">
        </div>
        <div class="pwddiv">
            <input  id="registerpwd" class="signinput" type="password" placeholder="密码" name="password">
        </div>
        <div class="pwddiv">
            <input  id="registerrepwd" class="signinput" type="password" placeholder="再次输入密码" name="pwd">
        </div>
        <div class="pwddiv">
            <input  id="registerrephone" class="signinput" type="text" placeholder="手机号" name="phonenum">
        </div>
        <div class="pwddiv">
            <input  id="registerreemail" class="signinput" type="text" placeholder="邮箱" name="email">
        </div>
        <div class="postdiv">
            <button type="submit">注册</button>
        </div>
        </form>
        <br>
        <div class="change" style="color: #4d4d4d">
            <p>已有账号?立刻去<a href="#" style="text-decoration: none;color: #43A047">登录</a>吧</p>
        </div>
</div>
<!-- 用户登录之后信息界面以及功能选项 -->
<div class="user-message" id="user-function" style="display: none">
	<div class="user-show">
		<span>用户名：${user.username}</span>
		<span>手机号：${user.phonenum}</span>
		<span>邮箱：${user.email}</span>
	</div>
	<div class="user-show">
		<span><a href="#">修改密码</a></span>
		<span><a href="#">历史文件</a></span>
		<span><a href="#">退出登录</a></span>
	</div>
</div>
<!-- 脚底 -->
<div id="footer"></div>
</body>
</html>