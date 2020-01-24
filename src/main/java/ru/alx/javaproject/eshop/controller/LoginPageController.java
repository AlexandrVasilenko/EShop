package ru.alx.javaproject.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.entity.User;
import ru.alx.javaproject.eshop.service.UserValidator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Context;
import java.time.LocalDate;

@Controller
public class LoginPageController {

    @Autowired
    UserValidator userValidator;

    @PersistenceContext
    EntityManager em;

    @RequestMapping("/")
    public ModelAndView loginPageLoader (){
        ModelAndView modelAndView = new ModelAndView("LoginPage");

        modelAndView.addObject("isAdmin", "true");
        return modelAndView;

    }

    @RequestMapping("/Login")
    public ModelAndView RedirectionPageLoader (@ModelAttribute ("user") User user){
        ModelAndView modelAndView = new ModelAndView ();

        if(userValidator.checkUserAuthorization(user)){
            modelAndView.setViewName("redirect:/MainPage");
        } else {
            modelAndView.setViewName("redirect:/Login");
            modelAndView.addObject("error", true);
        }
        return modelAndView;
    }


    @RequestMapping("/Registration")
    public ModelAndView RegistrationPageLoader (){
        ModelAndView modelAndView = new ModelAndView ("redirect:/RegistrationPage");
        return modelAndView;
    }




}
