package com.truckingApp.Trucking.services;


import com.truckingApp.Trucking.entities.Cargo;
import com.truckingApp.Trucking.model.CargoDto;
import com.truckingApp.Trucking.model.UserDto;
import com.truckingApp.Trucking.repositories.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class CargoServiceImpl implements CargoService{

    private final CargoRepository cargoRepository;


    @Override
    public List<CargoDto> findAllCargo() {
        return cargoRepository.findAll().stream().map(CargoDto::new).collect(Collectors.toList());
    }



    @Override
    public CargoDto createCargo(CargoDto cargoDto) {
        Cargo cargo = new Cargo();
        cargo.setCargoName(cargoDto.getCargoName());
        cargo.setRequiresCertification(cargoDto.getRequiresCertification());
        return new CargoDto (cargoRepository.save(cargo));
    }

    @Override
    public void deleteCargoById(Long Id){

        cargoRepository.deleteById(Id);
        return;
    }
}
