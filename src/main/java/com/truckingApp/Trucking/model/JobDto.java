package com.truckingApp.Trucking.model;

import com.truckingApp.Trucking.entities.Jobs;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class JobDto {
    private Long jobId;
    private String jobName;
    private Long employerId;
    private Long driverId;
    private String description;
    private String cargo;
    private Long start_location;
    private Long end_location;



    public JobDto(Jobs job) {
        this.jobId = job.getJobId();
        this.jobName = job.getJobName();
        this.employerId = job.getEmployerId();
        this.driverId = job.getDriverId();
        this.description = job.getDescription();
        this.cargo = job.getCargo();
        this.start_location = job.getStart_location();
        this.end_location = job.getEnd_location();
    }
}
