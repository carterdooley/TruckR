package com.truckingApp.Trucking.entities;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.lang.ref.Reference;

@Entity
@Data
public class Jobs {


    @Id
    @GeneratedValue
    private long jobId;
    private String jobName;
    private long employerId;
    private long driverId;
    private String description;
    private String cargo;
    private long start_location;
    private long end_location;


}
