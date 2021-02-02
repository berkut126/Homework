package ru.randomfqdn.homework.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import ru.randomfqdn.homework.configuration.JpaConfiguration;
import ru.randomfqdn.homework.model.User;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private GenericApplicationContext context;
    private UserService service;

    @BeforeEach
    void setUp() {

        context = new AnnotationConfigApplicationContext(JpaConfiguration.class);

        service = context.getBean(UserService.class);
        assertNotNull(service);

    }

    @AfterEach
    void tearDown() {
        context.close();
    }


    @Test
    void findAll() {

        var users = service.findAll();
        assertEquals(2, users.size());

        users.forEach(System.out::println);

    }

    @Test
    void findUserByLogin() {

        var user = service.findUserByLogin("nnn");
        assertNotNull(user);

        System.out.println(user);

        user = service.findUserByLogin("NonExistentUser");
        assertNull(user);

    }

    @Test
    void save() {

        var user = new User();
        user.setFirstName("Andrey");
        user.setLastName("Ivanov");
        user.setLogin("hi");
        user.setPassword("hello");
        user.setGroup("User");

        var savedUser = service.save(user);
        assertEquals(3, savedUser.getId());

    }
}