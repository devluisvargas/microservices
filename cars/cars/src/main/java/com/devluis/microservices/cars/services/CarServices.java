package com.devluis.microservices.cars.services;

import com.devluis.microservices.cars.entities.Car;
import com.devluis.microservices.cars.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServices {

    private final CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Optional<Car> getById(Long id) {
        return carRepository.findById(id);
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllByUserId(Long id) {
        return carRepository.findByUserId(id);
    }
}
