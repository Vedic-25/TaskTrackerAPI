package com.code9.tasktracker.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code9.tasktracker.entities.Task;
import com.code9.tasktracker.services.TaskService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/tasks")
@RequiredArgsConstructor
@Valid
public class TaskController {
	
	private final TaskService taskService = null;
	
	@PostMapping("")
	public ResponseEntity<?> addTask(@RequestBody Task task){
		task = taskService.addTask(task);
		if(task != null) {
			return ResponseEntity.ok(task);
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Database error");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getTask(@PathVariable String id){
		Task task = taskService.getTask(id);
		if(task != null) {
			return ResponseEntity.ok(task);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\" : \"Task not found\"}");
		}
	}
	
	@GetMapping("")
	public ResponseEntity<?> getTasks(){
		return ResponseEntity.ok(taskService.getTasks());
	}
	
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable String id) {
		taskService.deleteTask(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateTask(@PathVariable String id,@RequestBody Task task){
		task = taskService.updateTask(id, task);
		if(task != null) {
			return ResponseEntity.ok(task);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\" : \"Task not found\"}");
		}
	}

}
