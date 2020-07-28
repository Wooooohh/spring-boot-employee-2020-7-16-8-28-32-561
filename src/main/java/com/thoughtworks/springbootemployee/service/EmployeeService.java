package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employeeList;
    }

    public Employee getEmployee(int employeeId) {
        for(int i = 0; i < employeeList.size(); i++){
            if(employeeList.get(i).getEmployeeId() == employeeId)
                return employeeList.get(i);
        }
        return null;
    }
}
