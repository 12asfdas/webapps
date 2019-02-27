package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import util.DBHelper;

//数据库方法类
public class ItemDao {

	
	//获得用户名和密码--登录用
		public 	User getUser(User user){
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String pwd=null;
			try {
				conn = DBHelper.getConnection();
				String sql=" select password from system_user where username=? " ;
				stmt=conn.prepareStatement(sql);
				stmt.setString(1,user.getUsername());
				rs=stmt.executeQuery();//运行上面的语句,查询数据库
				if(rs.next()){
					pwd=rs.getString("password");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			//判断密码是否正确
			if(pwd.equals(user.getPassword())) {
				//密码正确返回user对象
				return user;
			}else {
				//密码错误返回空值
				return null;
			}
			
		}
		//将信息添加进入数据库--注册用
		public int addUser(User user){
			Connection conn = null;
			PreparedStatement stmt = null;
			int flag =0;
			if(user.getUsername()!=null&&user.getPassword()!=null){
			try {
				conn = DBHelper.getConnection();
				String sql=" insert into system_user(username,password,phonenum,email,role) values(?,?,?,?,?) " ;
				stmt=conn.prepareStatement(sql);
				stmt.setString(1,user.getUsername());
				stmt.setString(2,user.getPassword());
				stmt.setString(3,user.getPhonenum());
				stmt.setString(4,user.getEmail());
				stmt.setInt(5,1);

				flag=stmt.executeUpdate();//运行上面的语句,查询数据库
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			return  flag;
		}
			return flag;
		}
		public List getUserName() {
			List<String> list=new ArrayList<String>();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				conn = DBHelper.getConnection();
				String sql=" select username from system_user " ;
				stmt=conn.prepareStatement(sql);
				rs=stmt.executeQuery();//运行上面的语句,查询数据库
				while (rs.next()) {//如果有数据，取第一列添加如list
					list.add(rs.getString("username"));
					}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
}
