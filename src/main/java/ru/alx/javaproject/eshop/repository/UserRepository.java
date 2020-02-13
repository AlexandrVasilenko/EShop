package ru.alx.javaproject.eshop.repository;

import ru.alx.javaproject.eshop.entity.User;

public interface UserRepository {

    User getUserByLogin(String login);

}
