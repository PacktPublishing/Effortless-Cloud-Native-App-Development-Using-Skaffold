package com.packt.chapter6.reactive.service;

import com.packt.chapter6.reactive.model.Employee;
import com.packt.chapter6.reactive.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Mono<Employee> createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Flux<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Mono<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Mono<Void> deleteEmployeeById(Long id) {
        return employeeRepository.deleteById(id);
    }
}
