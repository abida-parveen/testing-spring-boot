package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.model.Users;
import com.springrest.springrest.service.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping(value = "/Users")
	public ResponseEntity<List<Users>> getAllUsers(){
		return ResponseEntity.ok().body(usersService.getAllUsers());
	}
	
	@PostMapping(value = "/Users")
	public ResponseEntity<Users> createUser(@RequestBody Users user){
		return ResponseEntity.ok().body(this.usersService.createUser(user));
	}
	
	@GetMapping(value = "/Users/{id}")
	public Users getUserById(@PathVariable int id){
		return this.usersService.getUserById(id);
	}
	
	@PutMapping(value = "/Users/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable int id ,@RequestBody Users user){
		user.setuId(id);
		return ResponseEntity.ok().body(this.usersService.updateUser(user));
	}
	
	@DeleteMapping(value = "/Users/{id}")
	public HttpStatus deleteUser(@PathVariable int id){
		this.usersService.deleteUser(id);
		return HttpStatus.OK;
	}
	
}
