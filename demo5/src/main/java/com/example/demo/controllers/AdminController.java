package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showAllUsers(Model model){
        model.addAttribute("allUsers", userService.getAllUsers());
        return "show-all-users";
    }

    @RequestMapping("/new")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @RequestMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "form";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

}
