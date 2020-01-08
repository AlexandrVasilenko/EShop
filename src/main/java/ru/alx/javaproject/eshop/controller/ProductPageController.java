package ru.alx.javaproject.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductPageController {

    @RequestMapping("/Products")
    public ModelAndView productPageLoader() {
        ModelAndView modelAndView = new ModelAndView("products.html");

        List<String> listOfProducts = new ArrayList<>();
        listOfProducts.add("BMW");
        listOfProducts.add("Audi");
        listOfProducts.add("Mercedes");

        modelAndView.addObject("listOfProducts",listOfProducts);

        return modelAndView;
    }


}
