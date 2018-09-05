package com.tasklist.TaskList.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int iduser;
	
	private String email;
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Task> task = new ArrayList<>();
	
	public User() {
	}

	public User(int iduser, String email, String password) {
		super();
		this.iduser = iduser;
		this.email = email;
		this.password = password;
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Task> getTasks(){
		return task;
	}
	
	public void setTask(List<Task>task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "User [iduser=" + iduser + ", email=" + email + ", password=" + password + "]";
	}
	
	
}

	