package com.truckingApp.Trucking.services;

import com.truckingApp.Trucking.model.JobDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface JobService {
    List<JobDto> findAllJobs();

    JobDto createNewJob(JobDto job);


    void deleteJobsById(Long Id);

    Optional<JobDto> updateJob (JobDto job);
}
