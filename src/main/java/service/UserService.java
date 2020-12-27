package service;

import java.util.List;

import model.User;

public interface UserService {
	
	int saveUserInfo(User user);
	int updateUserInfo (User user);
	int deleteUserInfo( int id);   //cuz we will delete based on id so no need to take every info 
	List<User> getAllUserInfo();
	User getUserById(int id);
}
