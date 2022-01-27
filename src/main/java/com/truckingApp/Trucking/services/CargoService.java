package com.truckingApp.Trucking.services;

import com.truckingApp.Trucking.model.CargoDto;

import java.util.List;

public interface CargoService {


    List<CargoDto> findAllCargo();

    CargoDto createCargo(CargoDto cargo);

    void deleteCargoById(Long Id);

}
