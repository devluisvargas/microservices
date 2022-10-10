package com.devluis.microservices.users.controllers;


import com.devluis.microservices.users.entities.User;
import com.devluis.microservices.users.models.Car;
import com.devluis.microservices.users.models.Motorcycle;
import com.devluis.microservices.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> optionalUser = userService.getById(id);
        if (optionalUser.isPresent())
            return ResponseEntity.ok(optionalUser.get());
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<?> getCarsById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getCars(id));
    }


    @GetMapping("/motorcycle/{id}")
    public ResponseEntity<?> getMotorCycleById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getCars(id));
    }

    @PostMapping("/cars/{id}")
    public ResponseEntity<?> saveCar(@PathVariable Long id, @RequestBody Car car) {
        return ResponseEntity.ok(userService.saveCar(id, car));
    }

    @PostMapping("/motorcycle/{id}")
    public ResponseEntity<?> saveMotorcycle(@PathVariable Long id, @RequestBody Motorcycle motorcycle) {
        return ResponseEntity.ok(userService.saveMotorcycle(id, motorcycle));
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<?> findAllByUserId(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserAndVechicul(id));
    }
}
