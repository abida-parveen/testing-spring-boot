package com.springrest.springrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.model.Record;

public interface RecordRepository extends JpaRepository<Record, Integer> {
	List<Record> findByMeal_id(Integer mealId);
}
