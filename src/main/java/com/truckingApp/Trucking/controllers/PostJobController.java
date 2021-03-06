package com.truckingApp.Trucking.controllers;


import com.truckingApp.Trucking.model.JobDto;
import com.truckingApp.Trucking.services.JobService;
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
public class PostJobController {


    public final JobService jobservice;



    @GetMapping("/Jobs")
    public String postJobPage(Model model) {
        jobservice.findAllJobs();
        clearModelJ(model);
        return "Jobs";
    }

    @PostMapping("/Jobs")
    public String createNewJob(@ModelAttribute JobDto newJob, Model model)  {
        jobservice.createNewJob(newJob);
        clearModelJ(model);
        return "Jobs";
    }


    @PostMapping("/Jobs/{id}")
    public String updateJob(@ModelAttribute JobDto updatedJob, Model model) {
        jobservice.updateJob(updatedJob);
        clearModelJ(model);
        return "Jobs";
    }



    @GetMapping("/Jobs/delete/{id}")
    public String deleteJobById(@PathVariable long id, Model model) {
        jobservice.deleteJobsById(id);
        clearModelJ(model);
        return "Jobs";
    }

    private void clearModelJ(Model model) {
        model.addAttribute("jobs", jobservice.findAllJobs());
        model.addAttribute("newJob", new JobDto());
        model.addAttribute("updatedJob", new JobDto());
        model.addAttribute("jobName", new JobDto());
        model.addAttribute("description", new JobDto());
        model.addAttribute("cargo", new JobDto());
        model.addAttribute("start_location", new JobDto());
        model.addAttribute("end_location", new JobDto());
    }

}
