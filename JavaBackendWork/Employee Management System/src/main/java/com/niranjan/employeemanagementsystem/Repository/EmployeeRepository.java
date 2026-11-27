package com.niranjan.employeemanagementsystem.Repository;

import com.niranjan.employeemanagementsystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartment(String department);
    List<Employee> findByRole(String role);
    List<Employee> findBySalaryGreaterThan(double salary);
    List<Employee> findByStatus(String status);
}
