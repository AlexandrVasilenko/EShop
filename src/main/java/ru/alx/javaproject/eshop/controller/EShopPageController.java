package ru.alx.javaproject.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.DTO.AbilityResultDTO;
import ru.alx.javaproject.eshop.entity.Ability;
import ru.alx.javaproject.eshop.entity.Profile;
import ru.alx.javaproject.eshop.entity.Result;
import ru.alx.javaproject.eshop.repository.AbilitiesRepository;
import ru.alx.javaproject.eshop.repository.ProfileRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EShopPageController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AbilitiesRepository abilitiesRepository;

    @Autowired
    private HttpSession httpSession;

    @RequestMapping(name ="/EShop", method = RequestMethod.GET)
    public ModelAndView abilityPageLoader() {
        ModelAndView modelAndView = new ModelAndView("EShop.html");

        List<Ability> listOfAbilities = abilitiesRepository.findAll();
        AbilityResultDTO list = new AbilityResultDTO();
        list.setAbilityList(abilitiesRepository.findAll());

        Profile profile = profileRepository.findOne((int)httpSession.getAttribute("currentProfileId"));

        modelAndView.addObject("abilities",listOfAbilities);
        modelAndView.addObject("profile", profile);
        modelAndView.addObject("resultDTO", list);
        return modelAndView;
    }

    @RequestMapping(name = "/Eshop", method = RequestMethod.POST)
    public ModelAndView abilityListSubmit (@ModelAttribute AbilityResultDTO resultDTO){
        List<Ability> listOfAbility = new ArrayList<>();
        for (Ability ability:resultDTO.getAbilityList()) {
            listOfAbility.add(ability);
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/Profile");

        return modelAndView;
    }
}
