package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.exception.CompanyNotFoundException;
import com.thoughtworks.springbootemployee.dto.EmployeeRequestDto;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
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

    public void addEmployee(EmployeeRequestDto employeeRequestDto) throws CompanyNotFoundException {
        Employee employee = employeeRequestDto.toEntity();

        try{
            Company company = companyRepository.findById(employeeRequestDto.getCompanyId()).get();
            employee.setCompany(company);
            employeeRepository.save(employee);
        }catch (Exception e){
            CompanyNotFoundException companyNotFoundException = new CompanyNotFoundException("company id not found");
            throw companyNotFoundException;
        }


    }


    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);

    }

    public Page<Employee> getCompaniesByPage(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}
