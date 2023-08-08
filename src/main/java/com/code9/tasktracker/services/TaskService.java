package com.code9.tasktracker.services;

import java.util.List;

import com.code9.tasktracker.entities.Task;

public interface TaskService {
	
	public Task getTask(String id);
	
	public List<Task> getTasks();
	
	public Task addTask(Task task);
	
	public Task updateTask(String id, Task task);
	
	public void deleteTask(String id);
	
	
}
