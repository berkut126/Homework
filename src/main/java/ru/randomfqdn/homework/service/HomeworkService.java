package ru.randomfqdn.homework.service;

import ru.randomfqdn.homework.model.Homework;
import ru.randomfqdn.homework.model.Lesson;

import java.util.List;

public interface HomeworkService {

    List<Homework> findAll();
    List<Homework> findAllByLesson(Lesson lesson);
    Homework findById(Integer id);
    Homework save(Homework homework);
    void delete(Homework homework);

}
