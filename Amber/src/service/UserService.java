package service;

import java.util.List;

import bean.User;

public interface UserService {
	User login(User user);
	public boolean addUser(User user);
	public List<String> getUserName();
}
