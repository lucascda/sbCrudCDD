package com.example.springbootcdd.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.springbootcdd.entities.User;

public class CreateUserRequest {

    @NotBlank
    private String name;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min = 9, max = 9)
    private String phone;
    @NotBlank @Size(min = 6)
    private String password;

    public CreateUserRequest(@NotBlank String name, @NotBlank @Email String email,
            @NotBlank @Size(min = 9, max = 9) String phone, @NotBlank @Size(min = 6) String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public User toModel(){
        return new User(this.name, this.email, this.phone, this.password);
    }

    
    
}
