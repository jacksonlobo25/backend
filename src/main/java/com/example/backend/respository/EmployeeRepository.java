package com.example.backend.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
