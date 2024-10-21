package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.backend.model.Person;
import com.example.backend.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/list";
    }

    @GetMapping("/new")
    public String showNewUserForm(Model model) {
        Person user = new Person();
        model.addAttribute("user", user);
        return "/form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") Person user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable("id") String id, Model model) {
    	Person user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") String id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }
}