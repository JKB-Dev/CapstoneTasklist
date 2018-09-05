package com.tasklist.TaskList.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasklist.TaskList.entity.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long>{

}
