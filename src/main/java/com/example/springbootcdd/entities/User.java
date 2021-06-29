package com.example.springbootcdd.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_user")
public class User {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min = 9, max = 9)
    private String phone;
    @NotBlank @Size(min = 6)
    private String password;

    public User(){
        
    }

    public User(@NotBlank String name, @NotBlank @Email String email, @NotBlank @Size(min = 9, max = 9) String phone,
            @NotBlank @Size(min = 6) String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public Long getId(){
        return id;
    }

    public String getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }

    

    
    
}
