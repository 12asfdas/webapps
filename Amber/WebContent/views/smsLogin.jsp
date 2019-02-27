<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>手机验证码登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css"/>

<style type="text/css">
     #login{ width:450px; height:100px; margin:50px auto;}
     #btn{ margin-left:100px; margin-top:-25px; width: 120px;height: 25px; font-size: 11px; }
     body{ background-color: #ecfcf9;}
</style>
</head>
<body>
<div class="container">
        <div  id="login">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label class="col-sm-2 control-label">手机号</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入您的手机号"  required autofocus>
                    
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">验证码</label>
                <div class="col-sm-3">
                    <input type="code" class="form-control" id="code" name="code" placeholder="验证码" required>
                    <input type="button" class="btn btn-default" id="btn" name="btn" value="发送验证码" onclick="sendMessage()" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" class="btn btn-info" id="lo">登陆</button>
            </div>
        </div>
    </form>
</div>
</div>
</body>
<script type="text/javascript">

    var sms="";
    $("#btn").click(function(){
    	alert("jinru");
        var phone=$("#phone").val();
        if(phone!="")
        {
            $.ajax({
                url:"sendSMS",
                type:"post",
                data:{"phone":phone},
                success:function(result){
                    sms=result;
                }
            });
        }else{
             alert("请输入手机号");
            return false;
        }

    });
    $("#lo").click(function(){
        var code=$("#code").val();
        if(code==""){
            alert("请输入验证码");
        }else{
            if(sms==code){
                window.location.href="success.jsp";
            }else{
                alert("验证码错误");

            };
        };

    });
</script>
</html>