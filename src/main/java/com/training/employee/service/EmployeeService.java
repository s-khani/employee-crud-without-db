package com.training.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.training.employee.entity.Employee;

@Service
public class EmployeeService {
    static List<Employee> employees = new ArrayList<>();
    static {
    	Employee x = new Employee();
    	
        employees.add(new Employee("1", "Samaneh", "Khani", "+37258959558", "s.khani@gmail.com"));
        employees.add(new Employee("2", "Parisa", "Najafi", "+989126706247", "p.najafi@gmail.com"));
        employees.add(new Employee("3", "Amir", "Jafari", "+37256179047", "a.jafari@gmail.com"));
    }


    public List<Employee> findAllEmployees() {
        /*List <Employee> employees = new ArrayList<>();
                employees =List.of(
                Employee.builder()
                        .id("1")
                        .firstName("Samaneh")
                        .lastName("Khani")
                        .phoneNumber("37258959558")
                        .emailAddress("s.khani@gmail.com")
                        .build(),
                Employee.builder()
                        .id("2")
                        .firstName("Parisa")
                        .lastName("Najafi")
                        .phoneNumber("+989126706247")
                        .emailAddress("p.najafi@gmail.com")
                        .build(),
                Employee.builder()
                        .id("3")
                        .firstName("Amir")
                        .lastName("Jafari")
                        .phoneNumber("+37256179047")
                        .emailAddress("a.jafari@gmail.com")
                        .build()
        );*/
        return employees;

    }

    public Employee findById(String id){
        /*Predicate<Employee> byId = e -> e.getId().equals(id);
        return filterEmployees(byId);
    }
    private Employee filterEmployees(Predicate<Employee> strategy){
        return findAllEmployees().stream().filter(strategy).findFirst().orElse(null);*/
       return employees.stream().filter(e -> e.getId().equals(id) ).findFirst().orElse(null);
    }

    public Employee addEmployee(Employee newEmployee){
        newEmployee.setId("4");
        return newEmployee;

    }


    public void updateEmp(String id, Employee newEmployee) {
        //newEmployee.setId(id);

        for (int i = 0; i< employees.size(); i++){
            Employee em = employees.get(i);
            if (em.getId().equals(id)){
                employees.set(i,newEmployee);
            }
        }


    }

    public void deleteEmp(String id){
        employees.removeIf(e -> e.getId().equals(id));
    }
}
