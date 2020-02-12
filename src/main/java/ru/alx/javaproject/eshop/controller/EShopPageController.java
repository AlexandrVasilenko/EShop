package ru.alx.javaproject.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.DTO.AbilityResultDto;
import ru.alx.javaproject.eshop.entity.Ability;
import ru.alx.javaproject.eshop.entity.Profile;
import ru.alx.javaproject.eshop.service.AbilityService;
import ru.alx.javaproject.eshop.service.ProfileService;
import ru.alx.javaproject.eshop.service.ResultService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("EShop")
public class EShopPageController {

    @Autowired
    private ResultService resultService;

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
        AbilityResultDto list = new AbilityResultDto();
        list.setAbilityList(abilityService.findAll());
        Profile profile;
        if(httpSession.getAttribute("currentPlayerId") != null){
            profile = profileService.findOneById((int) httpSession.getAttribute("currentPlayerId"));
        } else {
            profile = new Profile("No Profile found","MeatEater",0 ,0 ,0 ,false,false,false,"");
        }


        modelAndView.addObject("abilities", listOfAbilities);
        modelAndView.addObject("profile", profile);
        modelAndView.addObject("resultDTO", list);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView eshopListSubmit(@ModelAttribute AbilityResultDto resultDTO) {
        ModelAndView modelAndView = new ModelAndView("redirect:/Result");
        if(httpSession.getAttribute("currentPlayerId") == null){
            modelAndView.setViewName("redirect:EShop");
        } else {
            resultService.save((int) httpSession.getAttribute("currentPlayerId"), resultDTO.getAbilityList());
        }
        return modelAndView;
    }
}
