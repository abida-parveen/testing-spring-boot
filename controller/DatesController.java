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

import com.springrest.springrest.model.Dates;
import com.springrest.springrest.service.DatesService;

@RestController
public class DatesController {
	
	@Autowired
	private DatesService dateService;
	
	@GetMapping(value = "/Users/{userid}/date")
	public ResponseEntity<List<Dates>> getAllDates(@PathVariable Integer userid){
		return ResponseEntity.ok().body(dateService.getAllDates(userid));
	}
	
	@PostMapping(value = "/Users/{userid}/date")
	public ResponseEntity<Dates> createDate(@PathVariable Integer userid,@RequestBody Dates date){
		return ResponseEntity.ok().body(this.dateService.createDate(date, userid));
	}
	
	@GetMapping(value = "/Users/{userid}/date/{id}")
	public ResponseEntity<Dates> getDateById(@PathVariable Integer userid,@PathVariable int id){
		return ResponseEntity.ok().body(this.dateService.getDateById(id));
	}
	
	@PutMapping(value = "/Users/{userid}/date/{id}")
	public ResponseEntity<Dates> updateDate(@PathVariable Integer userid,@PathVariable int id ,@RequestBody Dates date){
		date.setId(id);
		return ResponseEntity.ok().body(this.dateService.updateDate(date));
	}
	
	@DeleteMapping(value = "/Users/{userid}/date/{id}")
	public HttpStatus deleteDate(@PathVariable int userid,@PathVariable int id){
		this.dateService.deteleDate(id);
		return HttpStatus.OK;
	}
	
}
