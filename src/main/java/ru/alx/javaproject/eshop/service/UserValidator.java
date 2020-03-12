package ru.alx.javaproject.eshop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import ru.alx.javaproject.eshop.controller.LoginPageController;
import ru.alx.javaproject.eshop.entity.User;

@Component
public class UserValidator {

    private static final Logger logger = LoggerFactory.getLogger(LoginPageController.class);

    @Autowired
    private UserService userService;

    public boolean checkUserAuthorization(User user) {
        String passwordFromDB = "";
        try {
            passwordFromDB = userService.findByLogin(user.getLogin()).getPassword();
        } catch (EmptyResultDataAccessException e) {
            logger.debug("Invalid username" + user.getLogin());
            return false;
        }

        if (user.getPassword().equals(passwordFromDB)) {
            return true;
        }
        return false;
    }

    public boolean checkUserExistence(User user) {

        try {
            userService.findByLogin(user.getLogin());
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;

    }
}
