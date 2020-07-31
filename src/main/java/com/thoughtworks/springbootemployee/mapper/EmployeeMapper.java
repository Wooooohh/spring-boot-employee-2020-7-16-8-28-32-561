package com.thoughtworks.springbootemployee.mapper;

import com.thoughtworks.springbootemployee.dto.EmployeeRequest;
import com.thoughtworks.springbootemployee.dto.EmployeeResponse;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;

public class EmployeeMapper {

    public static Employee employeeRequestToEmployee(EmployeeRequest employeeRequest, Company company){
        return new Employee(
                employeeRequest.getName(),
                employeeRequest.getGender(),
                company
        );
    }

    public static EmployeeResponse employeeToEmployeeResponse(Employee employee){
        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getAge(),
                employee.getCompany().getName()
        );
    }
}
