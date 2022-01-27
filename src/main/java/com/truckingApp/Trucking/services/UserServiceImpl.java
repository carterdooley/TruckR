package com.truckingApp.Trucking.services;


import com.truckingApp.Trucking.entities.Users;
import com.truckingApp.Trucking.model.UserDto;
import com.truckingApp.Trucking.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserServiceImpl implements UserService{

    private final UserRepository usersRepository;


    @Override
    public List<UserDto> findAllUsers() {
        return usersRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }


    @Override
    public UserDto createUser(UserDto userDto) {
        Users user = new Users();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setDriver(userDto.getDriver());
        user.setEmployer(userDto.getEmployer());
        user.setAdmin(userDto.getAdmin());
        return new UserDto (usersRepository.save(user));
    }

    @Override
    public void deleteUsersById(Long Id) {
        usersRepository.deleteById(Id);
        return;
    }

    @Override
    public Optional<UserDto> updateUser(UserDto userDto) {
        Optional<Users> userOptional = usersRepository.findById(userDto.getId());
        if(userOptional.isPresent()){
            Users user = userOptional.get();
            user.setDriver(userDto.getDriver());
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user.setEmployer(userDto.getEmployer());
            user.setAdmin(userDto.getAdmin());
            return Optional.of(new UserDto(usersRepository.save(user)));
        }
        return Optional.empty();
    }
}
