package com.devluis.microservices.cars.repositories;

import com.devluis.microservices.cars.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByUserId(Long userId);
}
