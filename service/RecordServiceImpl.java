package com.springrest.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.exception.ResourceNotFoundException;
import com.springrest.springrest.model.Meal;
import com.springrest.springrest.model.Record;
import com.springrest.springrest.repository.MealRepository;
import com.springrest.springrest.repository.RecordRepository;

@Service
public class RecordServiceImpl implements RecordService{
	
	@Autowired
	private RecordRepository recordRepository;
	
	@Autowired
	private MealRepository mealRepository;

	@Override
	public Record createRecord(Record record, int mealId) {
		Optional<Meal> meal = mealRepository.findById(mealId);
		record.setMeal(meal.get());
		return recordRepository.save(record);
	}

	@Override
	public Record updateRecord(Record record) {
		Optional<Record> recordDb = this.recordRepository.findById(record.getId());
		if(recordDb.isPresent())
		{
			Record recordUpdate = recordDb.get();
			recordUpdate.setMeal(record.getMeal());
			recordUpdate.setCalories(record.getCalories());
			recordUpdate.setDishName(record.getDishName());
			recordUpdate.setTime(record.getTime());
			recordRepository.save(recordUpdate);
			return recordUpdate;
		}
		else {
			throw new ResourceNotFoundException("Record record not found with recordId : "+record.getId());
		}
	}

	@Override
	public Record getRecordById(int id) {
		Optional<Record> recordDb = this.recordRepository.findById(id);
		if(recordDb.isPresent())
		{
			return recordDb.get();
		}
		else {
			throw new ResourceNotFoundException("Record record not found with recordId : "+id);
		}
	}

	@Override
	public void deleteRecord(int id) {
		Optional<Record> recordDb = this.recordRepository.findById(id);
		if(recordDb.isPresent())
		{
			recordRepository.delete(recordDb.get());
		}
		else {
			throw new ResourceNotFoundException("Record record not found with recordId : "+id);
		}
	}

	@Override
	public List<Record> getAllRecords(int mealId) {
		return recordRepository.findByMeal_id(mealId);
	}

}
