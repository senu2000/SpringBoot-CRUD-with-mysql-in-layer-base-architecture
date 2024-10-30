package com.springbootexample.ems.service.impl;

import com.springbootexample.ems.dto.EmployeeDto;
import com.springbootexample.ems.entity.Employee;
import com.springbootexample.ems.exeption.IllegalStateException;
import com.springbootexample.ems.exeption.ResourceNotFoundExeption;
import com.springbootexample.ems.mapper.EmployeeMapper;
import com.springbootexample.ems.repository.EmployeeRepository;
import com.springbootexample.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmplyee(EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findEmployeeByEmail(employeeDto.getEmail());
        if (optionalEmployee.isPresent()) {
            throw new IllegalStateException("Email is already exist");
        }
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeByID(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(()-> new ResourceNotFoundExeption("Employee doesn't exist with ID:" + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployeeDto) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundExeption("Employee doesn't exist with ID:" + employeeId));
        employee.setEmail(updateEmployeeDto.getEmail());
        employee.setFirstName(updateEmployeeDto.getFirstName());
        employee.setLastName(updateEmployeeDto.getLastName());
        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundExeption("Employee doesn't exist with ID:" + employeeId));
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public List<EmployeeDto> getAllEmployeesByLastName(String lastName) {
        List<Employee> employees = employeeRepository.findEmployeesByLastName(lastName);
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }


}
