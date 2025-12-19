package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name field cannot be empty")
    @Size(min = 3, max = 20, message = "The user name must be min of 3 and max of 20 characters")
    private String name;

    @Email(message = "Invalid email id")
    @NotBlank(message = "Email cannot be empty")
    @Column(unique = true)
    private String email;

}