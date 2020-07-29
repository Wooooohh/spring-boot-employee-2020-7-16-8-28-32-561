package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") int employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "0") int pageSize,
            @RequestParam(required = false, defaultValue = "") String gender) {
        if (pageSize == 0) {
            if (!gender.equals("")) {
                return employeeService.getEmployeesByGender(gender);
            }
            return employeeService.getEmployees();
        }
        return employeeService.getEmployeesByPage(page, pageSize);
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public void updateEmployee(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee) {
        employeeService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

}
