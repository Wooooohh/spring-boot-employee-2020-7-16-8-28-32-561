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

    @GetMapping("/companies/{companyId}")
    public Company getCompany(@PathVariable("companyId") int companyId){
        return companyService.getCompany(companyId);
    }

    @GetMapping("/companies/{id}/employees")
    public List<Employee> getEmployeesFromCompanyId(@PathVariable("companyId") int companyId){
        return companyService.getEmployee(companyId);
    }

    //GET       /companies?page=1&pageSize=5
    @GetMapping("/companies?page=1&pageSize=5")
    public List<Company> getCompaniesByPage(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        return  companyService.getCompaniesByPage(page,pageSize);
    }

    @PostMapping("/companies")
    public void addCompany(@RequestBody Company company){
        companyService.addCompany(company);
    }

    @PutMapping("/companies/{companyId}")
    public void updateCompany(@RequestParam("companyId") int companyId,@RequestBody Company company){
         companyService.updateCompany(companyId,company);
    }

    @DeleteMapping("/companies/{companyId}")
    public void deleteCompanyEmployees(@RequestParam("companyId") int companyId){
        companyService.deleteCompanyEmployees(companyId);
    }

}
