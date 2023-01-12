package com.springrest.springrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "dates")
@Entity
public class Dates {
	
	@Id
	@GeneratedValue
	@Column(name="id", updatable = false)
	private Integer id;
	
	@Column(name="date")
	private String stringDate;
	
//	Date date = new Date();
//	SimpleDateFormat dateFormate = new SimpleDateFormat("dd MMM yyyy");
//	String stringDate = dateFormate.format(date);
	
	@ManyToOne
    @JoinColumn(name = "UID", nullable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Users users;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStringDate() {
		return stringDate;
	}

	public void setStringDate(String stringDate) {
		this.stringDate = stringDate;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}	
	
}
