package com.truckingApp.Trucking.repositories;


import com.truckingApp.Trucking.entities.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <Users, Long>{

    List<Users> findAllByEmployer(Boolean employer);
    List<Users> findByDriver(Boolean driver);
    Users findByUsername (String username);

    static Users ifDriver(Boolean driver) {
        return null;
    }
}
