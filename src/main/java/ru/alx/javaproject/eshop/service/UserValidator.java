package ru.alx.javaproject.eshop.service;

import org.springframework.stereotype.Service;
import ru.alx.javaproject.eshop.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserValidator {

    @PersistenceContext
    private EntityManager em;

    public boolean checkUserAuthorization (User user){
        boolean isUserValid = false;
        User currentUser = new User (user.getLogin(),user.getPassword());
        String passwordFromDB = "";
        try {
             passwordFromDB = em.createQuery("select x.password from User x where x.login=" + currentUser.getLogin(), User.class).getSingleResult().getPassword();
        } catch (Exception e){
            throw new IllegalArgumentException("User is not found");
        }

        if (!passwordFromDB.isEmpty() && currentUser.getPassword().equals(passwordFromDB)){
            isUserValid = true;
        }
        return isUserValid;
    }
}
