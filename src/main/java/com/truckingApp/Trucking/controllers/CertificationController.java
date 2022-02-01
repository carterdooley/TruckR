package com.truckingApp.Trucking.controllers;


import com.truckingApp.Trucking.model.UserCertificationDto;
import com.truckingApp.Trucking.services.UserCertificationService;
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
public class CertificationController {

    public final UserCertificationService certificationService;

    @GetMapping("/certifications")
    public String getAllCertifications(Model model) {
        certificationService.findAllUserCertifications();
        model.addAttribute("certification", certificationService.findAllUserCertifications());
        model.addAttribute("newCertification", new UserCertificationDto());
        return "/certifications";
    }

    @PostMapping("/certifications")
    public String createNewCertification(@ModelAttribute UserCertificationDto newCertification, Model model){
        certificationService.createCertification(newCertification);
        model.addAttribute("certification", certificationService.findAllUserCertifications());
        model.addAttribute("newCertification", new UserCertificationDto());
        return "/certifications";
    }

    @GetMapping("/certifications/delete/{id}")
    public String deleteCertification(@PathVariable long id, Model model) {
        certificationService.deleteCertificationById(id);
        model.addAttribute("certification", certificationService.findAllUserCertifications());
        model.addAttribute("newCertification", new UserCertificationDto());
        return "/certifications";
    }

}
