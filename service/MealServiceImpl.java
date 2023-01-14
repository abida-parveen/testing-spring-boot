package com.springrest.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.exception.ResourceNotFoundException;
import com.springrest.springrest.model.Dates;
import com.springrest.springrest.model.Meal;
import com.springrest.springrest.repository.DatesRepository;
import com.springrest.springrest.repository.MealRepository;

@Service
public class MealServiceImpl implements MealService {

	@Autowired
	private MealRepository mealRepository;
	
	@Autowired
	private DatesRepository datesRepository;
	
	@Override
	public Meal createMeal(Meal meal,int id) {
		Optional<Dates> date = datesRepository.findById(id);
		meal.setDate(date.get());
		return mealRepository.save(meal);
	}

	@Override
	public Meal updateMeal(Meal meal) {
		Optional<Meal> mealDb = this.mealRepository.findById(meal.getId());
		if(mealDb.isPresent())
		{
			Meal mealUpdate = mealDb.get();
			mealUpdate.setMealName(meal.getMealName());
			mealRepository.save(mealUpdate);
			return mealUpdate;
		}
		else {
			throw new ResourceNotFoundException("Meal record not found with mealId : "+meal.getId());
		}
	}

	@Override
	public Meal getMealById(int id) {
		Optional<Meal> mealDb = this.mealRepository.findById(id);
		if(mealDb.isPresent())
		{
			return mealDb.get();
		}
		else {
			throw new ResourceNotFoundException("Meal record not found with mealId : "+id);
		}
	}

	@Override
	public void deleteMeal(int id) {
		Optional<Meal> mealDb = this.mealRepository.findById(id);
		if(mealDb.isPresent())
		{
			this.mealRepository.delete(mealDb.get());
		}
		else {
			throw new ResourceNotFoundException("Meal record not found with mealId : "+id);
		}
	}

	@Override
	public List<Meal> getAllMeal(int id) {
		return mealRepository.findByDate_id(id);
	}

}
