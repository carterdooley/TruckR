package com.truckingApp.Trucking.model;


import com.truckingApp.Trucking.entities.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private long id;
    private String username;
    private String password;
    private Boolean employer;
    private Boolean driver;

    public UserDto(Users user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.driver = user.getDriver();
        this.employer = user.getEmployer();
    }

}