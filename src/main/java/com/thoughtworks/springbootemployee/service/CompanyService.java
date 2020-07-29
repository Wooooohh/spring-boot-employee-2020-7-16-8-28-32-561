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

    {
        List<Employee> lists = new ArrayList<>();
        lists.add(new Employee(1, "female"));
        lists.add(new Employee(2, "male"));
        companyMap.put(1, lists);
    }

    public CompanyService() {
    }

    public List<Company> getCompanies() {
        return companyList;
    }

    public void addCompany(Company company) {
        companyList.add(company);
    }

    public List<Employee> getEmployee(int companyId) {
        return companyMap.get(companyId);
    }

    public List<Company> getCompaniesByPage(int page, int pageSize) {
        List<Company> companies = new ArrayList<>();
        int start = (page - 1) * pageSize;
        int end = page * pageSize;
        for (int i = start; i < end; i++) {
            companies.add(companyList.get(i));
        }
        return companies;
    }

    public Company getCompany(int companyId) {
        for (Company company : companyList) {
            if (company.getCompanyId() == companyId) {
                return company;
            }
        }
        return null;
    }

    public void updateCompany(int companyId, Company company) {
        for (int i = 0; i < companyList.size(); i++) {
            if (companyList.get(i).getCompanyId() == companyId) {
                companyList.set(i, company);
            }
        }
    }

    public void deleteCompanyEmployees(int companyId) {
        companyMap.remove(companyId);
    }
}
