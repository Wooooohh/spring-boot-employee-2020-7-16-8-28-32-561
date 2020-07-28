package com.thoughtworks.springbootemployee.service;


import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyService {

    List<Company> companyList = new ArrayList<>();

    Map<Integer, List<Employee>> companyMap = new HashMap<>();

    public List<Company> getCompanies() {
        return companyList;
    }

    public void addCompany(Company company) {
        companyList.add(company);
    }

    public List<Employee> getEmployee(int id) {
        return companyMap.get(id);
    }
}
