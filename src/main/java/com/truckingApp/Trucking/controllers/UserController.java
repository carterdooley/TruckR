package com.truckingApp.Trucking.controllers;

import com.truckingApp.Trucking.model.UserDto;
import com.truckingApp.Trucking.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserController {

    public final UserService userService;



    @GetMapping("/users")
    public String getAllUsers(Model model) {
        userService.findAllUsers();
        model.addAttribute("users",userService.findAllUsers());
        model.addAttribute("newUser", new UserDto());
        return "users";
    }


    @PostMapping("/users")
    public String createNewUser(@ModelAttribute UserDto newUser, Model model)  {
        userService.createUser(newUser);
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("newUser", new UserDto());
        return "users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable long id, Model model) {
        userService.deleteUsersById(id);
        model.addAttribute("dogs", userService.findAllUsers());
        model.addAttribute("newUser", new UserDto());
        return "users";
    }

    @PostMapping("/users/{id}")
    public String updateUser(@ModelAttribute UserDto updatedUser, Model model) {
        userService.updateUser(updatedUser);
        model.addAttribute("dogs", userService.findAllUsers());
        model.addAttribute("newUser", new UserDto());
        return "users";
    }
}
