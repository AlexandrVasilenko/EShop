package ru.alx.javaproject.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class MainPageController {

    @RequestMapping("/Welcome")
    public ModelAndView mainPageLoader (){
        ModelAndView modelAndView = new ModelAndView("MainPage");
        LocalDate today = LocalDate.now();
        modelAndView.addObject("todayDate", today);

        return modelAndView;

    }

    /*@RequestMapping("")
    public ModelAndView mainPageLoader2 (){
        ModelAndView modelAndView = new ModelAndView("MainPage");
        LocalDate today = LocalDate.now();
        modelAndView.addObject("todayDate", today);
        return modelAndView;

    }*/


}
