package com.truckingApp.Trucking.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class UserCertification {


    @Id
    @GeneratedValue
    private Long certificationId;
    private Long driverId;
    private Long cargoId;
}
