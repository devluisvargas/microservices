package com.devluis.microservices.users.services;

import com.devluis.microservices.users.entities.User;
import com.devluis.microservices.users.models.Car;
import com.devluis.microservices.users.models.Motorcycle;
import com.devluis.microservices.users.repositories.UserRepository;
import com.devluis.microservices.users.services.feignclients.CarFeignClient;
import com.devluis.microservices.users.services.feignclients.MotorcycleFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final RestTemplate restTemplate;

    private final MotorcycleFeignClient motorcycleFeignClient;

    private final CarFeignClient carFeignClient;
    public List<Car> getCars(Long id){
        return restTemplate.getForObject("http://localhost:8082/cars/user/"+id, List.class);
    }

    public List<Motorcycle> getMotorcycles(Long id){
        return restTemplate.getForObject("http://localhost:8083/motorcycles/user/"+id, List.class);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Car saveCar(Long id, Car car){
        car.setUserId(id);
        return carFeignClient.save(car);
    }

    public Motorcycle saveMotorcycle(Long id, Motorcycle motorcycle){
        motorcycle.setUserId(id);
        return motorcycleFeignClient.save(motorcycle);
    }


    public Map<String, Object> getUserAndVechicul(Long id){
        Map<String, Object> result = new HashMap<>();
        Optional<User> optionalUser = this.getById(id);
        if(optionalUser.isEmpty()){
            result.put("Message","User not exits!");
            return result;
        }
        result.put("user", optionalUser.get());
        result.put("motorcycle", motorcycleFeignClient.findByUserId(id));
        result.put("cars", carFeignClient.findByUserId(id));
        return result;
    }
}
