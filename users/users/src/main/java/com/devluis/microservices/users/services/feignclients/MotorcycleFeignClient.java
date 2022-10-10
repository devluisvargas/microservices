package com.devluis.microservices.users.services.feignclients;

import com.devluis.microservices.users.models.Motorcycle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "motorcycle-service")
public interface MotorcycleFeignClient {

    @PostMapping("/motorcycles")
    Motorcycle save(@RequestBody Motorcycle motorcycle);

    @GetMapping("/motorcycles/user/{id}")
    List<Motorcycle> findByUserId(@PathVariable Long id);

}
