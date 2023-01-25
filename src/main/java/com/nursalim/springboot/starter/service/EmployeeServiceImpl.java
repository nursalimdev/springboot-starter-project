package com.nursalim.springboot.starter.service;

import com.nursalim.springboot.starter.dto.EmployeeDto;
import com.nursalim.springboot.starter.entity.Employee;
import com.nursalim.springboot.starter.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // convert EmployeeDto into Employee class
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());

    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if(existingEmployee.isPresent()) {
            Employee updatingEmployee  = existingEmployee.get();
            updatingEmployee.setEmail(employee.getEmail());
            updatingEmployee.setFirstName(employee.getFirstName());
            updatingEmployee.setLastName(employee.getLastName());

            employeeRepository.save(updatingEmployee);

            return modelMapper.map(employee, EmployeeDto.class);
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

    @Override
    public List<EmployeeDto> searchEmployee(String query) {
        List<Employee> employees = employeeRepository.searchEmployee(query);
        List<EmployeeDto> employeesDto = employees.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());

        return employeesDto;
    }
}
