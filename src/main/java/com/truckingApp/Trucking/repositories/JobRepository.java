package com.truckingApp.Trucking.repositories;


import com.truckingApp.Trucking.entities.Jobs;
import com.truckingApp.Trucking.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository <Jobs, Long> {

    List<Jobs> findAllByStart_location(Long start_location);
    List<Jobs> findAllByEnd_location(Long end_location);
}
