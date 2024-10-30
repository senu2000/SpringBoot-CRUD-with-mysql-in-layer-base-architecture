package com.springbootexample.ems.service;

import com.springbootexample.ems.dto.EmployeeDto;
import com.springbootexample.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmplyee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeByID(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployeeDto);

    void deleteEmployee(Long employeeId);

    List<EmployeeDto> getAllEmployeesByLastName(String lastName);
}
