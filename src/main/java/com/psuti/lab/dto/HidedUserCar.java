package com.psuti.lab.dto;
import com.psuti.lab.entities.Car;
import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

@Getter
public class HidedUserCar implements Serializable {
    private final UUID id;
    private final String model;
    private final String color;
    private final String number;


    public HidedUserCar(Car car) {
        this.id = car.getId();
        this.model = car.getModel();
        this.color = car.getColor();
        this.number = car.getNumber();
    }
}
