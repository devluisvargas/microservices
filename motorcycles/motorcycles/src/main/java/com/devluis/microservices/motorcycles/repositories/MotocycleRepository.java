package com.devluis.microservices.motorcycles.repositories;

import com.devluis.microservices.motorcycles.entities.Motocycle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotocycleRepository extends JpaRepository<Motocycle, Long> {
    List<Motocycle> findByUserId(Long userId);

}
