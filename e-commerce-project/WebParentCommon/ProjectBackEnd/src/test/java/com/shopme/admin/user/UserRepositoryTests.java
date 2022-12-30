package com.shopme.admin.user;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTests {

	@Autowired
	private UserRepository repo;

	@Autowired
    private TestEntityManager entityManager;

	@Test
	public void testCreateFirstRole() {

		User userVenky = new User("kiseryotateiko10@gmail.com" , "venky2022" , "Venkat" , "Krishnan");

		User savedRole = repo.save(userVenky);

		assertThat(savedRole.getId()).isGreaterThan(0);
	}

}
