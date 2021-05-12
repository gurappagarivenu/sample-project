package com.projects.car.service;

import com.projects.car.domain.Car;

import java.util.Map;
import java.util.Optional;

public class CarService {

    private Map<String, Car> carMap;

    public CarService(Map<String, Car> carMap) {
        this.carMap = carMap;
    }

    public Optional<Car> getCarDetails(String name) {
        if (!carMap.containsKey(name))
            return Optional.empty();
        return Optional.of(carMap.get(name));
    }
}