package dao;

import java.util.List;

import model.User;

public interface UserDao {
	
	int saveUserInfo (User user);
	
	int updateUserInfo (User user);
	
	int deleteUserInfo( int id);
	
	List<User> getAllUserInfo();
	
	User getUserById(int id);
}
