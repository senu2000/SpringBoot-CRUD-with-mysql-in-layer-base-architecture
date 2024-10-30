package com.springbootexample.ems.repository;

import com.springbootexample.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeByEmail(String email);

    List<Employee> findEmployeesByLastName(String lastname);


}
