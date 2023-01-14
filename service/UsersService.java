package com.springrest.springrest.service;

import java.util.List;

import com.springrest.springrest.model.Users;

public interface UsersService {
	Users createUser(Users user);
	Users updateUser(Users user);
	Users getUserById(int userId);
	void deleteUser(int userId);
	List<Users> getAllUsers();
}
