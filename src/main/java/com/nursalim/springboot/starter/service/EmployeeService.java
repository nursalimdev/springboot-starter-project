package com.nursalim.springboot.starter.service;

import com.nursalim.springboot.starter.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Optional<Employee> getEmployeeById(Long id);
    List<Employee> getAllEmployee();
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);

}
