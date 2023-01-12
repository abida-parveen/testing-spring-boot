package com.springrest.springrest.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Users")
@Entity
public class Users {
	
	@Id
	@GeneratedValue
	@Column(name="UID",updatable = false)
	private Integer uId;
	
	@Column(name="username")
	private String userName;

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}	
	
}
