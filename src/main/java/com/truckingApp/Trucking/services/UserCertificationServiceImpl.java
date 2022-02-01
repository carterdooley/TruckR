package com.truckingApp.Trucking.services;


import com.truckingApp.Trucking.entities.UserCertification;
import com.truckingApp.Trucking.model.UserCertificationDto;
import com.truckingApp.Trucking.repositories.UserCertificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserCertificationServiceImpl implements UserCertificationService{

    private final UserCertificationRepository certificationRepository;



    @Override
    public List<UserCertificationDto> findAllUserCertifications() {
        return certificationRepository.findAll().stream().map(UserCertificationDto::new).collect(Collectors.toList());
    }


    @Override
    public UserCertificationDto createCertification(UserCertificationDto certificationDto) {
        UserCertification userCertification = new UserCertification();
        userCertification.setCargoId(certificationDto.getCargoId());
        userCertification.setDriverId(certificationDto.getDriverId());
        return new UserCertificationDto (certificationRepository.save(userCertification));
    }

    @Override
    public void deleteCertificationById(Long Id) {
        certificationRepository.deleteById(Id);
    }
}
