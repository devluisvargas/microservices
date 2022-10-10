package com.devluis.microservices.cars.controllers;

import com.devluis.microservices.cars.entities.Car;
import com.devluis.microservices.cars.services.CarServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarServices carService;

    @GetMapping
    public List<Car> getCars() {
        return carService.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id) {
        Optional<Car> optionalCar = carService.getById(id);
        if (optionalCar.isPresent())
            return ResponseEntity.ok(optionalCar.get());
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Car car){
        return ResponseEntity.ok(carService.save(car));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getCarsByUserId(@PathVariable(name = "userId") Long id) {
        return  ResponseEntity.ok(carService.getAllByUserId(id));
    }
}
