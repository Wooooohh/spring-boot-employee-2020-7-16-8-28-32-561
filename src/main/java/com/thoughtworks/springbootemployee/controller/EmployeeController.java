package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.dto.EmployeeRequest;
import com.thoughtworks.springbootemployee.dto.EmployeeResponse;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exception.CompanyNotFoundException;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") int employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping
    public Page<Employee> getEmployeesByPage(@PageableDefault(page = 0, size = 1) Pageable pageable, @RequestParam(name = "unPaged", defaultValue = "true") Boolean unPaged) {
        if (unPaged) {
            return employeeService.getCompaniesByPage(Pageable.unpaged());
        }
        return employeeService.getCompaniesByPage(pageable);

    }

    @GetMapping(params = "gender")
    public List<Employee> getEmployeesByGender(@RequestParam String gender) {
        return employeeService.getEmployeesByGender(gender);
    }

    @PostMapping
    public EmployeeResponse addEmployee(@RequestBody(required = true) @Valid EmployeeRequest employeeRequest) {
        return employeeService.addEmployee(employeeRequest);
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee( @PathVariable("employeeId") int employeeId, @RequestBody(required = true) @Valid EmployeeRequest employeeRequest) {
        return employeeService.updateEmployee(employeeId, employeeRequest);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

}
