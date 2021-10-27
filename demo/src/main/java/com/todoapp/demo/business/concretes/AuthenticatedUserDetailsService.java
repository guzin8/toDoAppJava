package com.todoapp.demo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.todoapp.demo.dataAccess.abstracts.UserDao;
import com.todoapp.demo.entities.User;

public class AuthenticatedUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userDao.findByEmail(email);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found!");
		}
		
		return new AuthenticatedUserDetails(user);
	}

}
