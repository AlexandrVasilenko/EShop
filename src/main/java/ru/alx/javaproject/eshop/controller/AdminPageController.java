package ru.alx.javaproject.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.model.Profile;
import ru.alx.javaproject.eshop.repository.ProfileRepository;

@Controller
public class AdminPageController {

    @Autowired
    ProfileRepository profileRepository;

    @RequestMapping("/Admin")
    public ModelAndView adminPageLoader (){
        ModelAndView modelAndView = new ModelAndView("/Admin.html");


        modelAndView.addObject("profiles", profileRepository.findAll());

        return modelAndView;
    }

}
