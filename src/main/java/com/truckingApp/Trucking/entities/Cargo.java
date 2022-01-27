package com.truckingApp.Trucking.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Cargo {


    @GeneratedValue
    @Id
    private long cargoId;
    private String cargoName;
    private Boolean requiresCertification;


}
