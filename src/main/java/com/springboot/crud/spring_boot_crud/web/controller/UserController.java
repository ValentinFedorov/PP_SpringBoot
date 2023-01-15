package com.springboot.crud.spring_boot_crud.web.controller;

import com.springboot.crud.spring_boot_crud.web.model.User;
import com.springboot.crud.spring_boot_crud.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String showAllUsers (Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);

        return "all-users";
    }

    @RequestMapping(value = "/addUsers")
    public String addUsers (Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/changeUser/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute(userService.getUserById(id));
        return "updateUsers";
    }

    @PatchMapping("/changeUser/{id}")
    public String editUser(@PathVariable("id") long id, @ModelAttribute("user") User user) {
        userService.updateUser(id, user);
        return "redirect:/";
    }
}
