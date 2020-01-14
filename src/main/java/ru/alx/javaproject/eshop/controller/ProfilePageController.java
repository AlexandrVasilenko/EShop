package ru.alx.javaproject.eshop.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.model.Profile;
import ru.alx.javaproject.eshop.repository.ProfileRepository;


@Controller
public class ProfilePageController {

    @Autowired
    Profile profile;

    @Autowired
    private ProfileRepository profileRepository;

    @RequestMapping(value = "/Profile/{profileId}", method = RequestMethod.GET)
    public ModelAndView profilePageLoader(@PathVariable("profileId") int playerId) throws NotFoundException {

        Profile profile = profileRepository.findById(playerId);
        if (profile == null) {
            throw new NotFoundException("Profile is not found");
        }

        ModelAndView modelAndView = new ModelAndView("/Profile");
        modelAndView.addObject("profile", profile);
        return modelAndView;
    }

    @RequestMapping (value = "/Profile")
    public ModelAndView defaultProfilePageLoader (){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("profile", profile);
        return modelAndView;
    }

}

