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

import com.springrest.springrest.model.Meal;
import com.springrest.springrest.service.MealService;


@RestController
public class MealController {

	
	@Autowired
	private MealService mealService;
	
	@GetMapping(value = "/Users/{userid}/date/{dateid}/meal")
	public ResponseEntity<List<Meal>> getAllMeal(@PathVariable int userid,@PathVariable int dateid){
		return ResponseEntity.ok().body(mealService.getAllMeal(dateid));
	}
	
	@PostMapping(value = "/Users/{userid}/date/{dateid}/meal")
	public ResponseEntity<Meal> createMeal(@PathVariable int userid,@PathVariable int dateid,@RequestBody Meal meal){
		return ResponseEntity.ok().body(this.mealService.createMeal(meal,dateid));
	}
	
	@GetMapping(value = "/Users/{userid}/date/{dateid}/meal/{id}")
	public ResponseEntity<Meal> getMealById(@PathVariable int userid,@PathVariable int dateid,@PathVariable int id){
		return ResponseEntity.ok().body(this.mealService.getMealById(id));
	}
	
	@PutMapping(value = "/Users/{userid}/date/{dateid}/meal/{id}")
	public ResponseEntity<Meal> updateMeal(@PathVariable int userid,@PathVariable int dateid,@PathVariable int id ,@RequestBody Meal meal){
		meal.setId(id);
		return ResponseEntity.ok().body(this.mealService.updateMeal(meal));
	}
	
	@DeleteMapping(value = "/Users/{userid}/date/{dateid}/meal/{id}")
	public HttpStatus deleteMeal(@PathVariable int userid,@PathVariable int dateid,@PathVariable int id){
		this.mealService.deleteMeal(id);
		return HttpStatus.OK;
	}
	
}
