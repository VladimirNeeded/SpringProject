package com.sukhyna.controller;

import com.sukhyna.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping (value = "/params", method = RequestMethod.GET)
    public ModelAndView paramExample(@RequestParam String name, @RequestParam Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("age", age);
        mv.setViewName("params");
        return mv;
    }

//    @RequestMapping (value = "/add-user", method = RequestMethod.GET)
//    public ModelAndView addUser(ModelAndView mv){
//        mv.addObject("user", new User());
//        mv.setViewName("add-user");
//        return mv;
//    }
//
//    @RequestMapping (value = "/add-user", method = RequestMethod.POST)
//    public ModelAndView addUser(@ModelAttribute User user){
//        return null;
//    }
}
