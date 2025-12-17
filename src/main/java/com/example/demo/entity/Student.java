package com.example.hoopa.entity;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private String email;
    private LocalDate dob;
    private float cgpa;
    public int getId() {
        return id;
    }
    public void setId(int id) {
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
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public float getCgpa() {
        return cgpa;
    }
    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }
    public Student(int id, String name, String email, LocalDate dob, float cgpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.cgpa = cgpa;
    }
    public Student() {
    }

}
