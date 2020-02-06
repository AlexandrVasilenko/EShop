package ru.alx.javaproject.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.repository.ProfileRepository;

import javax.servlet.http.HttpSession;


@Controller
public class AdminPageController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private HttpSession httpSession;


    @RequestMapping(value = "Admin", method = RequestMethod.GET)
    public ModelAndView adminPageLoader() {
        ModelAndView modelAndView = new ModelAndView("/Admin.html");
        modelAndView.addObject("profiles", profileRepository.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "Admin/{playerId}", method = {RequestMethod.POST, RequestMethod.DELETE})
    public ModelAndView adminPageDeleteProfile(@PathVariable("playerId") int id) {
        ModelAndView modelAndView = new ModelAndView("redirect:../Admin");
        profileRepository.deleteById(id);
        if (id == (Integer) httpSession.getAttribute("currentPlayerId")) {
            httpSession.setAttribute("currentPlayerId", null);
        }
        return modelAndView;
    }

    @RequestMapping(value = "Admin", method = RequestMethod.POST)
    public ModelAndView adminPageDeleteAll() {
        ModelAndView modelAndView = new ModelAndView("redirect:Admin");
        profileRepository.deleteAll();
        httpSession.setAttribute("currentPlayerId", null);
        return modelAndView;
    }
}
