package ru.alx.javaproject.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.model.Profile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfilePageController {

    @Autowired
    private Profile profile;

    public  List<Profile> profiles = new ArrayList<>();

    @RequestMapping (value = "Profile")
    public ModelAndView resultProfilePageLoader (){
        ModelAndView modelAndView = new ModelAndView("/Profile.html");

        modelAndView.addObject("profiles", profiles);
        return modelAndView;
    }

    @RequestMapping(value = "/Profile/{profileId}", method = RequestMethod.GET)
    public ModelAndView profilePageLoader (@PathVariable("playerId") int playerId){

        ModelAndView modelAndView = new ModelAndView("/Profile.html");
        Profile profile = findProfile(playerId);
        modelAndView.addObject("profile",profile);

        return modelAndView;
    }

    private Profile findProfile (int playerId){
        profiles.add(profile);
            for (Profile profile: profiles){
                if (profile.getPlayerId() ==(playerId)){
                    return profile;
                }
        }
            throw new NotFoundException();
    }

    @ResponseStatus (HttpStatus.NOT_FOUND)
    public static class NotFoundException extends  RuntimeException{}
}
