package ru.randomfqdn.homework.service;

import ru.randomfqdn.homework.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findUserByLogin(String login);
    User save(User user);
    void delete(User user);

}
