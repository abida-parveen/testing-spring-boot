package com.springrest.springrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Integer>{
	List<Meal> findByDate_id(Integer id);
}
