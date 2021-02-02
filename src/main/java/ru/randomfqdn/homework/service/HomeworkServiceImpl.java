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
    @Transactional(readOnly = true)
    public List<Homework> findAll() {
        return homeworkRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Homework> findAllByLesson(Lesson lesson) {
        return homeworkRepository.findAllByLesson(lesson);
    }

    @Override
    @Transactional(readOnly = true)
    public Homework findById(Integer id) {
        //noinspection OptionalGetWithoutIsPresent
        return homeworkRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Homework save(Homework homework) {
        return homeworkRepository.save(homework);
    }

    @Override
    public void delete(Homework homework) {
        homeworkRepository.delete(homework);
    }

}
