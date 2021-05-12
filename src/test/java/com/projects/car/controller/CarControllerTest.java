package com.projects.car.controller;

import com.projects.car.domain.Car;
import com.projects.car.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CarControllerTest {

    private CarController carController;

    private CarService carService;

    @BeforeEach
    void setUp() {
        carService=new CarService(new HashMap<>());
        carController = new CarController(carService);
    }

    @Test
    void givenCarNameNotExistShouldReturnError() {
        assertThat(carController.getCarDetails("not-found").getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void getCarDetails_givenCarNameShouldReturnCarDetails() {
        Car car = new Car("prius","hybrid");
      Optional<Car> savedCar =  carService.saveCarDetails(car);
 assertThat(carController.getCarDetails("prius").getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void givenInvalidCarDetailsShouldReturnErrorResponse() {
        Car invalidCar = new Car("","");
        assertThat(carController.saveCarDetails(invalidCar).getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    void givenCarDetailsShouldReturnSuccessResponse() {
        Car car = new Car("prius","hybrid");
       assertThat(carController.saveCarDetails(car).getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
