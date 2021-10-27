package com.todoapp.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.demo.business.abstracts.ToDoItemService;
import com.todoapp.demo.core.DataResult;
import com.todoapp.demo.core.Result;
import com.todoapp.demo.core.SuccessDataResult;
import com.todoapp.demo.core.SuccessResult;
import com.todoapp.demo.dataAccess.abstracts.ToDoItemDao;
import com.todoapp.demo.entities.ToDoItem;

@Service
public class ToDoItemManager implements ToDoItemService {

	ToDoItemDao toDoItemDao;
	
	@Autowired
	public ToDoItemManager(ToDoItemDao toDoItemDao) {
		this.toDoItemDao = toDoItemDao;
	}

	@Override
	public DataResult<List<ToDoItem>> getAll() {
		
		return new SuccessDataResult<List<ToDoItem>>(this.toDoItemDao.findAll(),"Bütün itemlar listelendi");
	}

	@Override
	public Result add(ToDoItem item) {
		this.toDoItemDao.save(item);
		return new SuccessResult("Item eklendi.");
	}

	@Override
	public Result delete(ToDoItem item) {
		this.toDoItemDao.delete(item);
		return new SuccessResult("Item silindi.");
	}

	@Override
	public Result update(ToDoItem item) {
		this.toDoItemDao.save(item);
		return new SuccessResult("Item güncellendi.");
	}

}
