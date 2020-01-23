package ru.alx.javaproject.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.DTO.AbilityResultDTO;
import ru.alx.javaproject.eshop.entity.Ability;
import ru.alx.javaproject.eshop.entity.Profile;
import ru.alx.javaproject.eshop.repository.AbilitiesRepository;
import ru.alx.javaproject.eshop.repository.ProfileRepository;
import ru.alx.javaproject.eshop.repository.ResultRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("EShop")
public class EShopPageController {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AbilitiesRepository abilitiesRepository;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView eshopPageLoader() {
        ModelAndView modelAndView = new ModelAndView("EShop");

        List<Ability> listOfAbilities = abilitiesRepository.findAll();
        AbilityResultDTO list = new AbilityResultDTO();
        list.setAbilityList(abilitiesRepository.findAll());
        Profile profile;
        if(httpSession.getAttribute("currentPlayerId") != null){
            profile = profileRepository.findOne((int) httpSession.getAttribute("currentPlayerId"));
        } else {
            profile = new Profile("No Profile found","",0 ,0 ,0 ,false,false,false,"");
        }


        modelAndView.addObject("abilities", listOfAbilities);
        modelAndView.addObject("profile", profile);
        modelAndView.addObject("resultDTO", list);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView eshopListSubmit(@ModelAttribute AbilityResultDTO resultDTO) {
        ModelAndView modelAndView = new ModelAndView("redirect:/Result");
        resultRepository.save((int) httpSession.getAttribute("currentPlayerId"), resultDTO.getAbilityList());
        return modelAndView;
    }
}
