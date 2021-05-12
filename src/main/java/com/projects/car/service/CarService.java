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
      /*  for ( Map.Entry<String,Car> entry : carMap.entrySet()
             ) {
            System.out.println(entry.getKey());
        }*/
        if (!carMap.containsKey(name)) {
            //System.out.println("Venu" + carMap.get(name));
            return Optional.empty();

        }
        return Optional.of(carMap.get(name));
    }

    public Optional<Car> saveCarDetails(Car carDetails) {
        if (!isValidCarDetails(carDetails)) return Optional.empty();
       carMap.put(carDetails.getName(),carDetails);
        return Optional.of(carDetails);
   }

    private boolean isValidCarDetails (Car carDetails){
        return !carDetails.getName().isEmpty() && null != carDetails.getName() && null != carDetails.getModel() && !carDetails.getModel().isEmpty();
    }
}