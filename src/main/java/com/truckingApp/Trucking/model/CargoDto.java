package com.truckingApp.Trucking.model;


import com.truckingApp.Trucking.entities.Cargo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CargoDto {
    private long cargoId;
    private String cargoName;
    private Boolean requiresCertification;

    public CargoDto(Cargo cargo) {
        this.cargoId = cargo.getCargoId();
        this.cargoName = cargo.getCargoName();
        this.requiresCertification = cargo.getRequiresCertification();
    }
}
