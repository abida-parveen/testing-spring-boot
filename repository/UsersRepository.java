package com.springrest.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

}
