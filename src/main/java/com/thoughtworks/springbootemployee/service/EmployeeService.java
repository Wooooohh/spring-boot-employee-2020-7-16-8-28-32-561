package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dto.EmployeeRequest;
import com.thoughtworks.springbootemployee.dto.EmployeeResponse;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exception.CompanyNotFoundException;
import com.thoughtworks.springbootemployee.exception.EmployeeNotFoundException;
import com.thoughtworks.springbootemployee.mapper.EmployeeMapper;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final CompanyRepository companyRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }


    public Employee getEmployee(int employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    public List<Employee> getEmployeesByGender(String gender) {
        return employeeRepository.findByGenderEquals(gender);
    }


    public Employee updateEmployee(int employeeId, EmployeeRequest employeeRequest) {
        Company company = companyRepository.findById(employeeRequest.getCompanyId()).orElseThrow(CompanyNotFoundException::new);
        Employee employee = EmployeeMapper.employeeRequestToEmployee(employeeId, employeeRequest, company);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(EmployeeNotFoundException::new);
        employeeRepository.deleteById(employee.getId());

    }

    public Page<Employee> getCompaniesByPage(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
        Company company = companyRepository.findById(employeeRequest.getCompanyId()).orElseThrow(CompanyNotFoundException::new);
        Employee employee = EmployeeMapper.employeeRequestToEmployee(employeeRequest, company);
        return EmployeeMapper.employeeToEmployeeResponse(employeeRepository.save(employee));
    }
}
