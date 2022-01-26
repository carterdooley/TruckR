package com.truckingApp.Trucking.entities;

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
    private long id;
    private String username;
    private String password;
    private Boolean employer;
    private Boolean driver;

}
