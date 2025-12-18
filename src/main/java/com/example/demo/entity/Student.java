package com.example.demo.entity;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;

@Entity
 @Table(name="StudentTable")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message=" Name field cannot be empty")
    @Size(min=3,max=20,message="The user name must be of min 3 and max 20 character")
    private String name;
    @Email(message="Invalid email id")
    @Column(unique=true)
    private String email;
    private Int age;
    //@NotNull
    //@Size(min,max)(to reccomend the use to the give no of characters)
    //@Min
    //@Max
    //@Pattern(reg)(used for phone numbers)
    //@Positive(used in bank record detailling)
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
     public float getage() {
        return age;
    }
    public void setCgpa(float age) {
        this.age = age;
    }
    public Student(Long id, String name, String email,Int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public Student() {
    } 
}