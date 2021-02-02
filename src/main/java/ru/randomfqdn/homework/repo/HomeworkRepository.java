package ru.randomfqdn.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.randomfqdn.homework.model.Homework;
import ru.randomfqdn.homework.model.Lesson;

import java.util.List;

public interface HomeworkRepository extends JpaRepository<Homework, Integer> {

    List<Homework> findAll();
    List<Homework> findAllByLesson(Lesson lesson);

}
