package ru.alx.javaproject.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.model.Profile;
import ru.alx.javaproject.eshop.repository.ProfileRepository;


@Controller
public class SurveyPageController {

    @Autowired
    private ProfileRepository profileRepository;

    @RequestMapping(value = "/Survey", method = RequestMethod.POST)
    public ModelAndView getProfileInfo(@ModelAttribute ("profile") Profile profile){

        profileRepository.save(profile);
        return new ModelAndView("redirect:/Profile/" + profile.getPlayerId());

    }


    @RequestMapping(value = "/Survey", method = RequestMethod.GET)
    public ModelAndView showLoginPage(){
        return new ModelAndView("Survey");
    }
}
