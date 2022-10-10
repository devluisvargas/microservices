package com.devluis.microservices.motorcycles.services;

import com.devluis.microservices.motorcycles.entities.Motocycle;
import com.devluis.microservices.motorcycles.repositories.MotocycleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MotocycleService {
    private final MotocycleRepository carRepository;

    public List<Motocycle> getAll() {
        return carRepository.findAll();
    }

    public Optional<Motocycle> getById(Long id) {
        return carRepository.findById(id);
    }

    public Motocycle save(Motocycle car) {
        return carRepository.save(car);
    }

    public List<Motocycle> getAllByUserId(Long id) {
        return carRepository.findByUserId(id);
    }
}
