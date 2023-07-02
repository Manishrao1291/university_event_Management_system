package com.geeks.university.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    private Integer studentId;

    @Pattern(regexp = "^[A-Z]*$")
    private String firstName;

    private String lastName;

    @Max(value = 25)
    @Min(value = 18)
    private int age;

    @Enumerated(EnumType.STRING)
    private Department department;
}
