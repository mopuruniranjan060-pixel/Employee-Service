package com.niranjan.employeemanagementsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "EmployeeDb")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String role;
    private Double salary;
    private LocalDate dateOfJoining;
    private String address;
    private String status; // Active, Resigned, On Leave
    private String grade;  // A, B, C levels
    private String managerName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


}
