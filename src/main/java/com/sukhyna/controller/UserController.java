package com.sukhyna.controller;

import com.sukhyna.model.Role;
import com.sukhyna.model.User;
import com.sukhyna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute User user, ModelAndView mv){
        userService.add(user);
        List<User> users = userService.getAll().get();
        mv.addObject("users", users);
        mv.setViewName("users");
        return mv;
    }

//    @RequestMapping (value = "/get-user", method = RequestMethod.GET)
//    private ModelAndView getById(@RequestParam("u_id") Long id, ModelAndView mv){
//        mv.addObject("user", userService.getById(id).get());
//        mv.setViewName("user");
//        return mv;
//    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getAllUsers(ModelAndView mv){
        mv.addObject("users", userService.getAll().get());
        mv.setViewName("users");
        return mv;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView mv) {
        mv.addObject("user", new User());
        mv.setViewName("register");
        return mv;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(ModelAndView mv, @Valid @ModelAttribute User user) {
        mv.addObject("user", userService.add(user));
        mv.setViewName("home");
        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView mv) {
        mv.addObject("user", new User());
        mv.setViewName("login");
        return mv;
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ModelAndView login(ModelAndView mv, @ModelAttribute User user) {
//        mv.addObject("user", new User());
//        mv.setViewName("login");
//        return mv;
//    }
}
