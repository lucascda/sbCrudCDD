package com.example.springbootcdd.controllers;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.example.springbootcdd.controllers.exceptions.ResourceNotFoundException;
import com.example.springbootcdd.entities.User;
import com.example.springbootcdd.repositories.UserRepository;
import com.example.springbootcdd.requests.CreateUserRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<User> create(@RequestBody @Valid CreateUserRequest request){
        User user = request.toModel();
        repository.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> list = repository.findAll();
        if(list.isEmpty()){
            throw new ResourceNotFoundException();
        }
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        try{
            Optional<User> user = repository.findById(id);
            return ResponseEntity.ok().body(user.get());
        }
        catch(NoSuchElementException e){
            throw new ResourceNotFoundException(id);
        }        

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @Valid @RequestBody CreateUserRequest request){
        try{
        Optional<User> user = repository.findById(id);
        updateData(user.get(), request.toModel());
        repository.save(user.get());

        return ResponseEntity.ok().body(user.get());
        }
        catch(NoSuchElementException e){
            throw new ResourceNotFoundException(id);
        }
        
        

}
    public void updateData(User oldUser, User newUser){
        oldUser.setEmail(newUser.getEmail());
        oldUser.setName(newUser.getName());
        oldUser.setPhone(newUser.getPhone());
    }

   

}
