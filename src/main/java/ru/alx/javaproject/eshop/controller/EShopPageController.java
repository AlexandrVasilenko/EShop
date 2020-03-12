package ru.alx.javaproject.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.entity.Ability;
import ru.alx.javaproject.eshop.entity.Profile;
import ru.alx.javaproject.eshop.service.AbilityService;
import ru.alx.javaproject.eshop.service.ProfileService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("EShop")
public class EShopPageController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private AbilityService abilityService;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView eshopPageLoader() {
        ModelAndView modelAndView = new ModelAndView("EShop");

        List<Ability> listOfAbilities = abilityService.findAll();
        Profile profile;
        if(httpSession.getAttribute("currentPlayerId") != null){
            profile = profileService.findById((int) httpSession.getAttribute("currentPlayerId"));
        } else {
            profile = new Profile("No Profile found","MeatEater",0 ,0 ,0 ,false,false,false,"");
        }

        modelAndView.addObject("abilityList", listOfAbilities);
        modelAndView.addObject("profile", profile);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView eshopListSubmit(@ModelAttribute List abilityList) {
        ModelAndView modelAndView = new ModelAndView("redirect:/Result");
        List<Ability> list = abilityList;
        if(httpSession.getAttribute("currentPlayerId") == null){
            modelAndView.setViewName("redirect:EShop");
        } else {
            Profile profile = profileService.findById((int) httpSession.getAttribute("currentPlayerId"));
            profile.setAbilities(list);
            profileService.save(profile);
        }
        return modelAndView;
    }
}
