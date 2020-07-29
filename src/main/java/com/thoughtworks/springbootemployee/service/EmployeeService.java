package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee getEmployee(int employeeId) {
       return  employeeRepository.getOne(employeeId);
    }

    public List<Employee> getEmployeesByPage(int page, int pageSize) {
        return null;
    }

    public List<Employee> getEmployeesByGender(String gender) {
        return null;
    }

    public void addEmployee(Employee employee) {

    }

    public void updateEmployee(int employeeId, Employee employee) {

    }

    public void deleteEmployee(int employeeId) {

    }

    public Page<Employee> getCompaniesByPage(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}
