package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public List<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @PostMapping("/companies/{id}")
    public void addCompany(@PathVariable("id") int id){
        companyService.addCompany(new Company(id));
    }

    @GetMapping("/companies/{id}/employees")
    public List<Employee> getEmployeesFromCompanyId(@PathVariable("id") int id){
        return companyService.getEmployee(id);
    }


    //GET       /companies?page=1&pageSize=5
    @GetMapping("/companies?page=1&pageSize=5 ")
    public List<Company> getCompaniesByPage(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        return  companyService.getCompaniesByPage(page,pageSize);


    }


}
