package com.springrest.springrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.model.Dates;

public interface DatesRepository extends JpaRepository<Dates, Integer>{
	List<Dates> findByUsers_uId(Integer userid);
}
