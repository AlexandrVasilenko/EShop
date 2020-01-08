package ru.alx.javaproject.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginPageController {

    @RequestMapping("/Login")
    public ModelAndView showLoginPage(){


        return new ModelAndView("/LoginPage.html");
    }
}
