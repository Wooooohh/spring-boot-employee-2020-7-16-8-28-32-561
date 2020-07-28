package com.thoughtworks.springbootemployee.service;


import com.thoughtworks.springbootemployee.entity.Company;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    List<Company> companyList = new ArrayList<>();

    public List<Company> getCompanies() {
        return companyList;
    }
}
