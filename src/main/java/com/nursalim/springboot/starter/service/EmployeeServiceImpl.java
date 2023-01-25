package com.nursalim.springboot.starter.service;

import com.nursalim.springboot.starter.entity.Employee;
import com.nursalim.springboot.starter.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if(existingEmployee.isPresent()) {
            Employee updatingEmployee  = existingEmployee.get();
            updatingEmployee.setEmail(employee.getEmail());
            updatingEmployee.setFirstName(employee.getFirstName());
            updatingEmployee.setLastName(employee.getLastName());

            employeeRepository.save(updatingEmployee);

            return updatingEmployee;
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        employee.orElseThrow(() -> {
            return new IllegalArgumentException("Employee not found");
        });
        employeeRepository.delete(employee.get());
    }
}
