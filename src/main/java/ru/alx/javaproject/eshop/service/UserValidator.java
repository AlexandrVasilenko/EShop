package ru.alx.javaproject.eshop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.alx.javaproject.eshop.controller.LoginPageController;
import ru.alx.javaproject.eshop.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserValidator {

    private static final Logger logger = LoggerFactory.getLogger(LoginPageController.class);

    @Autowired
    private UserService userService;

    public boolean checkUserAuthorization(User user) {
        String passwordFromDB = "";
        try {
            passwordFromDB = userService.getUserByLogin(user.getLogin()).getPassword();
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
            userService.getUserByLogin(user.getLogin());
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;

        /*List<User> userLoginList = em.createQuery("from User", User.class).getResultList();
        for (User x: userLoginList){
            if (x.equals(user)){
                isUserAlreadyExist = true;
                break;
            }
        }*/
    }
}
