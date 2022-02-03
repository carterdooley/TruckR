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
public class JobController {


    public final JobService jobService;

    @GetMapping("/ViewJobs")
    public String findAllJobs(Model model) {
        String page;
        jobService.findAllJobs();
        clearModelJ(model);
        return "ViewJobs";
    }


    @PostMapping("/ViewJobs/")
    public String createNewJob(@ModelAttribute JobDto newJob, Model model)  {
        jobService.createNewJob(newJob);
        clearModelJ(model);
        return "ViewJobs";
    }

    @GetMapping("/ViewJobs/delete/{id}")
    public String deleteJobById(@PathVariable long id, Model model) {
        jobService.deleteJobsById(id);
        clearModelJ(model);
        return "ViewJobs";
    }

    @PostMapping("/ViewJobs/{id}")
    public String updateJob(@ModelAttribute JobDto updatedJob, Model model) {
        jobService.updateJob(updatedJob);
        clearModelJ(model);
        return "ViewJobs";
    }

    private void clearModelJ(Model model) {
        model.addAttribute("jobs", jobService.findAllJobs());
        model.addAttribute("newJob", new JobDto());
        model.addAttribute("updatedJob", new JobDto());
        model.addAttribute("jobName", new JobDto());
        model.addAttribute("description", new JobDto());
        model.addAttribute("cargo", new JobDto());
        model.addAttribute("start_location", new JobDto());
        model.addAttribute("end_location", new JobDto());
    }
}






