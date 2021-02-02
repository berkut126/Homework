package ru.randomfqdn.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.randomfqdn.homework.model.Homework;
import ru.randomfqdn.homework.model.Lesson;
import ru.randomfqdn.homework.repo.HomeworkRepository;

import java.util.List;

@Service("homeworkServer")
@Transactional
public class HomeworkServiceImpl implements HomeworkService {

    private final HomeworkRepository homeworkRepository;

    @Autowired
    public HomeworkServiceImpl(HomeworkRepository homeworkRepository){
        this.homeworkRepository = homeworkRepository;
    }

    @Override
    public List<Homework> findAll() {
        return homeworkRepository.findAll();
    }

    @Override
    public List<Homework> findAllByLesson(Lesson lesson) {
        return homeworkRepository.findAllByLesson(lesson);
    }

    @Override
    public Homework findById(Integer id) {
        //noinspection OptionalGetWithoutIsPresent
        return homeworkRepository.findById(id).get();
    }

}
