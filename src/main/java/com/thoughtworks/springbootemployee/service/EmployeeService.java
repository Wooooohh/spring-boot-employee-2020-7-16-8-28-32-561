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

    public List<Employee> getEmployeesByPage(int page, int pageSize) {
        List<Employee> employees = new ArrayList<>();
        int start = (page-1)*pageSize;
        int end = page*pageSize;
        for (int i = start; i <end ; i++) {
            employees.add(employeeList.get(i));
        }
        return employees;
    }

    public List<Employee> getEmployeesByGender(String gender) {
        List<Employee> employees = new ArrayList<>();
        for(int i = 0; i < employeeList.size(); i++){
            if(employeeList.get(i).getGender().equals(gender))
                employees.add(employeeList.get(i));
        }
        return employees;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void updateEmployee(int employeeId, Employee employee) {
        for(int i = 0; i < employeeList.size(); i++){
            if(employeeList.get(i).getEmployeeId() == employee.getEmployeeId())
                employeeList.set(i, employee);
        }
    }
}
