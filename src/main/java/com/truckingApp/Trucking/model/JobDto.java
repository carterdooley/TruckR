package com.truckingApp.Trucking.model;

import com.truckingApp.Trucking.entities.Jobs;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class JobDto {
    private long jobId;
    private String jobName;
    private long employerId;
    private long driverId;
    private String description;
    private String cargo;
    private long start_location;
    private long end_location;



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
