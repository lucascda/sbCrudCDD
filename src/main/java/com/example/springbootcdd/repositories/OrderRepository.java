package com.example.springbootcdd.repositories;

import com.example.springbootcdd.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long>{
    
}
