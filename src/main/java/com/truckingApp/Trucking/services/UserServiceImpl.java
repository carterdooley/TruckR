package com.truckingApp.Trucking.services;


import com.truckingApp.Trucking.entities.Users;
import com.truckingApp.Trucking.model.UserDto;
import com.truckingApp.Trucking.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserServiceImpl implements UserService {

    private final UserRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository usersRepository) {
        super();
        this.usersRepository = usersRepository;
    }



    @Override
    public List<UserDto> findAllUsers() {
        return usersRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }


    @Override
    public UserDto createUser(UserDto userDto) {
        Users user = new Users();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
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


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities());
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }


}
