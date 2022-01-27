package com.truckingApp.Trucking.repositories;

import java.util.List;
import com.truckingApp.Trucking.entities.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository <Cargo, Long> {
    List<Cargo> findAllByCargoId(Long id);
}
