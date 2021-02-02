package ru.randomfqdn.homework.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import ru.randomfqdn.homework.configuration.JpaConfiguration;
import ru.randomfqdn.homework.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LessonServiceImplTest {

    private GenericApplicationContext context;
    private LessonService service;

    @BeforeEach
    void setUp() {

        context = new AnnotationConfigApplicationContext(JpaConfiguration.class);

        service = context.getBean(LessonService.class);
        assertNotNull(service);

    }

    @AfterEach
    void tearDown() {

        context.close();

    }

    @Test
    void findAll() {

        var lessons = service.findAll();
        assertEquals(2, lessons.size());

        lessons.forEach(System.out::println);

    }

    @Test
    void findAllByUser() {

        var user = new User();
        user.setId(1);

        var lessons = service.findAllByUser(user);
        assertEquals(1, lessons.size());

        lessons.forEach(System.out::println);

    }

    @Test
    void save() {

        var lesson = service.findById(1);
        lesson.setName("Lang");

        var newLesson = service.save(lesson);
        assertEquals("Lang", newLesson.getName());

        System.out.println(newLesson);

    }

    @Test
    void findById() {

        var lesson = service.findById(1);
        assertNotNull(lesson);

        System.out.println(lesson);

    }

    @Test
    void delete() {

        var lesson = service.findById(1);
        service.delete(lesson);

        assertEquals(1, service.findAll().size());

    }

}