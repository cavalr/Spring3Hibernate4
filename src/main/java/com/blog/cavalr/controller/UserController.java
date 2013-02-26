package com.blog.cavalr.controller;

import com.blog.cavalr.entity.User;
import com.blog.cavalr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showUserForm(Model model) {
        model.addAttribute("user",new User());
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("user",new User());
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser( Model model, User user) {
        User existing = userService.findByUserName(user.getUserName());
        if (existing != null) {
            model.addAttribute("status", "exist");
            return "index";
        }
        user.setCreatedOn(new Date());
        userService.saveUser(user);
        model.addAttribute("status", "success");
        return "index";
    }
}
