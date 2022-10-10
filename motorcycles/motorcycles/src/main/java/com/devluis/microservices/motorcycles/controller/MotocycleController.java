package com.devluis.microservices.motorcycles.controller;

import com.devluis.microservices.motorcycles.entities.Motocycle;
import com.devluis.microservices.motorcycles.services.MotocycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/motorcycles")
public class MotocycleController {
    private final MotocycleService motocycleService;

    @GetMapping
    public List<Motocycle> getMotocycles() {
        return motocycleService.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getMotocycleById(@PathVariable Long id) {
        Optional<Motocycle> optionalMotocycle = motocycleService.getById(id);
        if (optionalMotocycle.isPresent())
            return ResponseEntity.ok(optionalMotocycle.get());
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Motocycle motocycle){
        return ResponseEntity.ok(motocycleService.save(motocycle));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getMotocyclesByUserId(@PathVariable(name = "userId") Long id) {
        return  ResponseEntity.ok(motocycleService.getAllByUserId(id));
    }
}
