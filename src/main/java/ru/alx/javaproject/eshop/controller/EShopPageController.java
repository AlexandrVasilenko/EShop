package ru.alx.javaproject.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.entity.Ability;
import ru.alx.javaproject.eshop.repository.AbilitiesRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EShopPageController {

    @Autowired
    private AbilitiesRepository abilitiesRepository;

    @RequestMapping("/EShop")
    public ModelAndView productPageLoader() {
        ModelAndView modelAndView = new ModelAndView("EShop.html");

        List<Ability> listOfAbilities = abilitiesRepository.findAll();

        /*List<Ability> listOfAbilities = new ArrayList<>();
        listOfAbilities.add(new Ability(1L,"picture","Piano - basic level","Learn to play piano",40));
        listOfAbilities.add(new Ability(2L,"picture","Guitar - basic level","Learn to play piano",30));
        listOfAbilities.add(new Ability(3L,"picture","Violin - basic level","Learn to play piano",50));*/


        modelAndView.addObject("abilities",listOfAbilities);


        return modelAndView;
    }


}
