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

@Table(name = "record")
@Entity
public class Record {
	
	@Id
	@GeneratedValue
	@Column(name="id", updatable = false)
	private Integer id;
	
	@Column(name="dishName")
	private String dishName;
	
	@Column(name="calories")
	private Double calories;
	
	@Column(name="time")
	private String time;
	
//	Date date = new Date();
//	SimpleDateFormat dateFormate = new SimpleDateFormat("dd MMM yyyy");
//	String stringDate = dateFormate.format(date);
	
	@ManyToOne
    @JoinColumn(name = "mealid", nullable = false, updatable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Meal meal;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public Double getCalories() {
		return calories;
	}

	public void setCalories(Double calories) {
		this.calories = calories;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

}
