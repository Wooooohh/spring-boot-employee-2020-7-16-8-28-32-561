package com.thoughtworks.springbootemployee.mapper;

import com.thoughtworks.springbootemployee.dto.CompanyRequest;
import com.thoughtworks.springbootemployee.entity.Company;

public class CompanyMapper {

    public static Company companyRequestToCompany(int companyId, CompanyRequest companyRequest, Company company){
        Company resultCompany = new Company();
        resultCompany.setCompanyId(companyId);
        resultCompany.setEmployees(company.getEmployees());
        resultCompany.setName(companyRequest.getName());
        return resultCompany;

    }
}
