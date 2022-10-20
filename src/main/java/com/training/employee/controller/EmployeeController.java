package com.training.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.employee.entity.Employee;
import com.training.employee.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/employees")
@Api(value = "",tags ={"Employment"} )
@Tag(name="Employment",description = "HTTP methods in Springboot")
public class EmployeeController {

    private final EmployeeService employeeService;
 

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id){
        //log.info("getting the Employee by id : [{}]", id);
       Employee employee =  employeeService.findById(id);
       if(employee == null){
           return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addNewEmployee(@RequestBody Employee newEmployee){

        return employeeService.addEmployee(newEmployee);

    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable("id") String id,@RequestBody Employee newEmployee){

         employeeService.updateEmp(id,newEmployee);


    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable String id){
        employeeService.deleteEmp(id);
    }

}
