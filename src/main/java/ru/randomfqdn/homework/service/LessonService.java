package ru.randomfqdn.homework.service;

import ru.randomfqdn.homework.model.Lesson;
import ru.randomfqdn.homework.model.User;

import java.util.List;

public interface LessonService {

    List<Lesson> findAll();
    List<Lesson> findAllByUser(User user);
    Lesson findById(Integer id);
    Lesson save(Lesson lesson);
    void delete(Lesson lesson);

}
