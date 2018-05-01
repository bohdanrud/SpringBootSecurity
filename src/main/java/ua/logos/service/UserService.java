package ua.logos.service;

import java.util.List;

import ua.logos.entity.User;

public interface UserService {
	
	void saveUser(User user);
	
	User findUserById(int id);
	
	User findUserByEmail(String email);
	
	List<User> findAllUsers();

	void updadeUser (User user);
}
