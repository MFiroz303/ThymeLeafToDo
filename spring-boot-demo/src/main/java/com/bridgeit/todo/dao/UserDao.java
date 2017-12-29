package com.bridgeit.todo.dao;

import com.bridgeit.todo.model.User;

public interface UserDao {
	
	public int saveUser(User user);
	//public User userLogin(String email, String password);
	
	public User userLogin(User user);
	
	public User getUserByEmail(String email);
	
	public User getUserById(int id);
}