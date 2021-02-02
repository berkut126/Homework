package ru.randomfqdn.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.randomfqdn.homework.model.Lesson;
import ru.randomfqdn.homework.model.User;
import ru.randomfqdn.homework.repo.LessonRepository;

import java.util.List;

@Service("lessonService")
@Transactional
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Lesson> findAllByUser(User user) {
        return lessonRepository.findAllByUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson findById(Integer id) {
        //noinspection OptionalGetWithoutIsPresent
        return lessonRepository.findById(id).get();
    }

    @Override
    public void delete(Lesson lesson) {
        lessonRepository.delete(lesson);
    }
}
