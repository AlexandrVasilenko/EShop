package ru.alx.javaproject.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class LoginPageController {

    @RequestMapping("/")
    public ModelAndView loginPageLoader (){
        ModelAndView modelAndView = new ModelAndView("LoginPage");

        modelAndView.addObject("isAdmin", "true");

        return modelAndView;

    }

    @RequestMapping("/login")
    public ModelAndView loginRedirectionPageLoader (){
        ModelAndView modelAndView = new ModelAndView ("redirect:/Main");
        return
    }



}
