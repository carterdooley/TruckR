package com.truckingApp.Trucking.services;


import com.truckingApp.Trucking.entities.Jobs;
import com.truckingApp.Trucking.model.JobDto;
import com.truckingApp.Trucking.repositories.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class JobServiceImpl implements JobService {


    private final JobRepository jobsRepository;


    @Override
    public List<JobDto> findAllJobs() {
        return jobsRepository.findAll().stream().map(JobDto::new).collect(Collectors.toList());
    }


    @Override
    public JobDto createNewJob(JobDto jobDto) {
        Jobs job= new Jobs();
        job.setJobName(jobDto.getJobName());
        job.setEmployerId(jobDto.getEmployerId());
        job.setDriverId(jobDto.getDriverId());
        job.setDescription(jobDto.getDescription());
        job.setCargo(jobDto.getCargo());
        job.setStart_location(jobDto.getStart_location());
        job.setEnd_location(jobDto.getEnd_location());
        return new JobDto (jobsRepository.save(job));
    }

    @Override
    public void deleteJobsById(Long Id) {
        jobsRepository.deleteById(Id);
    }

    @Override
    public Optional<JobDto> updateJob(JobDto jobDto) {
        Optional<Jobs> jobOptional = jobsRepository.findById(jobDto.getJobId());
        if(jobOptional.isPresent()){
            Jobs job = jobOptional.get();
            job.setJobName(jobDto.getJobName());
            job.setEmployerId(jobDto.getEmployerId());
            job.setDriverId(jobDto.getDriverId());
            job.setDescription(jobDto.getDescription());
            job.setCargo(jobDto.getCargo());
            job.setStart_location(jobDto.getStart_location());
            job.setEnd_location(jobDto.getEnd_location());
            return Optional.of(new JobDto(jobsRepository.save(job)));
        }


        return Optional.empty();
    }
}
