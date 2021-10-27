package com.todoapp.demo.business.abstracts;

import java.util.List;

import com.todoapp.demo.core.DataResult;
import com.todoapp.demo.core.Result;
import com.todoapp.demo.entities.ToDoItem;

public interface ToDoItemService {
	
	DataResult<List<ToDoItem>> getAll();
	Result add(ToDoItem item);
	Result delete(ToDoItem item);
	Result update(ToDoItem item);
	
}
