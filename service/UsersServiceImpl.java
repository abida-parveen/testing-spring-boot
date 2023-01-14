package com.springrest.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.exception.ResourceNotFoundException;
import com.springrest.springrest.model.Users;
import com.springrest.springrest.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public Users createUser(Users user) {
		return usersRepository.save(user);
	}

	@Override
	public Users updateUser(Users user) {
		Optional<Users> userDb = this.usersRepository.findById(user.getuId());
		if(userDb.isPresent())
		{
			Users userUpdate = userDb.get();
			userUpdate.setUserName(user.getUserName());
			usersRepository.save(userUpdate);
			return userUpdate;
		}
		else {
			throw new ResourceNotFoundException("User not found with UID : "+user.getuId());
		}
	}

	@Override
	public Users getUserById(int userId) {
		Optional<Users> userDb = this.usersRepository.findById(userId);
		if(userDb.isPresent())
		{
			return userDb.get();
		}
		else {
			throw new ResourceNotFoundException("User not found with UID : "+userId);
		}
	}

	@Override
	public void deleteUser(int userId) {
		Optional<Users> userDb = this.usersRepository.findById(userId);
		if(userDb.isPresent())
		{
			this.usersRepository.delete(userDb.get());
		}
		else {
			throw new ResourceNotFoundException("User not found with UID : "+userId);
		}
	}

	@Override
	public List<Users> getAllUsers() {
		return this.usersRepository.findAll();
	}

}
