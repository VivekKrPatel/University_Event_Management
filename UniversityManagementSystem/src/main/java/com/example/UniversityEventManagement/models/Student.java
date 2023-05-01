package com.example.UniversityEventManagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;

    @NotNull(message = "first name cannot be null")
    @Pattern(regexp = "^[A-Z][a-z]*$", message = "First name should have the first letter capital")
    private String firstName;
    private String lastName;

    @Min(value = 18,message = "age should be greater than 18")
    @Max(value = 25,message = "age should be lesser than 25")
    private Integer age;

    @Enumerated(EnumType.STRING)
    private StudentDept department;
}
