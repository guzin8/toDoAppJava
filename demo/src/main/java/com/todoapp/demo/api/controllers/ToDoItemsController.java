package com.todoapp.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.demo.business.abstracts.ToDoItemService;
import com.todoapp.demo.core.DataResult;
import com.todoapp.demo.core.Result;
import com.todoapp.demo.entities.ToDoItem;

@RestController
@RequestMapping(value = "/api/toDoItems")
@CrossOrigin
public class ToDoItemsController {
	
	private ToDoItemService toDoItemService;

	@Autowired
	public ToDoItemsController(ToDoItemService toDoItemService) {
		
		this.toDoItemService = toDoItemService;
	}
	
	@GetMapping(value = "/getAll")
	public DataResult<List<ToDoItem>> getAll(){	
		return this.toDoItemService.getAll();	
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody ToDoItem item) {
		return this.toDoItemService.add(item);	
	}
	
	@PutMapping(value = "/update")
	public Result update(@RequestBody ToDoItem item) {
		return this.toDoItemService.update(item);
	}
	
	@PostMapping(value = "/delete")
	public Result delete(ToDoItem item) {
		return this.toDoItemService.delete(item);
	}
	

}
