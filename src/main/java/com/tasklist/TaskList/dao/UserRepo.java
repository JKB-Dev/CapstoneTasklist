package com.tasklist.TaskList.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasklist.TaskList.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	User findByIduserAndPassword(int iduser, String password);

}
