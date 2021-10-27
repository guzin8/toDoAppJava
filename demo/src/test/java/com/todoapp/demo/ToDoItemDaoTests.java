package com.todoapp.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.todoapp.demo.dataAccess.abstracts.ToDoItemDao;
import com.todoapp.demo.entities.ToDoItem;
import com.todoapp.demo.entities.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ToDoItemDaoTests {
	
	@Autowired
	private ToDoItemDao toDoItemDao;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateItem() {
		ToDoItem item = new ToDoItem();
		item.setId(1);
		item.setItemName("Kitap oku");
		item.setDone(true);
		
		ToDoItem savedItem = toDoItemDao.save(item);
		ToDoItem existItem = entityManager.find(ToDoItem.class, savedItem.getId());
		
		assertThat(existItem.getItemName()).isEqualTo(savedItem.getItemName());
	}

}
