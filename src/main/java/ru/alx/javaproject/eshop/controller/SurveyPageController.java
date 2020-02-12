package ru.alx.javaproject.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.entity.Profile;
import ru.alx.javaproject.eshop.service.ProfileService;

import javax.servlet.http.HttpSession;


@Controller
public class SurveyPageController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private HttpSession httpSession;

    @RequestMapping(value = "/Survey", method = RequestMethod.POST)
    public ModelAndView sendSurveyInfo(@ModelAttribute ("profile") Profile profile){
        profileService.save(profile);
        httpSession.setAttribute("currentPlayerId", profile.getPlayerId());
        return new ModelAndView("redirect:/Profile/" + profile.getPlayerId());

    }

    @RequestMapping(value = "/Survey", method = RequestMethod.GET)
    public ModelAndView showSurveyPage(){
        return new ModelAndView("Survey");
    }
}
