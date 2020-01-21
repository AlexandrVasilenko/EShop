package ru.alx.javaproject.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.entity.Profile;
import ru.alx.javaproject.eshop.repository.ProfileRepository;
import ru.alx.javaproject.eshop.repository.ResultRepository;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;


@Controller
public class ResultPageController {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private HttpSession httpSession;


    @RequestMapping(value = "/Result", method = RequestMethod.GET)
    public ModelAndView profilePageLoader() throws Exception {


        Profile profile = profileRepository.findOne((int)httpSession.getAttribute("currentPlayerId"));
        resultRepository.findOne((int)httpSession.getAttribute("currentPlayerId"));

        if (profile == null) {
            throw new Exception("Profile is not found");
        }

        ModelAndView modelAndView = new ModelAndView("Profile");
        modelAndView.addObject("profile", profile);
        return modelAndView;
    }


    @RequestMapping (value = "/Profile")
    public ModelAndView defaultProfilePageLoader () throws SQLException {
        ModelAndView modelAndView = new ModelAndView("Profile.html");

        // TODO get default profile from session


        modelAndView.addObject("profile", profileRepository.findOne((int)httpSession.getAttribute("currentProfileId")));
        return modelAndView;
    }

}

