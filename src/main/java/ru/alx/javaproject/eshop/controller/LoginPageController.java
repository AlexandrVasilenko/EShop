package ru.alx.javaproject.eshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.entity.User;
import ru.alx.javaproject.eshop.entity.UserCredentials;
import ru.alx.javaproject.eshop.service.UserValidator;
import ru.alx.javaproject.eshop.utility.MD5;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
public class LoginPageController {

    private static final Logger logger = LoggerFactory.getLogger(LoginPageController.class);

    @Autowired
    UserValidator userValidator;

    @RequestMapping("/")
    public ModelAndView loginPageLoader (){
        ModelAndView modelAndView = new ModelAndView("LoginPage");
        return modelAndView;

    }

    @RequestMapping("/Login")
    public ModelAndView RedirectionPageLoader (@ModelAttribute ("user") UserCredentials userCredentials){
        ModelAndView modelAndView = new ModelAndView ();
        User user = new User(userCredentials.getLogin(), MD5.getMd5(userCredentials.getPassword()));

        if(userValidator.checkUserAuthorization(user)){
            modelAndView.setViewName("redirect:/Welcome");
            modelAndView.addObject("isAdmin", "true");
            logger.debug("Successful log in by user: " +user.getLogin());
        } else {
            modelAndView.setViewName("redirect:/");
            modelAndView.addObject("error", true);
        }
        return modelAndView;
    }
}
