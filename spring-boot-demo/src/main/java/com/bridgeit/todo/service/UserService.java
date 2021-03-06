package com.bridgeit.todo.service;

import com.bridgeit.todo.model.User;

public interface UserService {

	int saveUser(User user);
	
	User userLogin(User user);
	
	User getUserByEmail(String email);
	
	User getUserById(int id);
}