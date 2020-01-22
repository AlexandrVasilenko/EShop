package ru.alx.javaproject.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.DTO.AbilityResultDTO;
import ru.alx.javaproject.eshop.entity.Profile;
import ru.alx.javaproject.eshop.entity.Result;
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
    public ModelAndView resultPageLoader() throws Exception {

        //Result result = resultRepository.findOne((int)httpSession.getAttribute("currentPlayerId"));
        //AbilityResultDTO abilityList = new AbilityResultDTO();
        //abilityList.setAbilityList(resultRepository.findOne((int)httpSession.getAttribute("currentPlayerId")).getAbilityList());

        ModelAndView modelAndView = new ModelAndView("Result");
        modelAndView.addObject("abilities", resultRepository.findOne((int)httpSession.getAttribute("currentPlayerId")).getAbilityList());
        return modelAndView;
    }



}

