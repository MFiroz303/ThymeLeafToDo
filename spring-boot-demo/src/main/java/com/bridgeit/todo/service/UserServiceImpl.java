package com.bridgeit.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeit.todo.dao.UserDao;
import com.bridgeit.todo.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public int saveUser(User user) {

		String hashedPassword = null;

		if (!(user.getPassword() == null)) {
			hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
			user.setPassword(hashedPassword);
		}
		return userDao.saveUser(user);
	}

	@Override
	public User userLogin(User user) {
		return userDao.userLogin(user);

	}
	
	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}
	
	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
}