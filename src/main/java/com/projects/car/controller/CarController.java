package com.projects.car.controller;

import com.projects.car.domain.Car;
import com.projects.car.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController

public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    public ResponseEntity<Car> getCarDetails(String name) {

       // System.out.println(name);
       Optional<Car> car= carService.getCarDetails(name);
       // System.out.println(car.get());
       if(!car.isPresent()) return ResponseEntity.notFound().build();

       return new ResponseEntity(car, HttpStatus.OK);

    }

    @PostMapping("/api/cars")
    public ResponseEntity<Car> saveCarDetails(@RequestBody Car car) {
        Optional<Car> carSaved = carService.saveCarDetails(car);
        if(!carSaved.isPresent()) return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity(carSaved,HttpStatus.OK);
    }
}
