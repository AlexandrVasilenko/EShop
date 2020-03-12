package ru.alx.javaproject.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alx.javaproject.eshop.entity.User;

@Component
public class UserRegistrator {

    @Autowired
    private UserService userService;

    @Autowired
    UserValidator userValidator;

    public boolean registerNewUser (User user) {
        if(userService.findByLogin(user.getLogin()) == null) {
            userService.save(user);
            return true;
        } else {
            return false;
        }
    }
}
