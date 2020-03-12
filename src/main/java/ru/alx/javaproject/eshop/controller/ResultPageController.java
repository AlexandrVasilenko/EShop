package ru.alx.javaproject.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.service.ProfileService;

import javax.servlet.http.HttpSession;


@Controller
public class ResultPageController {

    @Autowired
    private ProfileService service;
    @Autowired
    private HttpSession httpSession;


    @RequestMapping(value = "/Result", method = RequestMethod.GET)
    public ModelAndView resultPageLoader() {
        ModelAndView modelAndView = new ModelAndView("Result");
        modelAndView.addObject("abilities", service.findById((int) httpSession.getAttribute("currentPlayerId")).getAbilities());
        return modelAndView;
    }

}

