package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") int employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping(params = "page")
    public Page<Employee> getEmployeesByPage(@PageableDefault(page = 0,size = 1) Pageable pageable, @RequestParam( name = "unPage",defaultValue = "false") Boolean unPaged){
        if(unPaged)
            return employeeService.getCompaniesByPage(pageable);
        return employeeService.getCompaniesByPage(Pageable.unpaged());
    }

    @GetMapping
    public List<Employee> getEmployees(
            @RequestParam(required = false, defaultValue = "") String gender) {
        return null;
    }

    @GetMapping(params = "gender")
    public List<Employee> getEmployeesByGender(
            @RequestParam(required = false, defaultValue = "") String gender) {
        return null;
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PutMapping("/{employeeId}")
    public void updateEmployee(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee) {
        employeeService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

}
