package com.springrest.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.exception.ResourceNotFoundException;
import com.springrest.springrest.model.Dates;
import com.springrest.springrest.model.Users;
import com.springrest.springrest.repository.DatesRepository;
import com.springrest.springrest.repository.UsersRepository;

@Service
public class DatesServiceImpl implements DatesService {
	
	@Autowired
	private DatesRepository datesRepository;
	
	@Autowired
	private UsersRepository userReopsitory;

	@Override
	public Dates createDate(Dates date, int userid) {
		Optional<Users> user = userReopsitory.findById(userid);
		date.setUsers(user.get());
		return datesRepository.save(date);		
	}

	@Override
	public Dates updateDate(Dates date) {
			
		Optional<Dates> datesDb = this.datesRepository.findById(date.getId());
		if(datesDb.isPresent())
		{
			Dates datesUpdate = datesDb.get();
			datesUpdate.setStringDate(date.getStringDate());
			datesRepository.save(datesUpdate);
			return datesUpdate;
		}
		else {
			throw new ResourceNotFoundException("Date record not found with datesId : "+date.getId());
		}
	}

	@Override
	public Dates getDateById(int id) {
		Optional<Dates> datesDb = this.datesRepository.findById(id);
		if(datesDb.isPresent())
		{
			return datesDb.get();
		}
		else {
			throw new ResourceNotFoundException("Date record not found with datesId : "+id);
		}
	}

	@Override
	public void deteleDate(int id) {
		
		Optional<Dates> datesDb = this.datesRepository.findById(id);
		if(datesDb.isPresent())
		{
			this.datesRepository.delete(datesDb.get());
		}
		else {
			throw new ResourceNotFoundException("Date record not found with datesId : "+id);
		}
	}

	@Override
	public List<Dates> getAllDates(int userid) {
		
		return this.datesRepository.findByUsers_uId(userid);
	}

}
