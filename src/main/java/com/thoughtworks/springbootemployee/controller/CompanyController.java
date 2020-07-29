package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("companyController")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies/{companyId}/employees")
    public List<Employee> getEmployeesByCompanyId(@PathVariable("companyId") int companyId) {
        return companyService.getCompanyByCompanyId(companyId);
    }

    @GetMapping("/companies")
    public Page<Company> getCompaniesByPage(@PageableDefault(size = 2) Pageable pageable){
        return (Page<Company>) companyService.getCompaniesByPage(pageable);
    }

    @PostMapping("/companies")
    public void addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }

//    @PutMapping("/companies/{companyId}")
//    public void updateCompany(@PathVariable("companyId") int companyId, @RequestBody Company company) {
//        companyService.updateCompany(companyId, company);
//    }
//
//    @DeleteMapping("/companies/{companyId}")
//    public void deleteCompanyEmployees(@PathVariable("companyId") int companyId) {
//        companyService.deleteCompanyEmployees(companyId);
//    }
}
