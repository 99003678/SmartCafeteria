package com.ltts.shadow.smartcafeteria;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.ltts.shadow.smartcafeteria.Dao.UserDao;
import com.ltts.shadow.smartcafeteria.Models.User;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserDaoTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserDao repo;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setFullname("Ashutosh Kumar");
		user.setCompany("LTTS");
		user.setDesignation("Associate Engineer");
		user.setUsername("iamashu");
		user.setPassword("ashu123");
		
		User savedUser = repo.save(user);
		

		
		assertThat(user.getUsername()).isEqualTo(user.getUsername());
		
	}
	
	@Test
	public void testFindByUsername() {
		String username = "iamashu";
		User user = repo.findByUsername(username);
		
	assertThat(user.getUsername()).isEqualTo(username);
	}
}