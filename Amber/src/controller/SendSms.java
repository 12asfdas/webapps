package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import util.GetMessageCode;

//@Controller
//public class SendSms {
//	
///**
// * 
// * @Title:SendSms
// * @Description：接收页面传过来的电话号码
// * @author:胡波
// * @Date 
// */
//	
//@RequestMapping(value="/sendSMS",method = RequestMethod.POST)
//public String sendSMS(HttpSession session)){
//	System.out.print("pppppppppppp");
//	String phone=req.getParameter("phone");
//	//根据获取到的手机号发送验证码
//	String code=GetMessageCode.getCode(phone); 
//	System.out.println(code);
//	resp.getWriter().print(code);
//}	
//}
