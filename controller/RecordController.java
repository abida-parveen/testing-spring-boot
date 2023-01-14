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

import com.springrest.springrest.model.Record;
import com.springrest.springrest.service.RecordService;

@RestController
public class RecordController {
	
	@Autowired
	private RecordService recordService;
	
	@GetMapping(value = "/Users/{userid}/date/{dateid}/meal/{mealid}/record")
	public ResponseEntity<List<Record>> getAllRecord(@PathVariable int mealid){
		return ResponseEntity.ok().body(recordService.getAllRecords(mealid));
	}
	
	@PostMapping(value = "/Users/{userid}/date/{dateid}/meal/{mealid}/record")
	public ResponseEntity<Record> createRecord(@PathVariable int mealid ,@RequestBody Record record){
		return ResponseEntity.ok().body(this.recordService.createRecord(record,mealid));
	}
	
	@GetMapping(value = "/Users/{userid}/date/{dateid}/meal/{mealid}/record/{id}")
	public ResponseEntity<Record> getRecordById(@PathVariable int id){
		return ResponseEntity.ok().body(this.recordService.getRecordById(id));
	}
	
	@PutMapping(value = "/Users/{userid}/date/{dateid}/meal/{mealid}/record/{id}")
	public ResponseEntity<Record> updateRecord(@PathVariable int id ,@RequestBody Record record){
		record.setId(id);
		return ResponseEntity.ok().body(this.recordService.updateRecord(record));
	}
	
	@DeleteMapping(value = "/Users/{userid}/date/{dateid}/meal/{mealid}/record/{id}")
	public HttpStatus deleteRecord(@PathVariable int id){
		this.recordService.deleteRecord(id);
		return HttpStatus.OK;
	}
	

}
