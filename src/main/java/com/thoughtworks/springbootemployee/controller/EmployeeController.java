package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") int employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployeesByPage(@RequestParam("page")int page,@RequestParam("pageSize") int pageSize){
        return employeeService.getEmployeesByPage(page,pageSize);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployeesByGender(@RequestParam("gender") String gender){
        return employeeService.getEmployeesByGender(gender);
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public void updateEmployee(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee){
        employeeService.updateEmployee(employeeId,employee);
    }


    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@RequestParam("employeeId")int employeeId){
        employeeService.deleteEmployee(employeeId);
    }

}
