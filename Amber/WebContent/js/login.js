//打开字滑入效果
window.onload = function(){
	$(".connect p").eq(0).animate({"left":"0%"}, 600);
	$(".connect p").eq(1).animate({"left":"0%"}, 400);
};
$(doucument).ready(function(){
	
	//登陆表单验证
//	$("#loginForm").validate({
//		rules:{
//			username:{
//				required:true,//必填
//				minlength:3, //最少6个字符
//				maxlength:32,//最多20个字符
//			},
//			password:{
//				required:true,
//				minlength:3, 
//				maxlength:32,
//			},
//		},
//		//错误信息提示
//		messages:{
//			username:{
//				required:"必须填写用户名",
//				minlength:"用户名至少为3个字符",
//				maxlength:"用户名至多为32个字符",
//				remote: "用户名已存在",
//			},
//			password:{
//				required:"必须填写密码",
//				minlength:"密码至少为3个字符",
//				maxlength:"密码至多为32个字符",
//			},
//		},
//
//	});
	//取出传回来的参数error并与yes比较
	  var error ='<%=request.getParameter("error")%>';
	  if(error=='yes'){
	   alert("登录失败!");
	  }
	
});
