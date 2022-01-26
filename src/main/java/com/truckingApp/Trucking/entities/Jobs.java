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
    private long jobID;
    private String jobName;
    private long employerID;

}
