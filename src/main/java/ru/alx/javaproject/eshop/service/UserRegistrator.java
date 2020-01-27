package ru.alx.javaproject.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alx.javaproject.eshop.entity.User;
import ru.alx.javaproject.eshop.repository.UserRepository;

@Service
public class UserRegistrator {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserValidator userValidator;

    public boolean registerNewUser (User user) {
        if(!userValidator.checkUserExistency(user)) {
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }
}
