package com.projects.car.endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.car.domain.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarEndPointTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void givenInvalidCarDetailsShouldReturnError() throws JsonProcessingException {
        Car car = new Car("","hybrid");
        HttpEntity httpEntity = getStringHttpEntity(car);
        ResponseEntity<String> response=  restTemplate.postForEntity("/api/cars",httpEntity,String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Test
    void givenValidaCarDetailsShouldStoreCarInformation() throws JsonProcessingException {
        Car car = new Car("prius","hybrid");
        HttpEntity httpEntity = getStringHttpEntity(car);
        ResponseEntity<String> response=  restTemplate.postForEntity("/api/cars",httpEntity,String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    private HttpEntity<String> getStringHttpEntity(Car car) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String jsonMetaData = mapper.writeValueAsString(car);
        return new HttpEntity<String>(jsonMetaData, headers);

    }
}
