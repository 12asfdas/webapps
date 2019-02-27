package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import util.DBHelper;

//���ݿⷽ����
public class ItemDao {

	
	//����û���������--��¼��
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
				rs=stmt.executeQuery();//������������,��ѯ���ݿ�
				if(rs.next()){
					pwd=rs.getString("password");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			//�ж������Ƿ���ȷ
			if(pwd.equals(user.getPassword())) {
				//������ȷ����user����
				return user;
			}else {
				//������󷵻ؿ�ֵ
				return null;
			}
			
		}
		//����Ϣ��ӽ������ݿ�--ע����
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

				flag=stmt.executeUpdate();//������������,��ѯ���ݿ�
			
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
				rs=stmt.executeQuery();//������������,��ѯ���ݿ�
				while (rs.next()) {//��������ݣ�ȡ��һ�������list
					list.add(rs.getString("username"));
					}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
}
