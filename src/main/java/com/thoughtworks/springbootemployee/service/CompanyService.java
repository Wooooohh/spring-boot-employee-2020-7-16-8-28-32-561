package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dto.CompanyRequest;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.mapper.CompanyMapper;
import com.thoughtworks.springbootemployee.mapper.EmployeeMapper;
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

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company updateCompany(int companyId, CompanyRequest companyRequest) {
        Company company = companyRepository.findById(companyId).get();
        Company company1 = CompanyMapper.companyRequestToCompany(company.getCompanyId(), companyRequest, company);
        return companyRepository.save(company1);
    }

    public void deleteCompany(int companyId) {
        companyRepository.deleteById(companyId);
    }

    public Company getCompanyByCompanyId(int companyId) {
        return companyRepository.findById(companyId).get();
    }
}
