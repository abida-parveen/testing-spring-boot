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

@Table(name = "meals")
@Entity
public class Meal {

	@Id
	@GeneratedValue
	@Column(name="id", updatable = false )
	private Integer id;
	
	@Column(name="mealname")
	private String mealName;
	
//	Date date = new Date();
//	SimpleDateFormat dateFormate = new SimpleDateFormat("dd MMM yyyy");
//	String stringDate = dateFormate.format(date);
	
	@ManyToOne
    @JoinColumn(name = "dateid", nullable = false, updatable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Dates date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public Dates getDate() {
		return date;
	}

	public void setDate(Dates date) {
		this.date = date;
	}
	
}
