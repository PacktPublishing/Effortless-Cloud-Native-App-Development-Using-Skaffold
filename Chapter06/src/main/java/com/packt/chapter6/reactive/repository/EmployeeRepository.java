package com.packt.chapter6.reactive.repository;

import com.packt.chapter6.reactive.model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {
}
