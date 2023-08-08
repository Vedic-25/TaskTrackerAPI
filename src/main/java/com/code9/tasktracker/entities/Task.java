package com.code9.tasktracker.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Task {

	@Id
	@NotBlank(message = "Id can't be blank")
	@NotNull(message = "Id	 can't be null")
	private String id;
	
	@NotBlank(message = "Title can't be blank")
	@NotNull(message = "Title can't be null")
	private String title;
	
	@NotBlank(message = "Description can't be blank")
	@NotNull(message = "Description can't be null")
	private String description;
	
	@NotNull(message = "Due Date can't be null")
	@Column(name = "due_date")
	private LocalDate dueDate;
	
}
