package com.nursalim.springboot.starter.repository;

import com.nursalim.springboot.starter.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE " +
            "e.firstName LIKE CONCAT('%', :query, '%') " +
            "OR e.lastName LIKE CONCAT('%', :query, '%') " +
            "OR e.email LIKE CONCAT('%', :query, '%')"
    )
    List<Employee> searchEmployee(String query);
}
