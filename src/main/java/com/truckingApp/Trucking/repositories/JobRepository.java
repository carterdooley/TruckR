package com.truckingApp.Trucking.repositories;


import com.truckingApp.Trucking.entities.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository <Jobs, Long> {
    
}
