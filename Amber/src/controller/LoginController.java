package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bean.User;
import service.UserService;
import serviceImpl.UserServiceImpl;

@Controller

public class LoginController {

	private UserService userservice = new UserServiceImpl();
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(User user,HttpSession session) {
		User newUser = userservice.login(user);
		if(newUser == null) {
			return "loginFaild";
		}else {
		session.setAttribute("user", newUser);
		System.out.println("登录成功");
			return "redirect:/main";
		}
	}
	
	
	
	
	@RequestMapping(value="/preLogin",method = RequestMethod.GET)
	public String preLogin() {
		
		return "login";
		}
	
	
	@RequestMapping(value="/main",method = RequestMethod.GET)
	public String preMain() {
		
		return "home";
		}
	
	@RequestMapping(value="/preRegister",method = RequestMethod.GET)
	public String preRegister() {
		
		return "register";
		}
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String logout(HttpSession session) {
//        if (session.getAttribute("user") != null &&
//                session.getAttribute("student") != null) {
//            session.removeAttribute("user");
//            session.removeAttribute("student");
//            return "LoginPage";
//        } else
//            return "LoginPage";
//    }	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String addUser(User user,HttpSession session) {
		System.out.println(user.getUsername());

		boolean result = userservice.addUser(user);
		if(result) {
			System.out.println("注册成功");
			if(session.getAttribute("user")!=null) {
				System.out.println("user对象不为空");
	            session.removeAttribute("user");
			}
			return "redirect:/main";
		}else {
			System.out.println("注册失败");

			return "redirect:/main";
		}
	}
	
	@RequestMapping(value="/username",method = RequestMethod.POST)
	public String getUserName(User user) {
		System.out.println("进入了");

		List<String> list=new ArrayList<String>();

		list = userservice.getUserName();
		String name = user.getUsername();

		return "home";
 	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		ItemDao dao=new ItemDao();
//		List<String> list=new ArrayList<String>();
//		int num = 0;
//		   response.setContentType("text/html;charset=UTF-8");
//		   String name = request.getParameter("username");
//			System.out.println(name);
//		   list=dao.getUserName();
//		   if(list != null && list.size()>0){//如果list中存入了数据，转化为数组
//			   String[] arr=new String[list.size()];//创建一个和list长度一样的数组
//			   for(int i=0;i<list.size();i++){
//			   arr[i]=list.get(i);//数组赋值了。 
//			   System.out.println(arr[i]);
//			   }
//			   for(int i=0;i<arr.length;i++) {
//				   if(name.equals(arr[i])) {
//					   num= 1 ;
//					   break;
//				   }
//				   }
//			   }
//			  
//		    if(num!=0){
//		       out.print(false);
//		       System.out.println("用户名重复了");
//		      }
//		      else{
//		       out.print(true);
//		       System.out.println("用户名输入没问题");
//		      }
//		  
//		  }
}
