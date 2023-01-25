package com.nursalim.springboot.starter.service;

import com.nursalim.springboot.starter.dto.EmployeeDto;
import com.nursalim.springboot.starter.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
    void deleteEmployee(Long id);

}
