package com.springrest.springrest.service;

import java.util.List;

import com.springrest.springrest.model.Meal;

public interface MealService {
	
	Meal createMeal(Meal meal, int id);
	Meal updateMeal(Meal meal);
	Meal getMealById(int id);
	void deleteMeal(int id);
	List<Meal> getAllMeal(int id);

}
