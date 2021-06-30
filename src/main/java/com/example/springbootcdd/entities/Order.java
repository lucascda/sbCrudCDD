package com.example.springbootcdd.entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'hh:MM:ss'Z'", timezone = "GMT")
    Instant moment;
   
    OrderStatus orderStatus;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    User client;
    
    public Order(){

    }
    public Order(Long id,  Instant moment,  OrderStatus orderStatus,  User client) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public User getClient() {
        return client;
    }


    

 
    

}
