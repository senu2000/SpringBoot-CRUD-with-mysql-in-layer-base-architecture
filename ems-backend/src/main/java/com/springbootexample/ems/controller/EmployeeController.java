package com.springbootexample.ems.controller;

import com.springbootexample.ems.dto.EmployeeDto;
import com.springbootexample.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

//    Build add employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmplyee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployeeDto = employeeService.createEmplyee(employeeDto);
        return new ResponseEntity<>(saveEmployeeDto, HttpStatus.CREATED);
    }

//    Build get employee by ID
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeByID(@PathVariable("id") Long employeeID){
        EmployeeDto employeeDto = employeeService.getEmployeeByID(employeeID);
        return ResponseEntity.ok(employeeDto);
    }

//    Build get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

//    Build update employee
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeID,
                                                      @RequestBody EmployeeDto upEmployeeDto){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeID, upEmployeeDto);
        return ResponseEntity.ok(employeeDto);
    }

//    Build delete employee
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeID){
        employeeService.deleteEmployee(employeeID);
        return ResponseEntity.ok("Successfully deleted");
    }

//    Build get all employee by lastname
    @GetMapping("lastname/{lastname}")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeesByLastName(@PathVariable("lastname") String lastname){
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployeesByLastName(lastname);
        return ResponseEntity.ok(employeeDtos);
    }
}
