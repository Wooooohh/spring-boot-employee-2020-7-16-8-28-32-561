package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.dto.EmployeeRequestDto;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") int employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping("/employees")
    public Page<Employee> getEmployeesByPage(@PageableDefault(page = 0,size = 1) Pageable pageable, @RequestParam( name = "unPage",defaultValue = "false") Boolean unPaged){
        if(unPaged){
            return employeeService.getCompaniesByPage(pageable);
        }
        return employeeService.getCompaniesByPage(Pageable.unpaged());
    }

    @GetMapping(value = "/employees", params = "gender")
    public List<Employee> getEmployeesByGender(@RequestParam String gender) {
        return employeeService.getEmployeesByGender(gender);
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        employeeService.addEmployee(employeeRequestDto);
    }

    @PutMapping("/{employeeId}")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

}
