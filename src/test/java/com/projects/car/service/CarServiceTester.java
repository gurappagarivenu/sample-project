package com.projects.car.service;

import com.projects.car.domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CarServiceTester {

    private CarService carService;

    @BeforeEach
    void setUp() {
        Car car1 = new Car("prius","hybrid");
        Car car2 = new Car("bmw","hybrid");
        Car car3 = new Car("tesla","electric");
        Map<String, Car> map = new HashMap<>();
        map.put("prius",car1);
        map.put("bmw",car2);
        map.put("tesla",car3);
        carService= new CarService(map);
    }

    @Test
    void givenCarNameNotExistShouldReturnError() {
        Optional<Car> car = carService.getCarDetails("no-car");
        assertThat(car).isEqualTo(Optional.empty());
    }

    @Test
    void givenCarNameExistShoudReturnCarDetails() {
        Optional<Car> car = carService.getCarDetails("prius");
        assertThat(car.get().getName()).isEqualTo("prius");
    }
}
