package com.code9.tasktracker.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.code9.tasktracker.dto.TaskRepository;
import com.code9.tasktracker.entities.Task;
import com.code9.tasktracker.services.TaskService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

	private final TaskRepository taskRepository=null;
	
	@Override
	public Task getTask(String id) {
		Task task =  taskRepository.findById(id).orElse(null);
		return task;
	}

	@Override
	public List<Task> getTasks() {
		return taskRepository.findAll();
	}

	@Override
	public Task addTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Task updateTask(String id, Task task) {
		Task oldTask = taskRepository.findById(id).orElse(null);
		if(oldTask != null) {
			taskRepository.save(task);
			return task;
		}
		return oldTask;
	}

	@Override
	public void deleteTask(String id) {
		taskRepository.deleteById(id);
		
	}

}
