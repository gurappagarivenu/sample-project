package com.projects.car.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarDomainTester {

    @Test
    void givenCarNameShouldReturnCarWithSameName() {

        Car car = new Car("prius","hybrid");

        assertThat(car.getName()).isEqualTo("prius");

    }
}
