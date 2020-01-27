package ru.alx.javaproject.eshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.entity.User;
import ru.alx.javaproject.eshop.service.UserRegistrator;
import ru.alx.javaproject.eshop.service.UserValidator;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
@RequestMapping(value = "Registration")
public class RegistrationPageController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationPageController.class);

    @Autowired
    UserRegistrator userRegistrator;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView registrationPageLoader (){
        return new ModelAndView ("Registration");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView submitNewAdminUser (@ModelAttribute ("user") User user){
        ModelAndView modelAndView = new ModelAndView();

        if (userRegistrator.registerNewUser(user)) {
            modelAndView.setViewName("redirect:/Welcome");
            modelAndView.addObject("isAdmin", "true");
        }else{
            modelAndView.setViewName("redirect:/Registration");
            modelAndView.addObject("error", true);
        }
        return modelAndView;
    }
}
