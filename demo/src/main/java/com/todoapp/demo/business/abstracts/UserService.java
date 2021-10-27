package com.todoapp.demo.business.abstracts;

import com.todoapp.demo.core.DataResult;
import com.todoapp.demo.core.Result;
import com.todoapp.demo.entities.User;

public interface UserService {
	
	DataResult<User> findByEmail(String email); 
	Result add(User user);

}
