package com.springrest.springrest.service;

import java.util.List;

import com.springrest.springrest.model.Dates;

public interface DatesService {
	
	Dates createDate(Dates date, int userid);
	Dates updateDate(Dates date);
	Dates getDateById(int id);
	void deteleDate(int id);
	List<Dates> getAllDates(int userid);

}
