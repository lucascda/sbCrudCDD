package com.example.springbootcdd.repositories;

import com.example.springbootcdd.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
