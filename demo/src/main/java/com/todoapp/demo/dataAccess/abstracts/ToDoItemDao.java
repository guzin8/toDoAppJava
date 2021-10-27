package com.todoapp.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import com.todoapp.demo.entities.ToDoItem;

public interface ToDoItemDao extends JpaRepository<ToDoItem, Integer> {

}
