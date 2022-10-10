package com.devluis.microservices.users.services.feignclients;

import com.devluis.microservices.users.models.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "car-service")
public interface CarFeignClient {

    @PostMapping("/cars")
    Car save(@RequestBody Car car);

    @GetMapping("cars/user/{id}")
    List<Car> findByUserId(@PathVariable Long id);

}
