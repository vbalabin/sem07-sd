package com.psuti.lab.controller;

import com.psuti.lab.dao.CarRepository;
import com.psuti.lab.dto.HidedUserCar;
import com.psuti.lab.entities.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RequestMapping("/cars")
@RestController
public class CarRestController {
    private final CarRepository carRepository;

    @Autowired
    public CarRestController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<HidedUserCar> getAll(){
        List<Car> allCars = carRepository.findAll();
        List<HidedUserCar>  hidedUserCars = new ArrayList<HidedUserCar>();
        for (Car car : allCars)
        {
            hidedUserCars.add(new HidedUserCar(car));
        }
        return hidedUserCars;
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable("id") UUID id){
        return carRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id")UUID id){
        carRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Car update(@PathVariable("id")UUID id, @RequestBody Car car){
        carRepository.deleteById(id);
        return carRepository.save(car);
    }

    @PostMapping
    public Car create(@RequestBody Car car){
        UUID id = car.getId();
        if(id != null){
            if(carRepository.existsById(car.getId())){
                throw new EntityExistsException(
                        String.format(Locale.getDefault(),
                                "Car with id: %s already exists",
                                car.getId()));
            }
        }
        return carRepository.save(car);
    }
}

