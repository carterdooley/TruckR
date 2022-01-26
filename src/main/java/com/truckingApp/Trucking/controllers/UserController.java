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



    @GetMapping("/accountCreation")
    public String getAllUsers(Model model) {
        userService.findAllUsers();
        clearModel(model);
        return "/accountCreation";
    }


    @PostMapping("/accountCreation")
    public String createNewUser(@ModelAttribute UserDto newUser, Model model)  {
        userService.createUser(newUser);
        clearModel(model);
        return "/accountCreation";
    }

    @GetMapping("/accountCreation/delete/{id}")
    public String deleteUser(@PathVariable long id, Model model) {
        userService.deleteUsersById(id);
        clearModel(model);
        return "/accountCreation";
    }

    @PostMapping("/accountCreation/{id}")
    public String updateUser(@ModelAttribute UserDto updatedUser, Model model) {
        userService.updateUser(updatedUser);
        clearModel(model);
        return "/accountCreation";
    }

    private void clearModel(Model model) {
        model.addAttribute("dogs", userService.findAllUsers());
        model.addAttribute("newUser", new UserDto());
        model.addAttribute("updatedUser", new UserDto());
    }
}
