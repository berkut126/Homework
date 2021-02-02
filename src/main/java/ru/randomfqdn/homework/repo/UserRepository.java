package ru.randomfqdn.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.randomfqdn.homework.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();
    User findUserByLogin(String login);

}
