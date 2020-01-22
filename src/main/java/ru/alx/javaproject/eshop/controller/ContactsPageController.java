package ru.alx.javaproject.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactsPageController {

    @RequestMapping("/Contacts")
    public ModelAndView contactPageLoader() {
        ModelAndView modelAndView = new ModelAndView("/contacts.html");

        modelAndView.addObject("pageOwner", "Alex Vasilenko");
        modelAndView.addObject("mobile", "+420 123 456 789");
        modelAndView.addObject("email", "aleksander.vasilenko@gmail.com");

        return modelAndView;
    }

}
