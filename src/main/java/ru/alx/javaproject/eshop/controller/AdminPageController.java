package ru.alx.javaproject.eshop.controller;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.alx.javaproject.eshop.model.Profile;
import ru.alx.javaproject.eshop.repository.ProfileRepository;

@Controller
public class AdminPageController {

    @Autowired
    private ProfileRepository profileRepository;

    @RequestMapping(value = "/Admin", method = RequestMethod.GET)
    public ModelAndView adminPageLoader (){
        ModelAndView modelAndView = new ModelAndView("/Admin.html");
        modelAndView.addObject("profiles", profileRepository.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "Admin/{playerId}", method = {RequestMethod.POST, RequestMethod.DELETE}, params = "_method=delete")
    public ModelAndView adminPageDeleteProfile(@PathVariable ("playerId") int id){
        ModelAndView modelAndView = new ModelAndView("redirect:../Admin");
        profileRepository.delete(id);


        return modelAndView;
    }
}
