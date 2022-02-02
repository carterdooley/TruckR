package com.truckingApp.Trucking.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private Boolean employer;
    @NotNull
    private Boolean driver;
    private Boolean admin;

}
