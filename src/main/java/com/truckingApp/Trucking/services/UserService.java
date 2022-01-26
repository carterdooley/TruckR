package com.truckingApp.Trucking.services;

import com.truckingApp.Trucking.model.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> findAllUsers();

    UserDto createUser(UserDto user);

    void deleteUsersById(Long Id);

    Optional<UserDto> updateUser (UserDto user);

}
