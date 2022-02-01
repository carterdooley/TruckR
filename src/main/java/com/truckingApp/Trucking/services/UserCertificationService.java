package com.truckingApp.Trucking.services;

import com.truckingApp.Trucking.entities.UserCertification;
import com.truckingApp.Trucking.model.UserCertificationDto;

import java.util.List;

public interface UserCertificationService {

    List<UserCertificationDto> findAllUserCertifications();

    UserCertificationDto createCertification(UserCertificationDto certification);

    void deleteCertificationById(Long id);
}
