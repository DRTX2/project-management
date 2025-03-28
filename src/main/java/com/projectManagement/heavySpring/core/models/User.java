package com.projectManagement.heavySpring.core.models;

import java.time.LocalDateTime;
import java.util.Date;

public class User {
    Long id;
    String name;
    String email;
    String password;
    String role;
    LocalDateTime registrationDate;
//    List<Project> projects;

    public User(Long id, String name, String email, String password, String role, LocalDateTime registrationDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.registrationDate = registrationDate;
    }

    public void validate(){
        if(password ==null || password.length()<8)
            throw new IllegalArgumentException("Password must be at last 8 characters");
        if(email==null || !email.contains("@") )
            throw new IllegalArgumentException("Email not valid");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
