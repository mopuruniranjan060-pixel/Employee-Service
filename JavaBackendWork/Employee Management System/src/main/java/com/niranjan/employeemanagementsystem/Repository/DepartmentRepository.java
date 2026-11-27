package com.niranjan.employeemanagementsystem.Repository;

import com.niranjan.employeemanagementsystem.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findByDeptName(String deptName);
}
