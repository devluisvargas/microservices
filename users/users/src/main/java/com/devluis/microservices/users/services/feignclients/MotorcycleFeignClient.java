package com.devluis.microservices.users.services.feignclients;

import com.devluis.microservices.users.models.Motorcycle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(url = "http://localhost:8083/motorcycles", name = "motorcycles-service")
public interface MotorcycleFeignClient {

    @PostMapping
    Motorcycle save(@RequestBody Motorcycle motorcycle);

    @GetMapping("/user/{id}")
    List<Motorcycle> findByUserId(@PathVariable Long id);

}
