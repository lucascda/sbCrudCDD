package com.example.springbootcdd.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_user")
public class User  {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    private String name;

    private String email;

    private String phone;

    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

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

    public void setName(String name) {
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

   
    
    

    
    
}
