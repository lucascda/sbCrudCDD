package com.example.springbootcdd.controllers;

import java.util.List;

import com.example.springbootcdd.controllers.exceptions.ResourceNotFoundException;
import com.example.springbootcdd.entities.Order;
import com.example.springbootcdd.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    OrderRepository repository;

    @GetMapping
    public ResponseEntity<List<Order>> getAll(){
        List<Order> list = repository.findAll();
        if(list == null){
            throw new ResourceNotFoundException();
        }
        return ResponseEntity.ok().body(list);
    }
    
}
