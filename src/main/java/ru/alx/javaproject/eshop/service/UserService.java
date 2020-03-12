package ru.alx.javaproject.eshop.service;

import ru.alx.javaproject.eshop.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> findAll();

    User findById(int id);

    void deleteById(int id);

    void deleteAll();

    User findByLogin(String login);
}
