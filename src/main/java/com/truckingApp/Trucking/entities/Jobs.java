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
    private Long jobId;
    private String jobName;
    private Long employerId;
    private Long driverId;
    private String description;
    private String cargo;
    private Long start_location;
    private Long end_location;


}
