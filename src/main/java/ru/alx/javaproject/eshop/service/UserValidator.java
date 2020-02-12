package ru.alx.javaproject.eshop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @PersistenceContext
    private EntityManager em;

    public boolean checkUserAuthorization (User user){
        boolean isUserValid = false;
        User currentUser = new User (user.getLogin(),user.getPassword());
        String passwordFromDB = "";
        try {
             passwordFromDB = em.createQuery("select x from User x where x.login='" + currentUser.getLogin() + "'", User.class).getSingleResult().getPassword();
        } catch (Exception e){
            //throw new IllegalArgumentException("User is not found");
            //throw new UsernameNotFoundException("Invalid username or password.");
            logger.debug("Invalid username" + currentUser.getLogin());
        }

        if (currentUser.getPassword().equals(passwordFromDB)){
            isUserValid = true;
        }
        return isUserValid;
    }

    public boolean checkUserExistence(User user){
        boolean isUserAlreadyExist = false;

        //if (em.createQuery("select x from User x where x.login='" + user.getLogin() + "'", User.class).getSingleResult()){)
        List<User> userLoginList = em.createQuery("from User", User.class).getResultList();
        for (User x: userLoginList){
            if (x.equals(user)){
                isUserAlreadyExist = true;
                break;
            }
        }
        return isUserAlreadyExist;
    }
}
