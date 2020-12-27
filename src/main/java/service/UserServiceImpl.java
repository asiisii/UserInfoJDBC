package service;

import java.util.List;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();

	@Override
	public int saveUserInfo(User user) {
		return userDao.saveUserInfo(user);
	}

	@Override
	public int updateUserInfo(User user) {
		return userDao.updateUserInfo(user);
	}

	@Override
	public int deleteUserInfo(int id) {
		return userDao.deleteUserInfo(id);
	}

	@Override
	public List<User> getAllUserInfo() {
		return userDao.getAllUserInfo();
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

}
