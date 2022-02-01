package com.truckingApp.Trucking.model;


import com.truckingApp.Trucking.entities.UserCertification;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCertificationDto {

    private Long certificationId;
    private Long driverId;
    private Long cargoId;


    public UserCertificationDto(UserCertification userCertification) {
        this.certificationId = userCertification.getCertificationId();
        this.driverId = userCertification.getDriverId();
        this.cargoId = userCertification.getCargoId();
    }

}

