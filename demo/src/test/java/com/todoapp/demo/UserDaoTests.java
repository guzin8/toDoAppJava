package com.todoapp.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.todoapp.demo.dataAccess.abstracts.UserDao;
import com.todoapp.demo.entities.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserDaoTests {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("kanburoglunursima@gmail.com");
		user.setPassword("123nk");
		user.setFirstName("Nursima");
		user.setLastName("Kanburoğlu");
		
	    User savedUser = userDao.save(user);
	    
	    User existUser = entityManager.find(User.class, savedUser.getId());
	    
	    assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}
	
	@Test
	public void testFindUserByEmail() {
		String email = "kanburogluguzin@gmail.com";
		User user = userDao.findByEmail(email);
		assertThat(user).isNotNull();
	}	
	
}
