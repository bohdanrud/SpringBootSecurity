package ua.logos.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.logos.entity.User;
import ua.logos.repository.UserRepository;
import ua.logos.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		String password = user.getPassword();
		System.out.println("BEFORE: " + password);
		user.setPassword(passwordEncoder.encode(password));
		System.out.println("AFTER: " + user.getPassword());
		userRepository.save(user);
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findUserByEmail(email);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	@Transactional
	public void updadeUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

}
