package com.code9.tasktracker.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code9.tasktracker.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

}