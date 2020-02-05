package ru.alx.javaproject.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.repository.ResultRepository;

import javax.servlet.http.HttpSession;


@Controller
public class ResultPageController {

    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private HttpSession httpSession;


    @RequestMapping(value = "/Result", method = RequestMethod.GET)
    public ModelAndView resultPageLoader() {
        ModelAndView modelAndView = new ModelAndView("Result");
        modelAndView.addObject("abilities", resultRepository.findResultList((int) httpSession.getAttribute("currentPlayerId")).getAbilityList());
        return modelAndView;
    }

}

