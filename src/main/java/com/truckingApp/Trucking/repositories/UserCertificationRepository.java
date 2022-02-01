package com.truckingApp.Trucking.repositories;


import com.truckingApp.Trucking.entities.UserCertification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface UserCertificationRepository extends JpaRepository <UserCertification, Long>{
//    List<UserCertification> findAllByDriver(Long id);
}
