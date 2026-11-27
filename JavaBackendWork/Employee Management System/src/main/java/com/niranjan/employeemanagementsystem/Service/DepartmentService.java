package com.niranjan.employeemanagementsystem.Service;

import com.niranjan.employeemanagementsystem.Entity.Department;
import com.niranjan.employeemanagementsystem.Repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository repo;

    public DepartmentService(DepartmentRepository repo) {
        this.repo = repo;
    }

    public List<Department> getAll() { return repo.findAll(); }

    public Department save(Department d) {
        if (d.getDeptName() == null || d.getDeptName().isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be empty");
        }
        return repo.save(d);
    }

    public Department getByName(String name) {
        return repo.findByDepartmentName(name); }

    public void delete(int id) {
        repo.deleteById(id); }
}

