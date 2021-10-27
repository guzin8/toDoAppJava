package com.todoapp.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.todoapp.demo.business.abstracts.ToDoItemService;
import com.todoapp.demo.business.concretes.AuthenticatedUserDetails;
import com.todoapp.demo.dataAccess.abstracts.ToDoItemDao;
import com.todoapp.demo.dataAccess.abstracts.UserDao;
import com.todoapp.demo.entities.ToDoItem;
import com.todoapp.demo.entities.User;

@Controller
public class AppController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ToDoItemDao toDoItemDao;
	
	private User user;
	
	
	@GetMapping("")
	public String viewHomePage() {
		return "index.html";
	}
	
	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "registerForm.html";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userDao.save(user);
		return "successResult.html";
	}
	
   	@GetMapping("/list_items")
	public String itemsList(Model model,User user) {
		List<ToDoItem> itemsList = this.toDoItemDao.findAll();
		model.addAttribute("itemsList", itemsList);
		return "toDoItemsList.html";	
	}
	
	
	
	@GetMapping("/addItem")
	public String addItem(Model model) {
		model.addAttribute("toDoItem", new ToDoItem());
		return "addItem.html";
	}
	
	@PostMapping("/process_addItem")
	public String processAddItem(ToDoItem item) {
		this.toDoItemDao.save(item);
		return "successResultAddItem.html";
		
	}	
}
