package org.parking.parkinglot.common;

import org.parking.parkinglot.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    Long id;
    String username;
    String email;

    List<Car> cars = new ArrayList<>();

    public UserDto(Long id, String username, List<Car> cars, String email) {
        this.id = id;
        this.username = username;
        this.cars = cars;
        this.email = email;
    }
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public List<Car> getCars() {
        return cars;
    }



}
