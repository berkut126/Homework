package ru.randomfqdn.homework.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import ru.randomfqdn.homework.configuration.JpaConfiguration;
import ru.randomfqdn.homework.model.Lesson;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkServiceImplTest {

    private GenericApplicationContext context;
    private HomeworkService service;

    @BeforeEach
    void setUp() {

        context = new AnnotationConfigApplicationContext(JpaConfiguration.class);

        service = context.getBean(HomeworkService.class);
        assertNotNull(service);

    }

    @AfterEach
    void tearDown() {

        context.close();

    }

    @Test
    void findAll() {

        var homework = service.findAll();
        assertEquals(4, homework.size());

        homework.forEach(System.out::println);

    }

    @Test
    void findAllByLesson() {

        var lesson = new Lesson();
        lesson.setId(1);
        lesson.setName("Math");

        var homework = service.findAllByLesson(lesson);
        assertEquals(2, homework.size());

        homework.forEach(System.out::println);

    }

    @Test
    void findAllById() {

        var homework = service.findById(1);
        assertEquals("LIM", homework.getTask());

        System.out.println(homework);

    }

    @Test
    void save() {

        var lesson = service.findById(1);
        lesson.setTask("Hello");

        var newLesson = service.save(lesson);
        assertEquals("Hello", newLesson.getTask());

    }

    @Test
    void delete() {

        var homework = service.findById(1);

        service.delete(homework);
        assertEquals(3, service.findAll().size());

    }

}