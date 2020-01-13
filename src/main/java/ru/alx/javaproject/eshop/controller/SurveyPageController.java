package ru.alx.javaproject.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.model.Profile;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SurveyPageController {

    @Autowired
    private Profile profile;

    @Autowired
    private ProfilePageController profilePageController;

    @RequestMapping(value = "/Survey", method = RequestMethod.POST)
    public ModelAndView getProfileInfo(Profile profile){
        this.profile.setPlayerId(1);
        this.profile.setPlayerName(profile.getPlayerName());
        this.profile.setPlayerAge(profile.getPlayerAge());
        this.profile.setSmoking(profile.isSmoking());
        this.profile.setGenderMale(profile.isGenderMale());
        this.profile.setAlcohol(profile.isAlcohol());
        this.profile.setInLove(profile.isInLove());
        this.profile.setNutritionType(profile.getNutritionType());
        this.profile.setSleepingHours(profile.getSleepingHours());
        this.profile.setSportActivity(profile.getSportActivity());
        profilePageController.profiles.add(this.profile);

        ModelAndView modelAndView = new ModelAndView("redirect:/Profile");

        return modelAndView;

    }


    @RequestMapping(value = "/Survey", method = RequestMethod.GET)
    public ModelAndView showLoginPage(){
        ModelAndView modelAndView = new ModelAndView("/Survey.html");



        //Arrays.stream(profile.getClass().getDeclaredFields()).forEach(field -> field.getName());

        Field[] fieldsList = Profile.class.getDeclaredFields();
        List<String> profileFields = new ArrayList<>();

        for (Field field: fieldsList) {
            profileFields.add(field.getName());
        }
              
        

        //modelAndView.addObject("profileContent", profileFields );


        return modelAndView;
    }
}
