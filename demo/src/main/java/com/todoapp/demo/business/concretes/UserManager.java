package com.todoapp.demo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.demo.business.abstracts.UserService;
import com.todoapp.demo.core.DataResult;
import com.todoapp.demo.core.Result;
import com.todoapp.demo.core.SuccessDataResult;
import com.todoapp.demo.core.SuccessResult;
import com.todoapp.demo.dataAccess.abstracts.UserDao;
import com.todoapp.demo.entities.User;

@Service
public class UserManager implements UserService {

	UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {

		this.userDao = userDao;
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email), "Kullanıcı bulundu.");
		
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi.");
	}

}
