package com.example.springbootcdd.requests;

import java.time.Instant;

import javax.validation.constraints.NotBlank;

import com.example.springbootcdd.entities.OrderStatus;
import com.example.springbootcdd.entities.User;

public class CreateOrderRequest {

    @NotBlank
    Instant moment;
    @NotBlank
    OrderStatus orderStatus;
    @NotBlank
    User client;

    
    public CreateOrderRequest(Instant moment, OrderStatus orderStatus, User client) {
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.client = client;
    }
    
}
