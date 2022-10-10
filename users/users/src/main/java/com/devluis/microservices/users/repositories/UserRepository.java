package com.devluis.microservices.users.repositories;

import com.devluis.microservices.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
