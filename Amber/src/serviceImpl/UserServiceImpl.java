package serviceImpl;

import java.util.List;

import bean.User;
import dao.ItemDao;
import service.UserService;

public class UserServiceImpl implements UserService {
	ItemDao userDao = new ItemDao();
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.getUser(user);
	}
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user)>0?true:false;
	}
	@Override
	public List<String> getUserName() {
		// TODO Auto-generated method stub
		return userDao.getUserName();
	}

}
