package com.truckingApp.Trucking.controllers;


import com.truckingApp.Trucking.model.CargoDto;
import com.truckingApp.Trucking.services.CargoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class CargoController {

    public final CargoService cargoService;



    @GetMapping("/cargo")
    public String getAllCargo(Model model){
        cargoService.findAllCargo();
        model.addAttribute("cargo", cargoService.findAllCargo());
        model.addAttribute("newCargo", new CargoDto());
        return "/cargo";
    }



    @PostMapping("/cargo")
    public String createNewCargo(@ModelAttribute CargoDto newCargo, Model model){
        cargoService.createCargo(newCargo);
        model.addAttribute("cargo", cargoService.findAllCargo());
        model.addAttribute("newCargo", new CargoDto());
        return "/cargo";

    }

    @GetMapping("/cargo")
    public String deleteCargo(@PathVariable long id, Model model){
        cargoService.deleteCargoById(id);
        model.addAttribute("cargo", cargoService.findAllCargo());
        model.addAttribute("newCargo", new CargoDto());
        return "/cargo";
    }


}
