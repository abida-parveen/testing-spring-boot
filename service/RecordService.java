package com.springrest.springrest.service;

import java.util.List;

import com.springrest.springrest.model.Record;

public interface RecordService {
	
	Record createRecord(Record record,int id);
	Record updateRecord(Record record);
	Record getRecordById(int id);
	void deleteRecord(int id);
	List<Record> getAllRecords(int id);

}
