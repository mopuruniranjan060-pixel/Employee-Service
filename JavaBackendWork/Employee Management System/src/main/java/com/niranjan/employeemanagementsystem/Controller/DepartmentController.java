package com.niranjan.employeemanagementsystem.Controller;

import com.niranjan.employeemanagementsystem.Entity.Department;
import com.niranjan.employeemanagementsystem.Service.DepartmentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Department> getAll() { return service.getAll(); }

    @PostMapping
    public Department create(@RequestBody Department d) { return service.save(d); }

    @GetMapping("/{name}")
    public Department getByName(@PathVariable String name) {
        return service.getByName(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) { service.delete(id); }
}

