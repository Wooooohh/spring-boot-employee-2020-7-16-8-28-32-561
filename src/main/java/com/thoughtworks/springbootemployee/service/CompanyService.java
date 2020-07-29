package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Page<Company> getCompaniesByPage(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    public List<Employee> getEmployeesByCompanyId(int companyId){

        return companyRepository.findById(companyId).get().getEmployees();
    }

    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    public void updateCompany(Company company) {
        companyRepository.save(company);
    }

    public void deleteCompany(int companyId) {
        companyRepository.deleteById(companyId);
    }

    public Company getCompanyByCompanyId(int companyId) {
        return companyRepository.findById(companyId).get();
    }
}
