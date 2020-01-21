package ru.alx.javaproject.eshop.controller;

import com.oracle.webservices.internal.api.message.MessageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.entity.Profile;
import ru.alx.javaproject.eshop.repository.ProfileRepository;

import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;


@Controller
public class SurveyPageController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private HttpSession httpSession;

    @Context
    MessageContext context;

    @RequestMapping(value = "/Survey", method = RequestMethod.POST)
    public ModelAndView getProfileInfo(@ModelAttribute ("profile") Profile profile){
        profileRepository.save(profile);
        httpSession.setAttribute("currentProfileId", profile.getPlayerId());
        return new ModelAndView("redirect:/Profile/" + profile.getPlayerId());

    }

    @RequestMapping(value = "/Survey", method = RequestMethod.GET)
    public ModelAndView showLoginPage(){
        return new ModelAndView("Survey");
    }
}
