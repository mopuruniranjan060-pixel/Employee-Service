package com.niranjan.employeemanagementsystem.Controller;

import com.niranjan.employeemanagementsystem.Entity.Employee;
import com.niranjan.employeemanagementsystem.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll() { return service.getAll(); }

    @PostMapping("/v1")
    public Employee create(@RequestBody Employee e) {
        return service.save(e); }

    @GetMapping("/department/{dept}")
    public List<Employee> getByDepartment(@PathVariable String dept) {
        return service.getByDepartment(dept);
    }

    @GetMapping("/role/{role}")
    public List<Employee> getByRole(@PathVariable String role) {
        return service.getByRole(role);
    }

    @GetMapping("/salary/{minSalary}")
    public List<Employee> getHighEarners(@PathVariable Double minSalary) {
        return service.getHighEarners(minSalary);
    }

    @GetMapping("/status/{status}")
    public List<Employee> getByStatus(@PathVariable String status) {
        return service.getByStatus(status);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.
            delete(id); }
}

