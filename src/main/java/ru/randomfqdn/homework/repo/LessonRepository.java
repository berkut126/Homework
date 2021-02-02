package ru.randomfqdn.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.randomfqdn.homework.model.Lesson;
import ru.randomfqdn.homework.model.User;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    List<Lesson> findAll();
    List<Lesson> findAllByUser(User user);

}
