package com.example.my_springboot.controller;

import com.example.my_springboot.model.User;
import com.example.my_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired()
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String allUsers(Model model){
        List<User> user=userService.getAllUsers();
        model.addAttribute("users",user);
        return "users";
    }
    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @GetMapping("/new")
    public String creatUserForm(User user) {
        return "create";
    }
    @PostMapping("/new")
    public String createUser(User user){
    userService.saveUser(user);
    return "redirect:/";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/";
    }
    @GetMapping("edit/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit")
    public String updateUser(@Valid User user){
        userService.saveUser(user);
        return "redirect:/";
    }
}