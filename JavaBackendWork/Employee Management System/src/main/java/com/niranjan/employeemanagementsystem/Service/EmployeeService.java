package com.niranjan.employeemanagementsystem.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niranjan.employeemanagementsystem.DTO.EmployeeDTO;
import com.niranjan.employeemanagementsystem.Entity.Employee;
import com.niranjan.employeemanagementsystem.Kafka.EmployeeEventProducer;
import com.niranjan.employeemanagementsystem.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;
    private final ObjectMapper objectMapper;
    private final EmployeeEventProducer eventProducer;


    public EmployeeService(EmployeeRepository repo, ObjectMapper objectMapper, EmployeeEventProducer eventProducer) {

        this.repo = repo;
        this.objectMapper = objectMapper;
        this.eventProducer = eventProducer;
    }

    public List<Employee> getAll() {
        return repo.findAll(); }

    public Employee save(Employee e) {
        // Business rules
        if (e.getSalary() < 10000) {
            throw new IllegalArgumentException("Salary must be at least 10,000");
        }
        if (!e.getEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        Employee saved = repo.save(e);


        try {
            EmployeeDTO dto = new EmployeeDTO(saved.getId(), saved.getSalary());
            String employeeJson = objectMapper.writeValueAsString(dto);
            eventProducer.sendEmployeeEvent(employeeJson);
        } catch (Exception ex) {
            throw new RuntimeException("Error sending Kafka event", ex);
        }

        return saved;
    }

    public List<Employee> getByDepartment(String dept) {
        return repo.findByDepartment(dept); }

    public List<Employee> getByRole(String role) {
        return repo.findByRole(role); }

    public List<Employee> getHighEarners(Double minSalary) {
        return repo.findBySalaryGreaterThan(minSalary); }

    public List<Employee> getByStatus(String status) {
        return repo.findByStatus(status); }

    public void delete(Long id) {
        repo.deleteById(id); }
}

