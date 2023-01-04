package com.shopme.admin.user;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void testCreateNewUserWithOneRole() {
        Role roleAdmin = entityManager.find(Role.class, 1);
        User userAdmin = new User("kiseryotateiko10@gmail.com" , "venky2022" , "Venkat" , "Krishnan");
        userAdmin.addRole(roleAdmin);

        User savedUser = repo.save(userAdmin);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateNewUserWithTwoRoles() {
        User userAomine = new User("aomineDaiki@gmail.com" , "aomine2022" , "Aomine" , "Daiki");
        Role roleEditor = new Role(3);
        Role roleAssisstant = new Role(5);

        userAomine.addRole(roleEditor);
        userAomine.addRole(roleAssisstant);

        User savedUser = repo.save(userAomine);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAllUsers() {
        Iterable<User> listUsers = repo.findAll();

        listUsers.forEach(user -> System.out.println(user));
    }

}
