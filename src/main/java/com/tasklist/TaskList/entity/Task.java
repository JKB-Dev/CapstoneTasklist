package com.tasklist.TaskList.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Task {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long idtask;
	
	private String taskdesc;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date taskdue;
	private boolean complete;
	
	private Integer iduser;
	
	@ManyToOne
	@JoinColumn(name = "iduser",insertable = false, updatable = false)
	private User user;

	public Task() {
	}

	public Task(Long idtask, String taskdesc, Date taskdue, boolean complete, Integer iduser, User user) {
		super();
		this.idtask = idtask;
		this.taskdesc = taskdesc;
		this.taskdue = taskdue;
		this.complete = complete;
		this.iduser = iduser;
		this.user = user;
	}
	
	public Task(String taskdesc, Date taskdue, boolean complete, Integer iduser, User user) {
		this.taskdesc = taskdesc;
		this.taskdue = taskdue;
		this.complete = complete;
		this.iduser = iduser;
		this.user = user;
	}

	public Long getIdtask() {
		return idtask;
	}

	public void setIdtask(Long idtask) {
		this.idtask = idtask;
	}

	public String getTaskdesc() {
		return taskdesc;
	}

	public void setTaskdesc(String taskdesc) {
		this.taskdesc = taskdesc;
	}

	public Date getTaskdue() {
		return taskdue;
	}

	public void setTaskdue(Date taskdue) {
		this.taskdue = taskdue;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public Integer getIduser() {
		return iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Task [idtask=" + idtask + ", taskdesc=" + taskdesc + ", taskdue=" + taskdue + ", complete=" + complete
				+ ", iduser=" + iduser + ", user=" + user + "]";
	}
	
	
}