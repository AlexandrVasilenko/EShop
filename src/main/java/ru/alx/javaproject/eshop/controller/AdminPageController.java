package ru.alx.javaproject.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.model.Profile;

@Controller
public class AdminPageController {

    @Autowired
    private Profile profile;

    @RequestMapping("/Admin")
    public ModelAndView adminPageLoader (){
        ModelAndView modelAndView = new ModelAndView("/admin.html");

        modelAndView.addObject("profileData",profile);

        return modelAndView;
    }

}
