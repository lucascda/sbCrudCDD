package com.example.springbootcdd.config;

import java.time.Instant;
import java.util.Arrays;

import com.example.springbootcdd.entities.Order;
import com.example.springbootcdd.entities.OrderStatus;
import com.example.springbootcdd.entities.User;
import com.example.springbootcdd.repositories.OrderRepository;
import com.example.springbootcdd.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
              

        User u1 = new User("Maria das Dores", "mariadasdores@gmail.com", "123456789", "123456");
        User u2 = new User("Pedro Paulo", "pedropaulo@gmail.com", "999989795", "123456");
        User u3 = new User("Gabriela Alves", "gabialves@gmail.com", "999887766", "123456789");

        Order order1 = new Order(null,Instant.parse("2021-06-10T19:44:00Z"), OrderStatus.PAID, u1);
        Order order2 = new Order(null,Instant.parse("2021-06-15T07:30:30Z"), OrderStatus.SHIPPED, u2);
        Order order3 = new Order(null,Instant.parse("2021-05-07T23:40:49Z"), OrderStatus.DELIVERED, u3);

        userRepository.saveAll(Arrays.asList(u1,u2,u3));
        orderRepository.saveAll(Arrays.asList(order1,order2,order3));
    }
    
}
